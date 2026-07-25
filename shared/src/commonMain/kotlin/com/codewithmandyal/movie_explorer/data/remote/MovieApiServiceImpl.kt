package com.codewithmandyal.movie_explorer.data.remote

import com.codewithmandyal.movie_explorer.core.utils.MediaType
import com.codewithmandyal.movie_explorer.data.dto.details.banner.BannersResponseDto
import com.codewithmandyal.movie_explorer.data.dto.details.castAndCrew.CastAndCrewResponseDto
import com.codewithmandyal.movie_explorer.data.dto.details.movieDetails.DetailsResponseDto
import com.codewithmandyal.movie_explorer.data.dto.details.reviews.ReviewsResponseDto
import com.codewithmandyal.movie_explorer.data.dto.details.trailer.TrailerResponseDto
import com.codewithmandyal.movie_explorer.data.dto.movieDto.MoviesResponseDto
import com.codewithmandyal.movie_explorer.data.dto.tvDto.TvResponseDto
import com.codewithmandyal.movie_explorer.data.remote.NetworkConstants.CREDITS
import com.codewithmandyal.movie_explorer.data.remote.NetworkConstants.DISCOVER
import com.codewithmandyal.movie_explorer.data.remote.NetworkConstants.IMAGES
import com.codewithmandyal.movie_explorer.data.remote.NetworkConstants.MOVIE
import com.codewithmandyal.movie_explorer.data.remote.NetworkConstants.MULTI
import com.codewithmandyal.movie_explorer.data.remote.NetworkConstants.NOW_PLAYING
import com.codewithmandyal.movie_explorer.data.remote.NetworkConstants.POPULAR
import com.codewithmandyal.movie_explorer.data.remote.NetworkConstants.RECOMMENDATIONS
import com.codewithmandyal.movie_explorer.data.remote.NetworkConstants.REVIEWS
import com.codewithmandyal.movie_explorer.data.remote.NetworkConstants.SEARCH
import com.codewithmandyal.movie_explorer.data.remote.NetworkConstants.SIMILAR
import com.codewithmandyal.movie_explorer.data.remote.NetworkConstants.TOP_RATED
import com.codewithmandyal.movie_explorer.data.remote.NetworkConstants.TRENDING
import com.codewithmandyal.movie_explorer.data.remote.NetworkConstants.TV
import com.codewithmandyal.movie_explorer.data.remote.NetworkConstants.VIDEOS
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class MovieApiServiceImpl(
    private val client: HttpClient
) : MovieApiService {

    override suspend fun discoverMovies(page: Int, mediaType: MediaType): MoviesResponseDto {
        return client.get("$DISCOVER/$MOVIE") {

            parameter("page", page)

        }.body()
    }

    override suspend fun discoverTv(page: Int, mediaType: MediaType): TvResponseDto {
        return client.get("$DISCOVER/$TV") {

            parameter("page", page)

        }.body()
    }

    override suspend fun popularMovies(page: Int, mediaType: MediaType): MoviesResponseDto {
        return client.get("$MOVIE/$POPULAR") {
            parameter("page", page)
        }.body()
    }

    override suspend fun popularTv(page: Int, mediaType: MediaType): TvResponseDto {
        return client.get("$TV/$POPULAR") {
            parameter("page", page)
        }.body()
    }

    override suspend fun topRatedMovies(
        language: String,
        page: Int,
        mediaType: MediaType
    ): MoviesResponseDto {
        return client.get("$MOVIE/$TOP_RATED") {
            parameter("language", language)
            parameter("page", page)
        }.body()
    }

    override suspend fun topRatedTv(
        language: String,
        page: Int
    ): TvResponseDto {
        return client.get("$TV/$TOP_RATED"){
            parameter("language", language)
            parameter("page", page)
        }.body()
    }




    override suspend fun getMovieBanners(movieId: Int): BannersResponseDto {
        return client.get("$MOVIE/$movieId/$IMAGES").body()
    }

    override suspend fun getTvBanners(seriesId: Int): BannersResponseDto {
        return client.get("$TV/$seriesId/$IMAGES").body()
    }

    override suspend fun getMovieDetails(movieId: Int): DetailsResponseDto {
        return client.get("$MOVIE/$movieId").body()
    }

    override suspend fun getMovieCredits(movieId: Int): CastAndCrewResponseDto {
        return client.get("$MOVIE/$movieId/$CREDITS").body()
    }

    override suspend fun getRecommendMovies(movieId: Int): MoviesResponseDto {
        return client.get("$MOVIE/$movieId/$RECOMMENDATIONS") {}.body()
    }

    override suspend fun getRecommendTv(movieId: Int): MoviesResponseDto {
        return client.get("$TV/$movieId/$RECOMMENDATIONS") {}.body()
    }


    override suspend fun getSimilarMovies(movieId: Int): MoviesResponseDto {
        return client.get("$MOVIE/$movieId/$SIMILAR") {}.body()
    }

    override suspend fun getSimilarTv(seriesId: Int): MoviesResponseDto {
        return client.get("$TV/$seriesId/$SIMILAR") {}.body()
    }

    override suspend fun getMovieVideo(movieId: Int): TrailerResponseDto {
        return client.get("$MOVIE/$movieId/$VIDEOS") {}.body()
    }

    override suspend fun getMovieReviews(movieId: Int): ReviewsResponseDto {
        return client.get("$MOVIE/$movieId/$REVIEWS") {}.body()
    }

    override suspend fun getNowPlayingMovie(
        minDate: String,
        maxDate: String,
        page: Int
    ): MoviesResponseDto {
        return client.get("$MOVIE/$NOW_PLAYING") {
            parameter("release_date.gte", minDate)
            parameter("release_date.lte", maxDate)
            parameter("page", page)
            parameter("language", "en-US")
            parameter("sort_by", "popularity.desc")
            parameter("include_adult", false)
            parameter("include_video", false)
            parameter("with_release_type", "2|3")
        }.body()
    }

    override suspend fun getTrendingMovies(
        page: Int,
        mediaType: MediaType
    ): MoviesResponseDto {
        return client.get("$TRENDING/$MOVIE/week") {
            parameter("page", page)
        }.body()
    }

    override suspend fun getTrendingTv(
        page: Int,
        mediaType: MediaType
    ): TvResponseDto {
        return client.get("$TRENDING/$TV/week") {
            parameter("page", page)
        }.body()
    }

    override suspend fun searchAll(
        page: Int,
        query: String
    ): MoviesResponseDto {
        return client.get("$SEARCH/$MULTI"){
            parameter("page", page)
            parameter("query", query)
        }.body()
    }


}