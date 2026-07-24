package com.codewithmandyal.movie_explorer.data.mapper

import com.codewithmandyal.movie_explorer.core.utils.toMoneyFormat
import com.codewithmandyal.movie_explorer.data.dto.details.movieDetails.DetailsResponseDto
import com.codewithmandyal.movie_explorer.data.remote.NetworkConstants.BANNER_PIC_BASE_URL
import com.codewithmandyal.movie_explorer.data.remote.NetworkConstants.MOVIE_CARD_PIC_BASE_URL
import com.codewithmandyal.movie_explorer.domain.model.Movie

fun DetailsResponseDto.toDomain() : Movie {
    return Movie(
        id = id?:0,
        originalLanguage = originalLanguage?:"",
        originalTitle = originalTitle?:"",
        overview = overview?:"",
        posterPath = "$MOVIE_CARD_PIC_BASE_URL${posterPath}",
        backdropPath = "$BANNER_PIC_BASE_URL${backdropPath}",
        adult = adult?:false,
        releaseDate = releaseDate?:"",
        genres = genres?.map { it.name } ?: emptyList(),
        languages = spokenLanguages?.map { it.englishName }?: emptyList(),
        budget = budget?.toMoneyFormat(),
        revenue = revenue?.toMoneyFormat(),
        productionCompanies = productionCompanies?:emptyList(),
        productionCountries = productionCountries?:emptyList()
    )
}