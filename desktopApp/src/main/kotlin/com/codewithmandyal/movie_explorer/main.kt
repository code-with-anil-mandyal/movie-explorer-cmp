package com.codewithmandyal.movie_explorer

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.codewithmandyal.movie_explorer.di.initKoin

fun main() = application {
    initKoin()
    Window(
        onCloseRequest = ::exitApplication,
        title = "MovieExplorer",
    ) {
        App()
    }
}