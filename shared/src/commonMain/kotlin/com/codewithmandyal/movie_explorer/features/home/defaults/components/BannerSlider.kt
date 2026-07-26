package com.codewithmandyal.movie_explorer.features.home.defaults.components

import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.codewithmandyal.movie_explorer.core.components.SpaceVertical
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.LocalAppDimens
import com.codewithmandyal.movie_explorer.domain.model.Movie
import kotlinx.coroutines.delay

@Composable
fun BannerSlider(
    banners: List<Movie>,
    modifier: Modifier = Modifier,
    onDetailsScreen: (id: Int) -> Unit
) {

    val dimens = LocalAppDimens.current

    if (banners.isEmpty()) return

    var currentIndex by rememberSaveable { mutableIntStateOf(0) }

    LaunchedEffect(banners.size) {
        while (true) {
            delay(3000)
            currentIndex = (currentIndex + 1) % banners.size
        }
    }

    Column(
        modifier = modifier.fillMaxWidth()
    ) {

        Crossfade(
            targetState = currentIndex,
            animationSpec = tween(800),
            label = "BannerAnimation"
        ) { index ->

            HomeBanner(
                movie = banners[index],
                onDetailsScreen = onDetailsScreen
            )
        }

        SpaceVertical(dimens.itemSpacing)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            repeat(banners.size) { index ->

                val width by animateDpAsState(
                    targetValue = if (index == currentIndex) 32.dp else 6.dp,
                    animationSpec = tween(
                        durationMillis = 350,
                        easing = FastOutSlowInEasing
                    ),
                    label = "IndicatorWidth"
                )

                val color by animateColorAsState(
                    targetValue = if (index == currentIndex)
                        Color(0xFFE50914)
                    else
                        Color.White.copy(alpha = 0.25f),
                    animationSpec = tween(
                        durationMillis = 350,
                        easing = FastOutSlowInEasing
                    ),
                    label = "IndicatorColor"
                )

                Box(
                    modifier = Modifier
                        .padding(horizontal = 3.dp)
                        .width(width)
                        .height(6.dp)
                        .clip(RoundedCornerShape(50))
                        .background(color)
                )
            }
        }
    }
}