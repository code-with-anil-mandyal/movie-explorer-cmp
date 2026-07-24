package com.codewithmandyal.movie_explorer.domain.model

import com.codewithmandyal.movie_explorer.data.dto.details.movieDetails.ProductionCompany
import com.codewithmandyal.movie_explorer.data.dto.details.movieDetails.ProductionCountry
import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val posterPath: String,
    val backdropPath: String,
    val adult: Boolean,
    val releaseDate: String,
    val genres: List<String>,
    val languages: List<String>,
    val budget: String?="",
    val revenue: String?="",
    val productionCompanies: List<ProductionCompany> = emptyList(),
    val productionCountries: List<ProductionCountry> = emptyList(),
    val mediaType: String?=null
) {

}