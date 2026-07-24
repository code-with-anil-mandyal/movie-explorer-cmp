package com.codewithmandyal.movie_explorer.core.ui.defaults

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.codewithmandyal.movie_explorer.core.ui.responsive.WindowType


@Immutable
object ReviewCardDefaults {

    fun width(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> 280.dp
            WindowType.Medium -> 300.dp
            WindowType.Expanded -> 320.dp
        }

    fun height(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> 270.dp
            WindowType.Medium -> 290.dp
            WindowType.Expanded -> 310.dp
        }


    fun avatarSize(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> 54.dp
            WindowType.Medium -> 60.dp
            WindowType.Expanded -> 66.dp
        }

    fun ratingIconSize(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> 16.dp
            WindowType.Medium -> 18.dp
            WindowType.Expanded -> 20.dp
        }
}