package com.codewithmandyal.movie_explorer.features.home

sealed interface HomeIntent {

    data object FetchHomeData : HomeIntent
    data object Retry : HomeIntent
}