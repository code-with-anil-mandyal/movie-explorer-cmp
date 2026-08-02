package com.codewithmandyal.movie_explorer.core.ui.defaults.tv

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.codewithmandyal.movie_explorer.core.ui.responsive.tv.TvWindowType

@Immutable
object TvBackButtonDefaults {

//    fun circleSize(windowType: TvWindowType): Dp =
//        when (windowType) {
//            TvWindowType.Compact -> 64.dp
//            TvWindowType.Medium -> 72.dp
//            TvWindowType.Expanded -> 80.dp
//        }

    fun circleSize(windowType: TvWindowType): Dp =
        when (windowType) {
            TvWindowType.Compact -> 48.dp
            TvWindowType.Medium -> 56.dp
            TvWindowType.Expanded -> 64.dp
        }

//    fun arrowSize(windowType: TvWindowType): Dp =
//        when (windowType) {
//            TvWindowType.Compact -> 32.dp
//            TvWindowType.Medium -> 36.dp
//            TvWindowType.Expanded -> 40.dp
//        }

    fun arrowSize(windowType: TvWindowType): Dp =
        when (windowType) {
            TvWindowType.Compact -> 22.dp
            TvWindowType.Medium -> 26.dp
            TvWindowType.Expanded -> 30.dp
        }
}