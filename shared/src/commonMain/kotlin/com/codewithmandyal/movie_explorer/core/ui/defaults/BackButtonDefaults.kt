package com.codewithmandyal.movie_explorer.core.ui.defaults

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.WindowType

@Immutable
object BackButtonDefaults {

    fun circleSize(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> 45.dp
            WindowType.Medium,
            WindowType.Expanded -> 60.dp
        }

    fun arrowSize(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> 25.dp
            WindowType.Medium,
            WindowType.Expanded -> 30.dp
        }
}