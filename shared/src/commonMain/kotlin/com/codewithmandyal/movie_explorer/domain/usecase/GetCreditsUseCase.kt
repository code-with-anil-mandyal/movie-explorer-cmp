package com.codewithmandyal.movie_explorer.domain.usecase

import com.codewithmandyal.movie_explorer.domain.repository.DetailsRepository

class GetCreditsUseCase(
    private val detailsRepository: DetailsRepository
) {

    suspend operator fun invoke(movieId: Int) = detailsRepository.getMovieCastAndCrew(movieId)
}