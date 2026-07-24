package com.codewithmandyal.movie_explorer.data.dto.movieDto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Result(

    @SerialName("adult")
    val adult: Boolean? = null,

    @SerialName("backdrop_path")
    val backdropPath: String? = null,

    // Movie
    @SerialName("title")
    val title: String? = null,

    @SerialName("original_title")
    val originalTitle: String? = null,

    @SerialName("release_date")
    val releaseDate: String? = null,

    @SerialName("media_type")
    val mediaType: String? = null,

    @SerialName("video")
    val video: Boolean? = null,

    // TV
    @SerialName("name")
    val name: String? = null,

    @SerialName("original_name")
    val originalName: String? = null,

    @SerialName("first_air_date")
    val firstAirDate: String? = null,

    @SerialName("origin_country")
    val originCountry: List<String?>? = null,

    // Common
    @SerialName("genre_ids")
    val genreIds: List<Int>? = null,

    @SerialName("id")
    val id: Int? = null,

    @SerialName("original_language")
    val originalLanguage: String? = null,

    @SerialName("overview")
    val overview: String? = null,

    @SerialName("popularity")
    val popularity: Double? = null,

    @SerialName("poster_path")
    val posterPath: String? = null,

    @SerialName("softcore")
    val softcore: Boolean? = null,

    @SerialName("vote_average")
    val voteAverage: Double? = null,

    @SerialName("vote_count")
    val voteCount: Int? = null
)
