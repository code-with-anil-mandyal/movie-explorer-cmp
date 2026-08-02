package com.codewithmandyal.movie_explorer.features.home.tv

import androidx.compose.runtime.Stable
import androidx.compose.ui.focus.FocusRequester

@Stable
class TvHomeFocusState {
    val topBar = FocusRequester()
    val watchNow = FocusRequester()

    val popularMovie = FocusRequester()
    val popularTv = FocusRequester()
    val topRatedMovies = FocusRequester()
    val topRatedTv = FocusRequester()
    val watchListMovies = FocusRequester()
    val watchListTvShows = FocusRequester()
}