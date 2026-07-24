package com.codewithmandyal.movie_explorer.core.ui.defaults

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.codewithmandyal.movie_explorer.core.ui.responsive.WindowType

@Immutable
object ButtonDefaults {

    fun smallWidth(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> 110.dp
            WindowType.Medium -> 130.dp
            WindowType.Expanded -> 150.dp
        }

    fun mediumWidth(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> 140.dp
            WindowType.Medium -> 170.dp
            WindowType.Expanded -> 200.dp
        }

    fun largeWidth(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> 180.dp
            WindowType.Medium -> 220.dp
            WindowType.Expanded -> 260.dp
        }

}