package com.codewithmandyal.movie_explorer.domain.model

data class Credits(
    val casts : List<CastAndCrew>,
    val crew : List<CastAndCrew>
)
