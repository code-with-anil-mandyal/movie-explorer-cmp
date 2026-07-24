package com.codewithmandyal.movie_explorer.features.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codewithmandyal.movie_explorer.core.utils.MediaType
import com.codewithmandyal.movie_explorer.domain.usecase.GetCreditsUseCase
import com.codewithmandyal.movie_explorer.domain.usecase.GetMovieBannersUseCase
import com.codewithmandyal.movie_explorer.domain.usecase.GetMovieDetailsUseCase
import com.codewithmandyal.movie_explorer.domain.usecase.GetMovieTrailerVideoUseCase
import com.codewithmandyal.movie_explorer.domain.usecase.GetRecommendedUseCase
import com.codewithmandyal.movie_explorer.domain.usecase.GetReviewsUseCase
import com.codewithmandyal.movie_explorer.domain.usecase.GetSimilarUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val getMovieBannersUseCase: GetMovieBannersUseCase,
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
    private val getCreditsUseCase: GetCreditsUseCase,
    private val getRecommendedMoviesUseCase: GetRecommendedUseCase,
    private val getSimilarMoviesUseCase: GetSimilarUseCase,
    private val getMovieTrailerVideoUseCase: GetMovieTrailerVideoUseCase,
    private val getReviewsUseCase: GetReviewsUseCase
): ViewModel() {

    private val _state = MutableStateFlow(DetailsState())
    val state = _state.asStateFlow()

    private var currentMovieId: Int = -1
    private var mediaType : MediaType = MediaType.MOVIE


    fun onIntent(intent: DetailsIntent) {
        when (intent) {
            is DetailsIntent.FetchDetailsData -> {
                currentMovieId = intent.movieId
                mediaType = intent.mediaType
                fetchDetailsData(intent.movieId, intent.mediaType)
            }

            DetailsIntent.Retry -> {
                fetchDetailsData(currentMovieId, mediaType)
            }
        }
    }

    private fun fetchDetailsData(movieId: Int, mediaType: MediaType) {
        viewModelScope.launch {

            _state.update {
                it.copy(
                    isLoading = true,
                    error = null
                )
            }

            try {

                val detailsState = loadDetailsContent(movieId, mediaType)

                _state.value = detailsState.copy(
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

    private suspend fun loadDetailsContent(movieId: Int, mediaType: MediaType): DetailsState = coroutineScope {

        val getBanners = async {
            getMovieBannersUseCase(movieId, mediaType)
        }

        val details = async {
            getMovieDetailsUseCase(movieId)
        }

        val credits = async {
            getCreditsUseCase(movieId)
        }

        val recommended = async {
            getRecommendedMoviesUseCase(movieId, mediaType)
        }

        val similar = async {
            getSimilarMoviesUseCase(movieId, mediaType)
        }

        val videos = async {
            getMovieTrailerVideoUseCase(movieId)
        }

        val reviews = async {
            getReviewsUseCase(movieId)
        }


        DetailsState(
            banners = getBanners.await(),
            details = details.await(),
            credits = credits.await(),
            recommendedMovies = recommended.await(),
            similarMovies = similar.await(),
            videos = videos.await(),
            reviews = reviews.await(),
        )
    }

}