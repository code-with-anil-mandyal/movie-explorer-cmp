package com.codewithmandyal.movie_explorer.domain.usecase

import com.codewithmandyal.movie_explorer.domain.repository.ListingRepository

class SearchUseCase(
    private val listingRepository: ListingRepository
) {
    suspend operator fun invoke(page: Int, query: String) = listingRepository.searchAll(page, query)
}