package com.codewithmandyal.movie_explorer.core.ui.defaults.tv

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.codewithmandyal.movie_explorer.core.ui.responsive.tv.TvWindowType

@Immutable
object TvCastCardDefaults {

    fun imageSize(windowType: TvWindowType): Dp =
        when (windowType) {
            TvWindowType.Compact -> 120.dp
            TvWindowType.Medium -> 140.dp
            TvWindowType.Expanded -> 160.dp
        }

    fun cardWidth(windowType: TvWindowType): Dp =
        when (windowType) {
            TvWindowType.Compact -> 140.dp
            TvWindowType.Medium -> 160.dp
            TvWindowType.Expanded -> 180.dp
        }

    fun roleHeight(windowType: TvWindowType): Dp =
        when (windowType) {
            TvWindowType.Compact -> 48.dp
            TvWindowType.Medium -> 56.dp
            TvWindowType.Expanded -> 64.dp
        }
}