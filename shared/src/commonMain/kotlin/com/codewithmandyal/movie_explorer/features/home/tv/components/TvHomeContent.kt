package com.codewithmandyal.movie_explorer.features.home.tv.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import com.codewithmandyal.movie_explorer.domain.model.Movie
import com.codewithmandyal.movie_explorer.features.home.tv.TvHomeFocusState

@Composable
fun TvHomeContent(
    banners: List<Movie>
){
    val focusState = remember { TvHomeFocusState() }

    Column(
        modifier = Modifier.fillMaxSize()
    ){
        TvTopBar(
            focusRequester = focusState.topBar,
            downRequester = focusState.watchNow,
            onSearchClick = {},
            onSettingsClick = {}
        )

        TvBannerSlider(
            watchRequester = focusState.watchNow,
            upRequester = focusState.topBar,
            downRequester = focusState.trending,
            banners = banners,
            onDetailsScreen = { movieId -> },
            onWatchNow = { movieId -> }
        )
    }

    LazyColumn {
//        item {
//            TvTopBar(
//                focusRequester = topBarRequester,
//                downRequester = watchRequester,
//                onSearchClick = {
//
//                },
//                onSettingsClick = {
//
//                }
//            )
//        }
//
//        item {
//            TvBannerSlider(
//                watchRequester = watchRequester,
//                upRequester = topBarRequester,
//                banners.take(5),
//                onDetailsScreen = { movieId ->
//
//                },
//                onWatchNow = { movieId ->
//
//                }
//            )
//        }

        item {
            TvContentRow()
        }
    }
}