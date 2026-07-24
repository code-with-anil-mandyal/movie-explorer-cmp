package com.codewithmandyal.movie_explorer.core.utils

import java.awt.Desktop
import java.net.URI

actual object YoutubeLauncher {
    actual fun openVideo(videoKey: String) {
        Desktop.getDesktop().browse(
            URI("https://www.youtube.com/watch?v=$videoKey")
        )
    }
}