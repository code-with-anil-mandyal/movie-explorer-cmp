package com.codewithmandyal.movie_explorer.features.home

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
import com.codewithmandyal.movie_explorer.core.utils.ListingType
import com.codewithmandyal.movie_explorer.core.utils.MediaType
import com.codewithmandyal.movie_explorer.domain.model.Movie
import com.codewithmandyal.movie_explorer.features.home.components.HomeContent
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel(),
    onDetailsScreen: (id: Int, mediaType: MediaType) -> Unit,
    onListingScreen: (listingType: ListingType) -> Unit
){


    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit){
        if (state.nowPlayingMovies.isEmpty()) {
            viewModel.onIntent(HomeIntent.FetchHomeData)
        }

    }

    when{
        state.isLoading  ->{
            LoaderView()
        }

        state.error != null -> {
            ErrorView(state.error!!, onRetry = {
                viewModel.onIntent(HomeIntent.Retry)
            })
        }

        else -> {
            Box(
                modifier = Modifier.fillMaxSize()
                    .background(Color(0xFF0F0F0F))
            ){

                HomeContent(
                    state.discoverMovies,
                    state.discoverTv,
                    state.topRatedMovies,
                    state.topRatedTv,
                    state.nowPlayingMovies,
                    state.popularMovies,
                    state.popularTv,
                    onDetailsScreen = { id, mediaType ->
                        onDetailsScreen(id, mediaType)
                    },
                    onListingScreen = {

                        onListingScreen(it)
                    }
                )


            }
        }
    }


}