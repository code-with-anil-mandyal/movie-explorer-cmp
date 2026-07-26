package com.codewithmandyal.movie_explorer.core.ui.defaults.tv

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.codewithmandyal.movie_explorer.core.ui.responsive.tv.TvWindowType

@Immutable
object TvMovieCardDefaults {

    fun width(windowType: TvWindowType): Dp =
        when (windowType) {
            TvWindowType.Compact -> 180.dp
            TvWindowType.Medium -> 220.dp
            TvWindowType.Expanded -> 260.dp
        }

    fun height(windowType: TvWindowType): Dp =
        when (windowType) {
            TvWindowType.Compact -> 270.dp
            TvWindowType.Medium -> 330.dp
            TvWindowType.Expanded -> 390.dp
        }
}