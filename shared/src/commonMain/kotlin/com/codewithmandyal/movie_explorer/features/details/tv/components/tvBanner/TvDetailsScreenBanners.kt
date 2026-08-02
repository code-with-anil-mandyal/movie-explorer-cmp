package com.codewithmandyal.movie_explorer.features.details.tv.components.tvBanner

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import com.codewithmandyal.movie_explorer.domain.model.Banner
import com.codewithmandyal.movie_explorer.domain.model.Movie
import kotlinx.coroutines.delay

@Composable
fun TvDetailsScreenBanners(
    banners: List<Banner>,
    movie: Movie,
    modifier: Modifier = Modifier,
    watchRequester: FocusRequester,
    watchListRequester: FocusRequester,
    upRequester: FocusRequester,
    downRequester: FocusRequester
) {

    if (banners.isEmpty()) return

    var currentIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    LaunchedEffect(banners.size) {

        while (true) {

            delay(5000)

            currentIndex =
                (currentIndex + 1) % banners.size
        }
    }

    Crossfade(
        targetState = currentIndex,
        animationSpec = tween(800),
        label = "BannerAnimation",
        modifier = modifier.fillMaxWidth()
    ) { index ->

        TvDetailsBanner(
            banner = banners[index],
            movie = movie,
            watchRequester = watchRequester,
            watchListRequester = watchListRequester,
            upRequester = upRequester,
            downRequester = downRequester
        )
    }
}

