package com.codewithmandyal.movie_explorer.data.dto.details.banner

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class BannersResponseDto(
    @SerialName("backdrops")
    val backdrops: List<Backdrop>?,
    @SerialName("id")
    val id: Int?,
    @SerialName("logos")
    val logos: List<Logo>?,
    @SerialName("posters")
    val posters: List<Poster>?
)