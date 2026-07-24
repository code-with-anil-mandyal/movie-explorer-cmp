package com.codewithmandyal.movie_explorer.features.details

import com.codewithmandyal.movie_explorer.domain.model.Banner
import com.codewithmandyal.movie_explorer.domain.model.Credits
import com.codewithmandyal.movie_explorer.domain.model.Movie
import com.codewithmandyal.movie_explorer.domain.model.Review
import com.codewithmandyal.movie_explorer.domain.model.Video

data class DetailsState(

    val isLoading: Boolean = false,

    val banners: List<Banner> = emptyList(),

    val details: Movie? = null,

    val credits: Credits? = null,

    val recommendedMovies: List<Movie> = emptyList(),

    val similarMovies: List<Movie> = emptyList(),

    val videos: List<Video> = emptyList(),

    val reviews: List<Review> = emptyList(),

    val isRefreshing: Boolean = false,

    val error: String? = null
)
