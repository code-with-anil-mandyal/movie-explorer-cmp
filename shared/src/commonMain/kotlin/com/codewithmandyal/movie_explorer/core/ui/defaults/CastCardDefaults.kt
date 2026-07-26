package com.codewithmandyal.movie_explorer.core.ui.defaults

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.WindowType


@Immutable
object CastCardDefaults {

    fun imageSize(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> 80.dp
            WindowType.Medium -> 90.dp
            WindowType.Expanded -> 100.dp
        }

    fun cardWidth(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> 90.dp
            WindowType.Medium -> 100.dp
            WindowType.Expanded -> 110.dp
        }

    fun roleHeight(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> 36.dp
            WindowType.Medium -> 40.dp
            WindowType.Expanded -> 44.dp
        }
}