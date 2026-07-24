package com.codewithmandyal.movie_explorer.domain.model

data class Review(
    val avatarPath: String?,
    val name: String?,
    val content: String?,
    val rating: Double?,
    val date: String?
)
