package com.codewithmandyal.movie_explorer.features.splash.tv.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.codewithmandyal.movie_explorer.core.components.SpaceVertical
import com.codewithmandyal.movie_explorer.core.ui.defaults.tv.TvSplashDefaults
import com.codewithmandyal.movie_explorer.core.ui.responsive.tv.LocalTvDimens
import com.codewithmandyal.movie_explorer.core.ui.responsive.tv.LocalTvWindowType

@Composable
fun TvSplashTitle(
    modifier: Modifier = Modifier
){
    val windowType = LocalTvWindowType.current
    val dimens = LocalTvDimens.current

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "MOVIE EXPLORER",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontSize = TvSplashDefaults.titleFont(windowType),
                fontWeight = FontWeight.Bold,
                letterSpacing = TvSplashDefaults.titleLetterSpacing(windowType),
                color = Color.White
            )
        )

        SpaceVertical(dimens.itemSpacing)

        Text(
            text = "Discover Movies & TV Shows",
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = TvSplashDefaults.subtitleFont(windowType),
                fontWeight = FontWeight.Medium,
                letterSpacing = 0.5.sp,
                color = Color.White.copy(alpha = 0.70f)
            )
        )
    }
}