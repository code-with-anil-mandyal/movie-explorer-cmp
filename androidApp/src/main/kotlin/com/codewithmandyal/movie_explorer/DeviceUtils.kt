package com.codewithmandyal.movie_explorer

import android.app.UiModeManager
import android.content.Context
import android.content.res.Configuration

fun Context.isTv(): Boolean {
    val uiModeManager =
        getSystemService(Context.UI_MODE_SERVICE) as UiModeManager

    return uiModeManager.currentModeType ==
            Configuration.UI_MODE_TYPE_TELEVISION
}