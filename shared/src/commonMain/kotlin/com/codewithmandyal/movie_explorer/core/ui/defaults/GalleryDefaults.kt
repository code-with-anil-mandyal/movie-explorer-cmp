package com.codewithmandyal.movie_explorer.core.ui.defaults

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.WindowType

@Immutable
object GalleryDefaults {

    fun columns(windowType: WindowType): Int =
        when (windowType) {
            WindowType.Compact -> 3
            WindowType.Medium -> 4
            WindowType.Expanded -> 6
        }

    fun imageHeight(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> 150.dp
            WindowType.Medium -> 180.dp
            WindowType.Expanded -> 200.dp
        }
}