package com.codewithmandyal.movie_explorer.core.ui.defaults


import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.codewithmandyal.movie_explorer.core.ui.responsive.WindowType


@Immutable
object BannerDefaults {

    fun height(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> 420.dp
            WindowType.Medium -> 500.dp
            WindowType.Expanded -> 560.dp
        }

    fun contentWidth(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> 400.dp
            WindowType.Medium -> 520.dp
            WindowType.Expanded -> 620.dp
        }

    fun watchButtonWidth(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> 150.dp
            WindowType.Medium -> 170.dp
            WindowType.Expanded -> 180.dp
        }

    fun detailsButtonWidth(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> 130.dp
            WindowType.Medium -> 145.dp
            WindowType.Expanded -> 150.dp
        }

    fun detailsBannerHeight(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> 520.dp
            WindowType.Medium -> 600.dp
            WindowType.Expanded -> 700.dp
        }

    fun detailsContentWidth(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> 600.dp
            WindowType.Medium -> 700.dp
            WindowType.Expanded -> 800.dp
        }

    fun detailsOverviewHeight(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> 100.dp
            WindowType.Medium -> 120.dp
            WindowType.Expanded -> 140.dp
        }

    fun detailsButtonHeight(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> 40.dp
            WindowType.Medium -> 44.dp
            WindowType.Expanded -> 48.dp
        }

}