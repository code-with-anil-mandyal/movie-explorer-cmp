package com.codewithmandyal.movie_explorer.domain.usecase

import com.codewithmandyal.movie_explorer.core.utils.MediaType
import com.codewithmandyal.movie_explorer.domain.repository.DetailsRepository

class GetSimilarUseCase(
    private val detailsRepository: DetailsRepository
) {
    suspend operator fun invoke(movieId: Int, mediaType: MediaType) = detailsRepository.getSimilar(movieId, mediaType)
}