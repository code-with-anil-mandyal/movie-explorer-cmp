package com.codewithmandyal.movie_explorer.features.details.defaults.components.banner

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
import com.codewithmandyal.movie_explorer.domain.model.Banner
import com.codewithmandyal.movie_explorer.domain.model.Movie
import kotlinx.coroutines.delay

@Composable
fun DetailsScreenBanners(
    banners: List<Banner>,
    movie: Movie,
    modifier: Modifier = Modifier
) {

    if (banners.isEmpty()) return

    var currentIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    LaunchedEffect(banners.size) {

        while (true) {

            delay(3000)

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

        _root_ide_package_.com.codewithmandyal.movie_explorer.features.details.defaults.components.banner.DetailsBanner(
            banner = banners[index],
            movie = movie
        )
    }
}