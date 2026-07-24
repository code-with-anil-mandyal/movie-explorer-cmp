package com.codewithmandyal.movie_explorer.data.mapper

import com.codewithmandyal.movie_explorer.core.utils.toReviewDate
import com.codewithmandyal.movie_explorer.domain.model.Review
import com.codewithmandyal.movie_explorer.data.dto.details.reviews.Result
fun Result.toDomain() : Review{
    return Review(
        avatarPath = authorDetails?.avatarPath,
        name = author,
        content = content,
        rating = authorDetails?.rating,
        date = createdAt?.toReviewDate()
    )
}