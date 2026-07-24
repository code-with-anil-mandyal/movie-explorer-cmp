package com.codewithmandyal.movie_explorer.data.dto.details.castAndCrew

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class CastAndCrewResponseDto(
    @SerialName("cast")
    val cast: List<Cast>?,
    @SerialName("crew")
    val crew: List<Crew>?,
    @SerialName("id")
    val id: Int?
)