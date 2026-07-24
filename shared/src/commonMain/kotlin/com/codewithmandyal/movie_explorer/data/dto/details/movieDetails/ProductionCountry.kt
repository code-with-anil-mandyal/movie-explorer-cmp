package com.codewithmandyal.movie_explorer.data.dto.details.movieDetails



import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductionCountry(
    @SerialName("iso_3166_1")
    val iso31661: String?,
    @SerialName("name")
    val name: String
)