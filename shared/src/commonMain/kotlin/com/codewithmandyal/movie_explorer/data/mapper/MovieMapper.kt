package com.codewithmandyal.movie_explorer.data.mapper

import com.codewithmandyal.movie_explorer.core.components.genres.GenreConstants
import com.codewithmandyal.movie_explorer.data.dto.movieDto.Result
import com.codewithmandyal.movie_explorer.data.remote.NetworkConstants.BANNER_PIC_BASE_URL
import com.codewithmandyal.movie_explorer.data.remote.NetworkConstants.MOVIE_CARD_PIC_BASE_URL
import com.codewithmandyal.movie_explorer.domain.model.Movie


fun Result.toDomain(): Movie {
    return Movie(
        id = id ?: 0,
        originalLanguage = originalLanguage.orEmpty(),
        originalTitle = originalTitle ?: originalName.orEmpty(),
        overview = overview.orEmpty(),
        posterPath = "$MOVIE_CARD_PIC_BASE_URL${posterPath.orEmpty()}",
        backdropPath = "$BANNER_PIC_BASE_URL${backdropPath.orEmpty()}",
        adult = adult ?: false,
        releaseDate = releaseDate ?: firstAirDate.orEmpty(),
        genres = genreIds
            ?.mapNotNull { GenreConstants.movieGenres[it] ?: GenreConstants.tvGenres[it] }
            .orEmpty(),
        languages = emptyList(),
        mediaType = mediaType
    )
}
