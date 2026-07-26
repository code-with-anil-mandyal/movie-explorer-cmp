package com.codewithmandyal.movie_explorer.features.splash.tv

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.codewithmandyal.movie_explorer.features.splash.tv.components.TvSplashContent

@Composable
fun TvSplashScreen(
    onSplashFinished: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        TvSplashContent(
            onSplashFinished = onSplashFinished
        )
    }
}
