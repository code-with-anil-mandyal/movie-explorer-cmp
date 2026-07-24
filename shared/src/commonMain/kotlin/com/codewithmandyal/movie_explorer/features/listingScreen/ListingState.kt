package com.codewithmandyal.movie_explorer.features.listingScreen

import com.codewithmandyal.movie_explorer.core.utils.ListingType
import com.codewithmandyal.movie_explorer.core.utils.MediaType
import com.codewithmandyal.movie_explorer.domain.model.Movie

data class ListingState(

    val isLoading: Boolean = false,

    val query: String = "",

    val results: List<Movie> = emptyList(),

    //val listings: Map<Pair<ListingType, MediaType>, ListingData> = emptyMap(),

    val isLoadingMore: Boolean = false,

    val currentPage: Int = 1,

    val endReached: Boolean = false,

    val isRefreshing: Boolean = false,

    val error: String? = null

)