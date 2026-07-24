package com.codewithmandyal.movie_explorer.features.splash.components



import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.codewithmandyal.movie_explorer.core.ui.defaults.SplashDefaults
import com.codewithmandyal.movie_explorer.core.ui.responsive.LocalWindowType

private val TrackColor = Color(0xFF242424)
private val FillColor = Color(0xFFE50914)

@Composable
fun LoadingBar(
    modifier: Modifier = Modifier
) {

    val transition = rememberInfiniteTransition(label = "loading")

    val progress by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 2400,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        ),
        label = "progress"
    )

    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(3.dp)
    ) {

        val radius = size.height / 2

        // Track
        drawRoundRect(
            color = TrackColor,
            cornerRadius = CornerRadius(radius, radius)
        )

        // Progress
        drawRoundRect(
            color = FillColor,
            size = Size(
                width = size.width * progress,
                height = size.height
            ),
            cornerRadius = CornerRadius(radius, radius)
        )
    }
}