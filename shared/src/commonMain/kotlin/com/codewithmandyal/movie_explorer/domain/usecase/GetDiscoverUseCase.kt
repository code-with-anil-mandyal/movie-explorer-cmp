package com.codewithmandyal.movie_explorer.domain.usecase

import com.codewithmandyal.movie_explorer.core.utils.MediaType
import com.codewithmandyal.movie_explorer.domain.repository.HomeRepository

class GetDiscoverUseCase(
    private val repository: HomeRepository
) {

    suspend operator fun invoke(mediaType: MediaType) =
        repository.discover(mediaType)
}