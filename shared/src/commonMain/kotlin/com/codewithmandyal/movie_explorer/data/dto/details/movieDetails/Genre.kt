package com.codewithmandyal.movie_explorer.data.dto.details.movieDetails

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Genre(
    @SerialName("id")
    val id: Int?,
    @SerialName("name")
    val name: String
)