package com.codewithmandyal.movie_explorer.domain.usecase

import com.codewithmandyal.movie_explorer.core.utils.MediaType
import com.codewithmandyal.movie_explorer.domain.repository.DetailsRepository
import com.codewithmandyal.movie_explorer.domain.repository.HomeRepository

class GetMovieBannersUseCase(
    private val repository: DetailsRepository
) {
    suspend operator fun invoke(movieId : Int, mediaType: MediaType) = repository.getDetailsBanner(movieId, mediaType)
}