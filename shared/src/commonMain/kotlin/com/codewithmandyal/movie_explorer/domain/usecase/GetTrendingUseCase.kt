package com.codewithmandyal.movie_explorer.domain.usecase

import com.codewithmandyal.movie_explorer.core.utils.MediaType
import com.codewithmandyal.movie_explorer.domain.repository.ListingRepository

class GetTrendingUseCase(
    private val listingRepository: ListingRepository
) {
    suspend operator fun invoke(page: Int, mediaType: MediaType) =  listingRepository.getTrending(page, mediaType)
}