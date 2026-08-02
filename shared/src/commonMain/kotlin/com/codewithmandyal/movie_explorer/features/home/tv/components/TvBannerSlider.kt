package com.codewithmandyal.movie_explorer.features.home.tv.components

import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.codewithmandyal.movie_explorer.core.components.SpaceVertical
import com.codewithmandyal.movie_explorer.domain.model.Movie
import kotlinx.coroutines.delay

@Composable
fun TvBannerSlider(
    watchRequester: FocusRequester,
    upRequester: FocusRequester,
    downRequester: FocusRequester,
    banners: List<Movie>,
    modifier: Modifier = Modifier,
    onWatchNow: (Int) -> Unit = {},
    onDetailsScreen: (Int) -> Unit,
    onWatchNowFocused: () -> Unit = {}
) {

    if (banners.isEmpty()) return

    var currentIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    var bannerHasFocus by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(
        banners.size,
        bannerHasFocus
    ) {

        while (true) {

            delay(5000)

            if (!bannerHasFocus) {

                currentIndex =
                    (currentIndex + 1) % banners.size
            }
        }
    }



    Column(
        modifier = modifier.fillMaxWidth()
    ) {

        Crossfade(
            targetState = currentIndex,
            animationSpec = tween(800),
            label = "TvBannerAnimation"
        ) { index ->

            TvBanner(
                watchRequester = watchRequester,
                upRequester = upRequester,
                downRequester = downRequester,
                movie = banners[index],
                onWatchNow = onWatchNow,
                onDetailsScreen = onDetailsScreen,
                onBannerFocusChanged = {
                    bannerHasFocus = it
                },
                onWatchNowFocused = {
                    onWatchNowFocused()
                }
            )
        }

        SpaceVertical(20.dp)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            repeat(banners.size) { index ->

                val width by animateDpAsState(
                    targetValue =
                        if (index == currentIndex) 36.dp else 10.dp,
                    animationSpec = tween(350),
                    label = "IndicatorWidth"
                )

                val color by animateColorAsState(
                    targetValue =
                        if (index == currentIndex)
                            Color.Red //MaterialTheme.colorScheme.primary
                        else
                            Color.White.copy(alpha = .25f),
                    animationSpec = tween(350),
                    label = "IndicatorColor"
                )

                Box(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .width(width)
                        .height(8.dp)
                        .clip(RoundedCornerShape(50))
                        .background(color)
                )
            }
        }
    }
}