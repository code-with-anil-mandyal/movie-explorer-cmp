package com.codewithmandyal.movie_explorer.features.listingScreen

sealed interface ListingEvent {

    data class OnSearchQueryChanged(
        val query: String
    ) : ListingEvent
}