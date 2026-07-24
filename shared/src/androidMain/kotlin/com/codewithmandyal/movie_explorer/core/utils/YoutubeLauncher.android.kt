package com.codewithmandyal.movie_explorer.core.utils

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import com.codewithmandyal.movie_explorer.utils.AppContextHolder

actual object YoutubeLauncher {
    actual fun openVideo(videoKey: String) {
        val context = AppContextHolder.context

        val appIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("vnd.youtube:$videoKey")
        ).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }

        val webIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://www.youtube.com/watch?v=$videoKey")
        ).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }

        try {
            context.startActivity(appIntent)
        } catch (_: ActivityNotFoundException) {
            context.startActivity(webIntent)
        }
    }
}