package com.codewithmandyal.movie_explorer.features.splash.components



import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.codewithmandyal.movie_explorer.core.components.AppFonts
import com.codewithmandyal.movie_explorer.core.ui.defaults.SplashDefaults
import com.codewithmandyal.movie_explorer.core.ui.responsive.LocalAppDimens
import com.codewithmandyal.movie_explorer.core.ui.responsive.LocalWindowType
import movieexplorer.shared.generated.resources.Res
import movieexplorer.shared.generated.resources.bebas_neue
import movieexplorer.shared.generated.resources.montserrat_medium
import org.jetbrains.compose.resources.Font


@Composable
fun LoadingText() {

    val windowType = LocalWindowType.current

    Text(
        text = "Loading your cinema...",
        style = MaterialTheme.typography.bodyMedium.copy(
            fontSize = SplashDefaults.subtitleFont(windowType),
            fontWeight = FontWeight.Medium,
            letterSpacing = 0.5.sp,
            color = Color.White.copy(alpha = 0.65f)
        )
    )
}