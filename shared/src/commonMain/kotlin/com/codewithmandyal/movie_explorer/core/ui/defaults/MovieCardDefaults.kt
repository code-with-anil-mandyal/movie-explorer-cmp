package com.codewithmandyal.movie_explorer.core.ui.defaults

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.codewithmandyal.movie_explorer.core.ui.responsive.WindowType

@Immutable
object MovieCardDefaults {

    fun width(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> 100.dp
            WindowType.Medium -> 140.dp
            WindowType.Expanded -> 160.dp
        }

    fun height(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> 150.dp
            WindowType.Medium -> 200.dp
            WindowType.Expanded -> 230.dp
        }
}