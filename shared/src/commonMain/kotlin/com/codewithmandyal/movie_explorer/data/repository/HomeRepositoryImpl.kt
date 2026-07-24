package com.codewithmandyal.movie_explorer.data.repository

import com.codewithmandyal.movie_explorer.core.utils.MediaType
import com.codewithmandyal.movie_explorer.data.mapper.toDomain
import com.codewithmandyal.movie_explorer.data.mapper.toTvDomain
import com.codewithmandyal.movie_explorer.data.remote.MovieApiService
import com.codewithmandyal.movie_explorer.domain.model.Movie
import com.codewithmandyal.movie_explorer.domain.repository.HomeRepository

class HomeRepositoryImpl(
    private val api: MovieApiService,
) : HomeRepository {

    override suspend fun discover(
        mediaType: MediaType
    ): List<Movie> {
        return when(mediaType){
            MediaType.TV -> {
                api.discoverTv(mediaType = mediaType)
                    .results.map {
                        it.toTvDomain()
                    }
            }

            MediaType.MOVIE -> {
                api.discoverMovies(mediaType = mediaType)
                    .results.map {
                        it.toDomain()
                    }
            }
        }

    }



    override suspend fun getPopular(page: Int, mediaType: MediaType): List<Movie> {
        return when(mediaType){
            MediaType.MOVIE -> {
                api.popularMovies(page, mediaType)
                    .results.map {
                        it.toDomain()
                    }
            }
            MediaType.TV -> {
                api.popularTv(page, mediaType)
                    .results.map {
                        it.toTvDomain()
                    }
            }
        }

    }



    override suspend fun topRated(page: Int, mediaType: MediaType): List<Movie> {
        return when(mediaType){
            MediaType.TV -> {
                api.topRatedTv()
                    .results.map {
                        it.toTvDomain()
                    }
            }
            MediaType.MOVIE -> {
                api.topRatedMovies(page = page, mediaType = mediaType)
                    .results.map {
                        it.toDomain()
                    }
            }
        }

    }



    override suspend fun getNowPlayingMovie(
        minDate: String,
        maxDate: String,
    ): List<Movie> {
        return api.getNowPlayingMovie(
            minDate, maxDate
        ).results.map {
            it.toDomain()
        }
    }
}
