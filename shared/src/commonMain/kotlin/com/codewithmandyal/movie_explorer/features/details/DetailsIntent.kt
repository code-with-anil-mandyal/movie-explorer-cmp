package com.codewithmandyal.movie_explorer.features.details

import com.codewithmandyal.movie_explorer.core.utils.MediaType

sealed interface DetailsIntent {
    data class FetchDetailsData(val movieId: Int, val mediaType: MediaType) : DetailsIntent
    data object Retry: DetailsIntent
}