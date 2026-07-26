package com.codewithmandyal.movie_explorer.features.splash.tv.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.codewithmandyal.movie_explorer.core.ui.defaults.tv.TvSplashDefaults
import com.codewithmandyal.movie_explorer.core.ui.responsive.tv.LocalTvWindowType

private val GlowColor = Color(0xFFE50914)

@Composable
fun TvAnimatedGlow(
    modifier: Modifier = Modifier
){

    val windowType = LocalTvWindowType.current

    val transition = rememberInfiniteTransition(label = "glow")

    val glowScale by transition.animateFloat(
        initialValue = 0.98f,
        targetValue = 1.04f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 2500,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = "glowScale"
    )

    val glowAlpha by transition.animateFloat(
        initialValue = 0.14f,
        targetValue = 0.22f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 2500,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = "glowAlpha"
    )

    Canvas(
        modifier = modifier.size(
            TvSplashDefaults.logoGlowSize(windowType) * glowScale
        )
    ) {

        val center = Offset(size.width / 2f, size.height / 2f)
        val radius = size.minDimension * 0.42f

        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(
                    GlowColor.copy(alpha = glowAlpha),
                    GlowColor.copy(alpha = glowAlpha * 0.45f),
                    GlowColor.copy(alpha = glowAlpha * 0.15f),
                    Color.Transparent
                ),
                center = center,
                radius = radius
            ),
            radius = radius,
            center = center
        )
    }
}