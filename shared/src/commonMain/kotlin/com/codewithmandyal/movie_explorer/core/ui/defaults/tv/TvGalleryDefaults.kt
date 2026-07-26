package com.codewithmandyal.movie_explorer.core.ui.defaults.tv

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.codewithmandyal.movie_explorer.core.ui.responsive.tv.TvWindowType

@Immutable
object TvGalleryDefaults {

    fun columns(windowType: TvWindowType): Int =
        when (windowType) {
            TvWindowType.Compact -> 4
            TvWindowType.Medium -> 5
            TvWindowType.Expanded -> 7
        }

    fun imageHeight(windowType: TvWindowType): Dp =
        when (windowType) {
            TvWindowType.Compact -> 220.dp
            TvWindowType.Medium -> 260.dp
            TvWindowType.Expanded -> 300.dp
        }
}