package com.codewithmandyal.movie_explorer.features.splash.components


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codewithmandyal.movie_explorer.core.components.AppFonts
import com.codewithmandyal.movie_explorer.core.components.SpaceVertical
import com.codewithmandyal.movie_explorer.core.ui.defaults.SplashDefaults
import com.codewithmandyal.movie_explorer.core.ui.responsive.LocalAppDimens
import com.codewithmandyal.movie_explorer.core.ui.responsive.LocalWindowType
import movieexplorer.shared.generated.resources.Res
import movieexplorer.shared.generated.resources.bebas_neue
import movieexplorer.shared.generated.resources.montserrat_semibold
import org.jetbrains.compose.resources.Font


@Composable
fun SplashTitle(
    modifier: Modifier = Modifier
) {

    val windowType = LocalWindowType.current
    val dimens = LocalAppDimens.current

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "MOVIE EXPLORER",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontSize = SplashDefaults.titleFont(windowType),
                fontWeight = FontWeight.Bold,
                letterSpacing = SplashDefaults.titleLetterSpacing(windowType),
                color = Color.White
            )
        )

        SpaceVertical(dimens.itemSpacing)

        Text(
            text = "Discover Movies & TV Shows",
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = SplashDefaults.subtitleFont(windowType),
                fontWeight = FontWeight.Medium,
                letterSpacing = 0.5.sp,
                color = Color.White.copy(alpha = 0.70f)
            )
        )
    }
}