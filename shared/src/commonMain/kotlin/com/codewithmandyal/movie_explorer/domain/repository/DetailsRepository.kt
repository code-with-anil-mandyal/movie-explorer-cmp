package com.codewithmandyal.movie_explorer.domain.repository

import com.codewithmandyal.movie_explorer.core.utils.MediaType
import com.codewithmandyal.movie_explorer.domain.model.Banner
import com.codewithmandyal.movie_explorer.domain.model.Credits
import com.codewithmandyal.movie_explorer.domain.model.Movie
import com.codewithmandyal.movie_explorer.domain.model.Review
import com.codewithmandyal.movie_explorer.domain.model.Video

interface DetailsRepository {
    suspend fun getDetailsBanner(movieId: Int, mediaType: MediaType): List<Banner>
    suspend fun getMovieCastAndCrew(movieId: Int): Credits
    suspend fun getMovieDetails(movieId: Int): Movie
    suspend fun getRecommended(movieId: Int,  mediaType: MediaType): List<Movie>

    suspend fun getSimilar(movieId: Int,  mediaType: MediaType): List<Movie>
    suspend fun getMovieVideos(movieId: Int): List<Video>

    suspend fun getMovieReviews(movieId: Int): List<Review>
}