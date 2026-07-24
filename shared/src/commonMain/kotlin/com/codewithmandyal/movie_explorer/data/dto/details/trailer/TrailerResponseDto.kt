package com.codewithmandyal.movie_explorer.data.dto.details.trailer

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class TrailerResponseDto(
    @SerialName("id")
    val id: Int?,
    @SerialName("results")
    val results: List<Result>?
)