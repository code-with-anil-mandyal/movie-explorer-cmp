package com.codewithmandyal.movie_explorer.data.mapper

import com.codewithmandyal.movie_explorer.data.dto.details.castAndCrew.CastAndCrewResponseDto
import com.codewithmandyal.movie_explorer.data.remote.NetworkConstants.PROFILE_PIC_BASE_URL
import com.codewithmandyal.movie_explorer.domain.model.CastAndCrew
import com.codewithmandyal.movie_explorer.domain.model.Credits

fun CastAndCrewResponseDto.toDomain() = Credits(

    casts = cast?.map {
        CastAndCrew(
            profilePath = it.profilePath?.let { path ->
                "$PROFILE_PIC_BASE_URL$path"
            }.orEmpty(),
            name = it.name.orEmpty(),
            character = it.character.orEmpty()
        )
    } ?: emptyList(),

    crew = crew?.map {
        CastAndCrew(
            profilePath = it.profilePath?.let { path ->
                "$PROFILE_PIC_BASE_URL$path"
            }.orEmpty(),
            name = it.name.orEmpty(),
            character = it.job.orEmpty()
        )
    } ?: emptyList()
)