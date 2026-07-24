package com.codewithmandyal.movie_explorer.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codewithmandyal.movie_explorer.core.utils.MediaType
import com.codewithmandyal.movie_explorer.core.utils.thirtyDaysAgo
import com.codewithmandyal.movie_explorer.core.utils.today
import com.codewithmandyal.movie_explorer.domain.usecase.GetDiscoverUseCase
import com.codewithmandyal.movie_explorer.domain.usecase.GetNowPlayingMoviesUseCase
import com.codewithmandyal.movie_explorer.domain.usecase.GetPopularUseCase
import com.codewithmandyal.movie_explorer.domain.usecase.GetTopRatedMoviesUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getDiscoverUseCase: GetDiscoverUseCase,
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase,
    private val getPopularMoviesUseCase: GetPopularUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    fun onIntent(intent: HomeIntent) {
        when (intent) {
            HomeIntent.FetchHomeData -> fetchHomeData()
            HomeIntent.Retry -> fetchHomeData()
        }
    }

    private fun fetchHomeData() {

        viewModelScope.launch {

            _state.update {
                it.copy(
                    isLoading = true,
                    error = null
                )
            }

            try {

                val homeState = loadHomeContent()

                _state.value = homeState.copy(
                    isLoading = false
                )

            } catch (e: Exception) {

                _state.update {
                    it.copy(
                        isLoading = false,
                        error = e.message ?: "Something went wrong"
                    )
                }


            }
        }
    }


    private suspend fun loadHomeContent(): HomeState = coroutineScope {

        val discoverMoviesDeferred = async {
            getDiscoverUseCase(mediaType = MediaType.MOVIE)
        }

        val discoverTvDeferred = async {
            getDiscoverUseCase(mediaType = MediaType.TV)
        }

        val topRatedMovies = async {
            getTopRatedMoviesUseCase(page = 1, mediaType = MediaType.MOVIE)
        }

        val topRatedTv = async {
            getTopRatedMoviesUseCase(page = 1, mediaType = MediaType.TV)
        }

        val nowPlaying = async {
            getNowPlayingMoviesUseCase(
                today(),
                thirtyDaysAgo()
            )
        }

        val popularMovies = async {
            getPopularMoviesUseCase(1, MediaType.MOVIE)
        }

        val popularTv = async {
            getPopularMoviesUseCase(1, MediaType.TV)
        }

        HomeState(
            discoverMovies = discoverMoviesDeferred.await(),
            discoverTv = discoverTvDeferred.await(),
            topRatedMovies = topRatedMovies.await(),
            topRatedTv = topRatedTv.await(),
            nowPlayingMovies = nowPlaying.await(),
            popularMovies = popularMovies.await(),
            popularTv = popularTv.await()
        )
    }
}