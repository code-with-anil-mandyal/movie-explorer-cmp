package com.codewithmandyal.movie_explorer.core.ui.responsive.defaults

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


fun getWindowType(width: Dp): WindowType {
    return when {
        width < 700.dp -> WindowType.Compact
        width < 1100.dp -> WindowType.Medium
        else -> WindowType.Expanded
    }
}

