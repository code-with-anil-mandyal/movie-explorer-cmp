package com.codewithmandyal.movie_explorer.core.ui.responsive

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

val LocalAppDimens = staticCompositionLocalOf<AppDimens> {
    error("No AppDimens provided")
}

val LocalWindowType = staticCompositionLocalOf<WindowType> {
    error("No WindowType provided")
}

@Composable
fun ResponsiveTheme(
    content: @Composable () -> Unit
) {

    BoxWithConstraints {

        val windowType = when {
            maxWidth < 700.dp -> WindowType.Compact
            maxWidth < 1100.dp -> WindowType.Medium
            else -> WindowType.Expanded
        }

        val dimens = when (windowType) {
            WindowType.Compact -> CompactDimens
            WindowType.Medium -> MediumDimens
            WindowType.Expanded -> ExpandedDimens
        }

        CompositionLocalProvider(
            LocalAppDimens provides dimens,
            LocalWindowType provides windowType
        ) {
            content()
        }
    }
}