package com.codewithmandyal.movie_explorer.data.repository

import com.codewithmandyal.movie_explorer.core.utils.MediaType
import com.codewithmandyal.movie_explorer.data.mapper.toDomain
import com.codewithmandyal.movie_explorer.data.remote.MovieApiService
import com.codewithmandyal.movie_explorer.domain.model.Banner
import com.codewithmandyal.movie_explorer.domain.model.Credits
import com.codewithmandyal.movie_explorer.domain.model.Movie
import com.codewithmandyal.movie_explorer.domain.model.Review
import com.codewithmandyal.movie_explorer.domain.model.Video
import com.codewithmandyal.movie_explorer.domain.repository.DetailsRepository

class DetailsRepositoryImpl(
    private val api: MovieApiService,
): DetailsRepository {

    override suspend fun getDetailsBanner(movieId: Int, mediaType: MediaType): List<Banner> {
        return when(mediaType){
            MediaType.TV -> {
                api.getTvBanners(movieId)
                    .backdrops
                    ?.map {
                        it.toDomain()
                    }?:emptyList()
            }

            MediaType.MOVIE -> {
                api.getMovieBanners(movieId)
                    .backdrops
                    ?.map {
                        it.toDomain()
                    }?:emptyList()
            }
        }

    }

    override suspend fun getMovieCastAndCrew(movieId: Int): Credits {
        return api.getMovieCredits(movieId)
            .toDomain()

    }

    override suspend fun getMovieDetails(movieId: Int): Movie {
        return api.getMovieDetails(movieId)
            .toDomain()
    }

    override suspend fun getRecommended(movieId: Int, mediaType: MediaType): List<Movie> {
        return when(mediaType){
            MediaType.TV -> {
                 api.getRecommendTv(movieId)
                    .results.map {
                        it.toDomain()
                    }
            }

            MediaType.MOVIE -> {
                api.getRecommendMovies(movieId)
                    .results.map {
                        it.toDomain()
                    }
            }
        }


    }



    override suspend fun getSimilar(movieId: Int, mediaType: MediaType): List<Movie> {
        return when(mediaType){
            MediaType.TV -> {
                api.getSimilarTv(movieId)
                    .results.map {
                        it.toDomain()
                    }
            }

            MediaType.MOVIE ->{
                api.getSimilarMovies(movieId)
                    .results.map {
                        it.toDomain()
                    }
            }
        }
    }

    override suspend fun getMovieVideos(movieId: Int): List<Video> {
        return api.getMovieVideo(movieId)
            .results?.map {
                it.toDomain()
            }?:emptyList()
    }

    override suspend fun getMovieReviews(movieId: Int): List<Review> {
        return api.getMovieReviews(movieId)
            .results?.map {
                it.toDomain()
            }?:emptyList()
    }

}