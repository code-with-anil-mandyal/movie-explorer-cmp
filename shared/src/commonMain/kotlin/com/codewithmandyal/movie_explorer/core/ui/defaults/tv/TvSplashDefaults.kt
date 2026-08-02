package com.codewithmandyal.movie_explorer.core.ui.defaults.tv

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codewithmandyal.movie_explorer.core.ui.responsive.tv.TvWindowType

@Immutable
object TvSplashDefaults {

    fun logoSize(windowType: TvWindowType): Dp =
        when (windowType) {
            TvWindowType.Compact -> 160.dp
            TvWindowType.Medium -> 240.dp
            TvWindowType.Expanded -> 320.dp
        }

    fun bottomPadding(windowType: TvWindowType): Dp =
        when (windowType) {
            TvWindowType.Compact -> 90.dp
            TvWindowType.Medium -> 120.dp
            TvWindowType.Expanded -> 150.dp
        }

    fun loadingWidth(windowType: TvWindowType): Dp =
        when (windowType) {
            TvWindowType.Compact -> 320.dp
            TvWindowType.Medium -> 420.dp
            TvWindowType.Expanded -> 520.dp
        }

    fun titleFont(windowType: TvWindowType): TextUnit =
        when (windowType) {
            TvWindowType.Compact -> 38.sp
            TvWindowType.Medium -> 46.sp
            TvWindowType.Expanded -> 54.sp
        }

    fun subtitleFont(windowType: TvWindowType): TextUnit =
        when (windowType) {
            TvWindowType.Compact -> 18.sp
            TvWindowType.Medium -> 22.sp
            TvWindowType.Expanded -> 26.sp
        }

    fun titleLetterSpacing(windowType: TvWindowType): TextUnit =
        when (windowType) {
            TvWindowType.Compact -> 6.sp
            TvWindowType.Medium -> 7.sp
            TvWindowType.Expanded -> 8.sp
        }

    fun subtitleLetterSpacing(windowType: TvWindowType): TextUnit =
        when (windowType) {
            TvWindowType.Compact -> 4.sp
            TvWindowType.Medium -> 5.sp
            TvWindowType.Expanded -> 6.sp
        }

    fun backgroundGlowStartRadius(windowType: TvWindowType): Float =
        when (windowType) {
            TvWindowType.Compact -> 450f
            TvWindowType.Medium -> 600f
            TvWindowType.Expanded -> 750f
        }

    fun backgroundGlowEndRadius(windowType: TvWindowType): Float =
        when (windowType) {
            TvWindowType.Compact -> 700f
            TvWindowType.Medium -> 900f
            TvWindowType.Expanded -> 1100f
        }

    fun logoGlowSize(windowType: TvWindowType): Dp =
        when (windowType) {
            TvWindowType.Compact -> 420.dp
            TvWindowType.Medium -> 520.dp
            TvWindowType.Expanded -> 620.dp
        }

    fun loadingBarHeight(windowType: TvWindowType): Dp =
        when (windowType) {
            TvWindowType.Compact -> 10.dp
            TvWindowType.Medium -> 12.dp
            TvWindowType.Expanded -> 14.dp
        }

    fun scannerWidth(windowType: TvWindowType): Float =
        when (windowType) {
            TvWindowType.Compact -> 100f
            TvWindowType.Medium -> 130f
            TvWindowType.Expanded -> 160f
        }
}