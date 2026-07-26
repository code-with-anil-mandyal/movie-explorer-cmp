package com.codewithmandyal.movie_explorer.core.ui.defaults

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.WindowType

object ListingDefaults {

    fun indicatorWidth(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> 36.dp
            WindowType.Medium -> 44.dp
            WindowType.Expanded -> 52.dp
        }

    fun indicatorHeight(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> 3.dp
            WindowType.Medium -> 4.dp
            WindowType.Expanded -> 4.dp
        }

    fun tabSpacing(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> 32.dp
            WindowType.Medium -> 48.dp
            WindowType.Expanded -> 64.dp
        }
}