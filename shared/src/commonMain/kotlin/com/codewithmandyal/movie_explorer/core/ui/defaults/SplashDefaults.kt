package com.codewithmandyal.movie_explorer.core.ui.defaults

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codewithmandyal.movie_explorer.core.ui.responsive.WindowType

@Immutable
object SplashDefaults {

    fun logoSize(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> 160.dp
            WindowType.Medium -> 220.dp
            WindowType.Expanded -> 280.dp
        }

    fun bottomPadding(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> 60.dp
            WindowType.Medium -> 80.dp
            WindowType.Expanded -> 100.dp
        }

    fun loadingWidth(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> Dp.Unspecified
            WindowType.Medium -> 320.dp
            WindowType.Expanded -> 420.dp
        }

    fun titleFont(windowType: WindowType): TextUnit =
        when (windowType) {
            WindowType.Compact -> 24.sp
            WindowType.Medium -> 30.sp
            WindowType.Expanded -> 36.sp
        }

    fun subtitleFont(windowType: WindowType): TextUnit =
        when (windowType) {
            WindowType.Compact -> 12.sp
            WindowType.Medium -> 14.sp
            WindowType.Expanded -> 16.sp
        }

    fun titleLetterSpacing(windowType: WindowType): TextUnit =
        when (windowType) {
            WindowType.Compact -> 4.sp
            WindowType.Medium -> 5.sp
            WindowType.Expanded -> 6.sp
        }

    fun subtitleLetterSpacing(windowType: WindowType): TextUnit =
        when (windowType) {
            WindowType.Compact -> 3.sp
            WindowType.Medium -> 3.5.sp
            WindowType.Expanded -> 4.sp
        }

    fun backgroundGlowStartRadius(windowType: WindowType): Float =
        when (windowType) {
            WindowType.Compact -> 250f
            WindowType.Medium -> 350f
            WindowType.Expanded -> 450f
        }

    fun backgroundGlowEndRadius(windowType: WindowType): Float =
        when (windowType) {
            WindowType.Compact -> 420f
            WindowType.Medium -> 550f
            WindowType.Expanded -> 700f
        }

    fun logoGlowSize(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> 260.dp
            WindowType.Medium -> 340.dp
            WindowType.Expanded -> 420.dp
        }

    fun loadingBarHeight(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> 8.dp
            WindowType.Medium -> 10.dp
            WindowType.Expanded -> 12.dp
        }

    fun scannerWidth(windowType: WindowType): Float =
        when (windowType) {
            WindowType.Compact -> 70f
            WindowType.Medium -> 90f
            WindowType.Expanded -> 110f
        }

    
}