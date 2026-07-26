package com.codewithmandyal.movie_explorer.features.splash.defaults.components



import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.codewithmandyal.movie_explorer.core.ui.defaults.SplashDefaults
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.LocalWindowType


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