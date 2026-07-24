package com.codewithmandyal.movie_explorer.domain.usecase

import com.codewithmandyal.movie_explorer.core.utils.MediaType
import com.codewithmandyal.movie_explorer.domain.repository.HomeRepository

class GetTopRatedMoviesUseCase(
    private val repository: HomeRepository
) {
    suspend operator fun invoke(
        page : Int = 1, mediaType: MediaType
    ) =
        repository.topRated(page, mediaType)
}