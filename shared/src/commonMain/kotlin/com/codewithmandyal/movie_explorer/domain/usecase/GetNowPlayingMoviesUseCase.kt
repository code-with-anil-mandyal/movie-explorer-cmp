package com.codewithmandyal.movie_explorer.domain.usecase

import com.codewithmandyal.movie_explorer.domain.repository.HomeRepository

class GetNowPlayingMoviesUseCase(
    private val homeRepository: HomeRepository
) {
    suspend operator fun invoke(
        minDate: String,
        maxDate: String
    ) = homeRepository.getNowPlayingMovie(minDate, maxDate)
}