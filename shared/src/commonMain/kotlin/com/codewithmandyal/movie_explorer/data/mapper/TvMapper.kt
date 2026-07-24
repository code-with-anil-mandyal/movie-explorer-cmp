package com.codewithmandyal.movie_explorer.data.mapper


import com.codewithmandyal.movie_explorer.core.components.genres.GenreConstants
import com.codewithmandyal.movie_explorer.data.dto.tvDto.Result
import com.codewithmandyal.movie_explorer.data.remote.NetworkConstants.BANNER_PIC_BASE_URL
import com.codewithmandyal.movie_explorer.data.remote.NetworkConstants.MOVIE_CARD_PIC_BASE_URL
import com.codewithmandyal.movie_explorer.domain.model.Movie

fun Result.toTvDomain(): Movie {
    return Movie(
        id = id?:0,
        originalLanguage = originalLanguage?:"",
        originalTitle = originalName?:"",
        overview = overview?:"",
        posterPath = "$MOVIE_CARD_PIC_BASE_URL${posterPath}",
        backdropPath = "$BANNER_PIC_BASE_URL${backdropPath}",
        adult = adult?:false,
        releaseDate = firstAirDate?:"",
        genres = genreIds
            ?.mapNotNull { GenreConstants.tvGenres[it] }
            ?: emptyList(),
        languages = emptyList()
    )
}