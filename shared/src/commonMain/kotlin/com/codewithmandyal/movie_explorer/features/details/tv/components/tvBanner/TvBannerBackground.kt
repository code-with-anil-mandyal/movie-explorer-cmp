package com.codewithmandyal.movie_explorer.features.details.tv.components.tvBanner

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import com.codewithmandyal.movie_explorer.domain.model.Banner

@Composable
fun TvBannerBackground(
    banner: Banner,
    isCompact: Boolean
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        if (isCompact) {

            // Compact TV - use more of the screen
//            AsyncImage(
//                model = banner.filePath,
//                contentDescription = null,
//                modifier = Modifier.fillMaxSize(),
//                contentScale = ContentScale.Crop
//            )

            AsyncImage(
                model = banner.filePath,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.72f)
                    .align(Alignment.CenterEnd),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )

        } else {

            // Medium / Expanded TV
            // Image occupies right side of banner
            AsyncImage(
                model = banner.filePath,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.72f)
                    .align(Alignment.CenterEnd),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )
        }

        // LEFT → RIGHT gradient
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.horizontalGradient(
                        colorStops = arrayOf(
                            0.00f to Color.Black,
                            0.25f to Color.Black,
                            0.42f to Color.Black.copy(alpha = 0.92f),
                            0.58f to Color.Black.copy(alpha = 0.60f),
                            0.75f to Color.Black.copy(alpha = 0.20f),
                            1.00f to Color.Transparent
                        )
                    )
                )
        )

        // Bottom gradient
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colorStops = arrayOf(
                            0.00f to Color.Transparent,
                            0.60f to Color.Transparent,
                            0.82f to Color.Black.copy(alpha = 0.30f),
                            1.00f to Color.Black.copy(alpha = 0.75f)
                        )
                    )
                )
        )
    }
}