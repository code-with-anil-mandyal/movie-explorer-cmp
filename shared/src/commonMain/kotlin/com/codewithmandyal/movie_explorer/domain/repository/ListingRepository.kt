package com.codewithmandyal.movie_explorer.domain.repository

import com.codewithmandyal.movie_explorer.core.utils.MediaType
import com.codewithmandyal.movie_explorer.domain.model.Movie

interface ListingRepository {
    suspend fun getTrending(
        page: Int = 1,
        mediaType: MediaType
    ): List<Movie>

    suspend fun searchAll(
        page: Int = 1,
        query: String = ""
    ): List<Movie>
}