package com.codewithmandyal.movie_explorer.features.listingScreen

import com.codewithmandyal.movie_explorer.core.utils.ListingType
import com.codewithmandyal.movie_explorer.core.utils.MediaType

sealed interface ListingIntent {
    data class FetchListingData(val mediaType: MediaType, val listingType: ListingType) : ListingIntent

    object LoadNextPage : ListingIntent

    data object Retry : ListingIntent
}