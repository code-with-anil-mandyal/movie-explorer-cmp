package com.codewithmandyal.movie_explorer.features.home.common

import com.codewithmandyal.movie_explorer.domain.model.Movie

data class HomeState(

    val isLoading: Boolean = false,

    val discoverMovies: List<Movie> = emptyList(),

    val discoverTv: List<Movie> = emptyList(),

    val topRatedMovies: List<Movie> = emptyList(),

    val topRatedTv: List<Movie> = emptyList(),

    val nowPlayingMovies: List<Movie> = emptyList(),

    val popularMovies: List<Movie> = emptyList(),
    val popularTv: List<Movie> = emptyList(),

    val isRefreshing: Boolean = false,

    val error: String? = null
)