package com.codewithmandyal.movie_explorer.features.details.tv

import androidx.compose.runtime.Stable
import androidx.compose.ui.focus.FocusRequester

@Stable
class TvDetailsFocusState {

    val back = FocusRequester()

    val watchNow = FocusRequester()

    val watchList = FocusRequester()

    val details = FocusRequester()

    val cast = FocusRequester()

    val crew = FocusRequester()

    val facts = FocusRequester()

    val similarMovies = FocusRequester()

    val recommendedMovies = FocusRequester()

    val reviews = FocusRequester()

    val gallery = FocusRequester()
}