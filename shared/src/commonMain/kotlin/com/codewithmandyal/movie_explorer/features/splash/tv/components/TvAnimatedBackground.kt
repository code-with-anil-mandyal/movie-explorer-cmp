package com.codewithmandyal.movie_explorer.features.splash.tv.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

private val BackgroundTop = Color(0xFF090909)
private val BackgroundMiddle = Color(0xFF0E0E0E)
private val BackgroundBottom = Color(0xFF050505)

private val BackgroundGlow = Color(0x22E50914)

@Composable
fun TvAnimatedBackground(
    modifier: Modifier = Modifier
){

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        BackgroundTop,
                        BackgroundMiddle,
                        BackgroundBottom
                    )
                )
            )
    ) {

        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {

            val center = Offset(
                x = size.width / 2f,
                y = size.height * 0.42f
            )

            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        BackgroundGlow,
                        Color.Transparent
                    ),
                    center = center,
                    radius = size.minDimension * 0.42f
                ),
                radius = size.minDimension * 0.42f,
                center = center
            )
        }
    }
}