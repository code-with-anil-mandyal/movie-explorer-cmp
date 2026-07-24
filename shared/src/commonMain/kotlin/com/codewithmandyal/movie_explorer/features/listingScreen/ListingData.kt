package com.codewithmandyal.movie_explorer.features.listingScreen

import com.codewithmandyal.movie_explorer.domain.model.Movie

data class ListingData(
    val results: List<Movie> = emptyList(),
    val currentPage: Int = 1,
    val endReached: Boolean = false
)
