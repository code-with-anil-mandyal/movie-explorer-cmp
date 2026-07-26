package com.codewithmandyal.movie_explorer.features.home.tv

import androidx.compose.runtime.Stable
import androidx.compose.ui.focus.FocusRequester

@Stable
class TvHomeFocusState {
    val topBar = FocusRequester()
    val watchNow = FocusRequester()

    val trending = FocusRequester()
    val popular = FocusRequester()
    val topRated = FocusRequester()
    val upcoming = FocusRequester()
    val tvShows = FocusRequester()
}