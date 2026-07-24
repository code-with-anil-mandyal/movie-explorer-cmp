package com.codewithmandyal.movie_explorer.core.ui.defaults

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.codewithmandyal.movie_explorer.core.ui.responsive.WindowType

@Immutable
object TrailerDefaults {

    fun thumbnailHeight(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> 200.dp
            WindowType.Medium -> 280.dp
            WindowType.Expanded -> 360.dp
        }

    fun playButtonSize(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> 50.dp
            WindowType.Medium -> 70.dp
            WindowType.Expanded -> 90.dp
        }

    fun playIconSize(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> 28.dp
            WindowType.Medium -> 32.dp
            WindowType.Expanded -> 36.dp
        }

    fun contentMaxWidth(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> Dp.Unspecified
            WindowType.Medium -> 900.dp
            WindowType.Expanded -> 1100.dp
        }

    fun elevation(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> 4.dp
            WindowType.Medium -> 6.dp
            WindowType.Expanded -> 8.dp
        }
}