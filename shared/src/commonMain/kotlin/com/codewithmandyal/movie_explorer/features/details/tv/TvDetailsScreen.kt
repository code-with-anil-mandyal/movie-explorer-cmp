package com.codewithmandyal.movie_explorer.features.details.tv

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.codewithmandyal.movie_explorer.core.components.ErrorView
import com.codewithmandyal.movie_explorer.core.components.LoaderView
import com.codewithmandyal.movie_explorer.core.utils.MediaType
import com.codewithmandyal.movie_explorer.features.details.common.DetailsIntent
import com.codewithmandyal.movie_explorer.features.details.common.DetailsViewModel
import com.codewithmandyal.movie_explorer.features.details.tv.components.TvDetailsContent
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun TvDetailsScreen(
    onBackPress: () -> Unit,
    movieId: Int,
    mediaType: MediaType,
    viewModel: DetailsViewModel = koinViewModel(),
    viewAllImages: (movieId: Int, mediaType: MediaType) -> Unit,
    onViewDetails: (movieId: Int, mediaType: MediaType) -> Unit
){
    val state by viewModel.state.collectAsState()

    LaunchedEffect(movieId) {
        if (state.banners.isEmpty()) {
            viewModel.onIntent(DetailsIntent.FetchDetailsData(movieId, mediaType))
        }

    }


    when {
        state.isLoading -> {
            LoaderView()
        }

        state.error != null -> {
            ErrorView(state.error!!, onRetry = {
                viewModel.onIntent(DetailsIntent.Retry)
            })
        }

        else ->{

            Box(
                modifier = Modifier.fillMaxSize()
                    .background(Color(0xFF0F0F0F))
            ){

                state.details?.let {
                    TvDetailsContent(
                        onBackPress = {
                            onBackPress()
                        },
                        state.banners,
                        credits = state.credits!!,
                        it,
                        state.recommendedMovies,
                        state.similarMovies,
                        state.videos,
                        state.reviews,
                        mediaType,
                        viewAllImages = {
                            viewAllImages(movieId, mediaType)
                        },
                        onDetailsScreen = { id ->
                            onViewDetails(id, mediaType)
                        }
                    )
                }


            }

        }

    }

}