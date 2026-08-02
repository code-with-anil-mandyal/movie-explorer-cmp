package com.codewithmandyal.movie_explorer.features.details.defaults.components.banner

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import com.codewithmandyal.movie_explorer.domain.model.Banner

@Composable
fun BannerBackground(
    banner: Banner,
    isCompact: Boolean
) {

    if (isCompact) {

        AsyncImage(
            model = banner.filePath,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.8f),
                            Color.Black.copy(alpha = 0.5f),
                            Color.Transparent
                        ),
                        startY = Float.POSITIVE_INFINITY,
                        endY = 0f
                    )
                )
        )

    } else {

        AsyncImage(
            model = banner.filePath,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.8f),
                            Color.Black.copy(alpha = 0.8f)
                        )
                    )
                )
        )

        AsyncImage(
            model = banner.filePath,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit
        )
    }
}