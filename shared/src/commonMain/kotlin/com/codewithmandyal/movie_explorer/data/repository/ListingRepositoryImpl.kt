package com.codewithmandyal.movie_explorer.data.repository

import com.codewithmandyal.movie_explorer.core.utils.MediaType
import com.codewithmandyal.movie_explorer.data.mapper.toDomain
import com.codewithmandyal.movie_explorer.data.mapper.toTvDomain
import com.codewithmandyal.movie_explorer.data.remote.MovieApiService
import com.codewithmandyal.movie_explorer.domain.model.Movie
import com.codewithmandyal.movie_explorer.domain.repository.ListingRepository

class ListingRepositoryImpl(
    private val api: MovieApiService
) : ListingRepository {

    override suspend fun getTrending(
        page: Int,
        mediaType: MediaType
    ): List<Movie> {

        return when(mediaType){
            MediaType.MOVIE -> {
                api.getTrendingMovies(mediaType = mediaType)
                    .results.map {
                        it.toDomain()
                    }
            }

            MediaType.TV -> {


                api.getTrendingTv(mediaType = mediaType)
                    .results.map {
                        it.toTvDomain()
                    }
            }
        }
    }

    override suspend fun searchAll(
        page: Int,
        query: String
    ): List<Movie> {
        return api.searchAll(page, query)
            .results.map {
                it.toDomain()
            }
    }


}