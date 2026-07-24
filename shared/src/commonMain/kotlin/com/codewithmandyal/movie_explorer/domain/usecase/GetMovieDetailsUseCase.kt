package com.codewithmandyal.movie_explorer.domain.usecase

import com.codewithmandyal.movie_explorer.domain.repository.DetailsRepository

class GetMovieDetailsUseCase(private val repository: DetailsRepository) {

    suspend operator fun invoke(movieId : Int) = repository.getMovieDetails(movieId)

}