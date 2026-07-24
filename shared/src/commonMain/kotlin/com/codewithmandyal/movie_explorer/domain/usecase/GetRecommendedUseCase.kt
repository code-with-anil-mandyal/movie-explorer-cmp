package com.codewithmandyal.movie_explorer.domain.usecase

import com.codewithmandyal.movie_explorer.core.utils.MediaType
import com.codewithmandyal.movie_explorer.domain.repository.DetailsRepository

class GetRecommendedUseCase(
    private val detailsRepository: DetailsRepository
) {
    suspend operator fun invoke(movieId: Int, mediaType: MediaType) = detailsRepository.getRecommended(movieId, mediaType)
}