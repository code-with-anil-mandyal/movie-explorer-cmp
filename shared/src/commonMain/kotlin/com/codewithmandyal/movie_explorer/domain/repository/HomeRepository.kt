package com.codewithmandyal.movie_explorer.domain.repository

import com.codewithmandyal.movie_explorer.core.utils.MediaType
import com.codewithmandyal.movie_explorer.domain.model.Movie

interface HomeRepository {
    suspend fun discover(
        mediaType: MediaType
    ): List<Movie>



    suspend fun getPopular(
        page: Int,
        mediaType: MediaType
    ): List<Movie>


    suspend fun topRated(
        page: Int = 1,
        mediaType: MediaType
    ): List<Movie>



    suspend fun getNowPlayingMovie(
        minDate: String,
        maxDate: String
    ): List<Movie>


}