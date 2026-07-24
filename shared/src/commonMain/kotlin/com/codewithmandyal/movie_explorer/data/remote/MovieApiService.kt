package com.codewithmandyal.movie_explorer.data.remote


import com.codewithmandyal.movie_explorer.core.utils.MediaType
import com.codewithmandyal.movie_explorer.data.dto.details.banner.BannersResponseDto
import com.codewithmandyal.movie_explorer.data.dto.details.castAndCrew.CastAndCrewResponseDto
import com.codewithmandyal.movie_explorer.data.dto.details.movieDetails.DetailsResponseDto
import com.codewithmandyal.movie_explorer.data.dto.details.reviews.ReviewsResponseDto
import com.codewithmandyal.movie_explorer.data.dto.details.trailer.TrailerResponseDto
import com.codewithmandyal.movie_explorer.data.dto.movieDto.MoviesResponseDto
import com.codewithmandyal.movie_explorer.data.dto.tvDto.TvResponseDto

interface MovieApiService {

    suspend fun discoverMovies(
        page: Int = 1,
        mediaType: MediaType
    ):  MoviesResponseDto

    suspend fun discoverTv(
        page: Int = 1,
        mediaType: MediaType
    ): TvResponseDto

    suspend fun popularMovies(
        page: Int = 1,
        mediaType: MediaType
    ):  MoviesResponseDto

    suspend fun popularTv(
        page: Int = 1,
        mediaType: MediaType
    ): TvResponseDto

    suspend fun topRatedMovies(
        language : String = "en-US",
        page: Int = 1,
        mediaType: MediaType
    ):  MoviesResponseDto





    suspend fun topRatedTv(
        language : String = "en-US",
        page: Int = 1
    ):  TvResponseDto

    suspend fun getMovieBanners(
        movieId: Int
    ):  BannersResponseDto

    suspend fun getTvBanners(
        seriesId: Int
    ):  BannersResponseDto

    suspend fun getMovieDetails(
        movieId: Int
    ):  DetailsResponseDto

    suspend fun getMovieCredits(
        movieId: Int
    ):  CastAndCrewResponseDto

    suspend fun getRecommendMovies(
        movieId: Int
    ):  MoviesResponseDto

    suspend fun getRecommendTv(
        movieId: Int
    ):  MoviesResponseDto



    suspend fun getSimilarMovies(
        movieId: Int
    ):  MoviesResponseDto

    suspend fun getSimilarTv(
        seriesId: Int
    ):  MoviesResponseDto

    suspend fun getMovieVideo(
        movieId: Int
    ):  TrailerResponseDto

    suspend fun getMovieReviews(
        movieId: Int
    ):  ReviewsResponseDto

    suspend fun getNowPlayingMovie(
        minDate: String,
        maxDate: String,
        page: Int = 1
    ):  MoviesResponseDto

    suspend fun getTrendingMovies(
        page: Int = 1,
        mediaType: MediaType
    ):  MoviesResponseDto

    suspend fun getTrendingTv(
        page: Int = 1,
        mediaType: MediaType
    ): TvResponseDto

    suspend fun searchAll(
        page: Int = 1,
       query: String=""
    ): MoviesResponseDto
}