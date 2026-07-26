package com.codewithmandyal.movie_explorer.core.ui.responsive.tv

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun getTvWindowType(width: Dp): TvWindowType {
    return when {
        width < 1400.dp -> TvWindowType.Compact      // 720p
        width < 2600.dp -> TvWindowType.Medium       // 1080p
        else -> TvWindowType.Expanded                // 4K
    }
}