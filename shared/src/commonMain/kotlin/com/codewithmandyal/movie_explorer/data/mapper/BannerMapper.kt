package com.codewithmandyal.movie_explorer.data.mapper

import com.codewithmandyal.movie_explorer.data.dto.details.banner.Backdrop
import com.codewithmandyal.movie_explorer.data.remote.NetworkConstants.BANNER_PIC_BASE_URL
import com.codewithmandyal.movie_explorer.domain.model.Banner

fun Backdrop.toDomain() : Banner{
    return Banner(
         aspectRatio = aspectRatio,
        filePath = "$BANNER_PIC_BASE_URL${filePath}",
        height = height,
        width = width
    )
}