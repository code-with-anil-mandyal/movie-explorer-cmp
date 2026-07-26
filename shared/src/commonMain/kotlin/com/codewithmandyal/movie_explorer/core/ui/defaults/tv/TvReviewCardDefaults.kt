package com.codewithmandyal.movie_explorer.core.ui.defaults.tv

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.codewithmandyal.movie_explorer.core.ui.responsive.tv.TvWindowType

@Immutable
object TvReviewCardDefaults {

    fun width(windowType: TvWindowType): Dp =
        when (windowType) {
            TvWindowType.Compact -> 420.dp
            TvWindowType.Medium -> 480.dp
            TvWindowType.Expanded -> 540.dp
        }

    fun height(windowType: TvWindowType): Dp =
        when (windowType) {
            TvWindowType.Compact -> 340.dp
            TvWindowType.Medium -> 380.dp
            TvWindowType.Expanded -> 420.dp
        }

    fun avatarSize(windowType: TvWindowType): Dp =
        when (windowType) {
            TvWindowType.Compact -> 72.dp
            TvWindowType.Medium -> 84.dp
            TvWindowType.Expanded -> 96.dp
        }

    fun ratingIconSize(windowType: TvWindowType): Dp =
        when (windowType) {
            TvWindowType.Compact -> 22.dp
            TvWindowType.Medium -> 26.dp
            TvWindowType.Expanded -> 30.dp
        }
}