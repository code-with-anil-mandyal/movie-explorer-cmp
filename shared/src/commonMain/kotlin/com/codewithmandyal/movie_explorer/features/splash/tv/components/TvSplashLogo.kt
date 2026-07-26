package com.codewithmandyal.movie_explorer.features.splash.tv.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.codewithmandyal.movie_explorer.core.ui.defaults.tv.TvSplashDefaults
import com.codewithmandyal.movie_explorer.core.ui.responsive.tv.LocalTvWindowType
import movieexplorer.shared.generated.resources.Res
import movieexplorer.shared.generated.resources.movie_explorer_logo
import org.jetbrains.compose.resources.painterResource

@Composable
fun TvSplashLogo(
    modifier: Modifier = Modifier
){
    val windowType = LocalTvWindowType.current

    Image(
        painter = painterResource(Res.drawable.movie_explorer_logo),
        contentDescription = "Movie Explorer Logo",
        modifier = modifier
            .size(
                TvSplashDefaults.logoSize(windowType)
            )
    )
}