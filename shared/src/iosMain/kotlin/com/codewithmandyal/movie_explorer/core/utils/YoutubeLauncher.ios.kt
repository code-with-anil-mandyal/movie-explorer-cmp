package com.codewithmandyal.movie_explorer.core.utils

import platform.Foundation.NSURL
import platform.UIKit.UIApplication

actual object YoutubeLauncher {
    actual fun openVideo(videoKey: String) {
        val appUrl = NSURL.URLWithString("youtube://$videoKey")
        val webUrl = NSURL.URLWithString("https://www.youtube.com/watch?v=$videoKey")

        if (appUrl != null &&
            UIApplication.sharedApplication.canOpenURL(appUrl)
        ) {
            UIApplication.sharedApplication.openURL(
                appUrl,
                options = emptyMap<Any?, Any>(),
                completionHandler = null
            )
        } else {
            webUrl?.let {
                UIApplication.sharedApplication.openURL(
                    it,
                    options = emptyMap<Any?, Any>(),
                    completionHandler = null
                )
            }
        }
    }
}