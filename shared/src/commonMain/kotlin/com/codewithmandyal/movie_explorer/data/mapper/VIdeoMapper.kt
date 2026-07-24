package com.codewithmandyal.movie_explorer.data.mapper

import com.codewithmandyal.movie_explorer.data.dto.details.trailer.Result
import com.codewithmandyal.movie_explorer.domain.model.Video

fun Result.toDomain(): Video {
    return Video(
        key = key?:""
    )
}