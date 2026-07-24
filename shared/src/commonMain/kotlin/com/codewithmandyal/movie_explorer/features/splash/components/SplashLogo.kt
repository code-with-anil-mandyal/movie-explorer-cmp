package com.codewithmandyal.movie_explorer.features.splash.components



import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.codewithmandyal.movie_explorer.core.ui.defaults.SplashDefaults
import com.codewithmandyal.movie_explorer.core.ui.responsive.LocalWindowType
import movieexplorer.shared.generated.resources.Res
import movieexplorer.shared.generated.resources.movie_explorer_logo
import org.jetbrains.compose.resources.painterResource

@Composable
fun SplashLogo(
    modifier: Modifier = Modifier
) {
    val windowType = LocalWindowType.current

    Image(
        painter = painterResource(Res.drawable.movie_explorer_logo),
        contentDescription = "Movie Explorer Logo",
        modifier = modifier
            .size(
            SplashDefaults.logoSize(windowType)
        )
    )
}