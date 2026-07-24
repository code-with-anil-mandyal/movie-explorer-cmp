package com.codewithmandyal.movie_explorer.core.utils

import kotlinx.browser.window

actual object YoutubeLauncher {
    actual fun openVideo(videoKey: String) {
        window.open(
            "https://www.youtube.com/watch?v=$videoKey",
            "_blank"
        )
    }
}