package com.codewithmandyal.movie_explorer.domain.usecase

import com.codewithmandyal.movie_explorer.core.utils.MediaType
import com.codewithmandyal.movie_explorer.domain.repository.HomeRepository

class GetPopularUseCase(
    private val homeRepository: HomeRepository
) {
    suspend operator fun invoke(page: Int, mediaType: MediaType) = homeRepository.getPopular(page, mediaType)
}