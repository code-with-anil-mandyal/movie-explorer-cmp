package com.codewithmandyal.movie_explorer.features.splash.defaults

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.codewithmandyal.movie_explorer.features.splash.defaults.components.SplashContent

@Composable
fun SplashScreen(
    onSplashFinished: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        SplashContent(
            onSplashFinished = onSplashFinished
        )
    }
}

