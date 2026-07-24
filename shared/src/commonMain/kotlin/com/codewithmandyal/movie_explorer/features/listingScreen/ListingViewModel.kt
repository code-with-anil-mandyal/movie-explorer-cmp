package com.codewithmandyal.movie_explorer.features.listingScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codewithmandyal.movie_explorer.core.utils.ListingType
import com.codewithmandyal.movie_explorer.core.utils.MediaType
import com.codewithmandyal.movie_explorer.domain.usecase.GetPopularUseCase
import com.codewithmandyal.movie_explorer.domain.usecase.GetTopRatedMoviesUseCase
import com.codewithmandyal.movie_explorer.domain.usecase.GetTrendingUseCase
import com.codewithmandyal.movie_explorer.domain.usecase.SearchUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.Resource

class ListingViewModel(
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    private val getPopularMoviesUseCase: GetPopularUseCase,
    private val getTrendingUseCase: GetTrendingUseCase,
    private val searchUseCase: SearchUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(ListingState())

    var state = _state.asStateFlow()

    private var currentMovieId: Int = -1
    private var mediaType : MediaType = MediaType.MOVIE

    private var listingType : ListingType = ListingType.TOP_RATED

    private var searchQuery = ""

    init {
        observeSearchQuery()
    }

    fun onEvent(event: ListingEvent) {
        when (event) {

            is ListingEvent.OnSearchQueryChanged -> {
                onSearchQueryChanged(event.query)
            }
        }
    }

    private fun observeSearchQuery() {

        viewModelScope.launch {

            state
                .map { it.query }
                .debounce(500)
                .distinctUntilChanged()
                .collectLatest { query ->



                    if (query.isBlank()) {
                        _state.update {
                            it.copy(results = emptyList())
                        }
                    } else {
                        searchMovies(query)
                    }
                }
        }
    }

    private suspend fun searchMovies(query: String) {


        searchQuery = query

        _state.update {
            it.copy(error = null)
        }

        try {

            val result = searchUseCase(1, query)



            _state.update {
                it.copy(
                    results = result,
                    currentPage = 1,
                    endReached = result.size < 20
                )
            }

        } catch (e: Exception) {



            _state.update {
                it.copy(
                    error = e.message ?: "Something went wrong"
                )
            }
        }
    }

    fun onIntent(intent: ListingIntent) {
        when (intent) {

            is ListingIntent.FetchListingData -> {
                mediaType = intent.mediaType
                listingType = intent.listingType
                fetchData(reset = true)
            }

            ListingIntent.LoadNextPage -> {
                loadNextPage()
            }

            ListingIntent.Retry -> {
                fetchData(reset = true)
            }
        }
    }

    fun onSearchQueryChanged(query: String) {



        _state.update {
            it.copy(query = query)
        }

    }

    private fun loadNextPage() {

        val state = _state.value

        if (state.isLoadingMore || state.endReached) return

        viewModelScope.launch {

            _state.update {
                it.copy(isLoadingMore = true)
            }

            try {

                val nextPage = state.currentPage + 1

                val movies =  when(listingType){
                    ListingType.POPULAR -> {
                        getPopularMoviesUseCase(page = nextPage, mediaType)
                    }

                    ListingType.TOP_RATED ->{
                        getTopRatedMoviesUseCase(page = nextPage, mediaType)
                    }

                    ListingType.TRENDING -> {
                        getTrendingUseCase(page = nextPage, mediaType)
                    }
                    ListingType.SEARCH -> {
                       searchUseCase(page = nextPage, searchQuery)
                    }
                }


                _state.update {

                    it.copy(
                        results = it.results + movies,
                        currentPage = nextPage,
                        isLoadingMore = false,
                        endReached = movies.isEmpty()
                    )
                }

            } catch (e: Exception) {

                _state.update {
                    it.copy(
                        isLoadingMore = false,
                        error = e.message
                    )
                }
            }
        }
    }

    private fun fetchData(reset: Boolean) {


        viewModelScope.launch {

            _state.update {
                it.copy(
                    results = if (reset) emptyList() else it.results,
                    isLoading = true,
                    error = null,
                    currentPage = 1,
                    endReached = false
                )
            }

            try {

                val movies =  when(listingType){
                    ListingType.POPULAR -> {
                        getPopularMoviesUseCase(page = 1, mediaType)
                    }

                    ListingType.TOP_RATED ->{
                        getTopRatedMoviesUseCase(page = 1, mediaType)
                    }

                    ListingType.TRENDING -> {
                        getTrendingUseCase(page = 1, mediaType)
                    }
                    ListingType.SEARCH -> {
                        searchUseCase(page = 1, searchQuery)
                    }
                }

                _state.update {
                    it.copy(
                        results = movies,
                        isLoading = false,
                        currentPage = 1,
                        endReached = movies.size < 20
                    )
                }

            } catch (e: Exception) {

                _state.update {
                    it.copy(
                        isLoading = false,
                        error = e.message
                    )
                }
            }
        }
    }


}