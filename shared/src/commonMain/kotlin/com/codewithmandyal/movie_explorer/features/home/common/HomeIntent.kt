package com.codewithmandyal.movie_explorer.features.home.common

sealed interface HomeIntent {

    data object FetchHomeData : HomeIntent
    data object Retry : HomeIntent
}