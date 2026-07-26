package com.codewithmandyal.movie_explorer.core.ui.responsive.defaults

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

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

        val windowType = getWindowType(maxWidth)

        val appDimens = when (windowType) {
            WindowType.Compact -> CompactDimens
            WindowType.Medium -> MediumDimens
            WindowType.Expanded -> ExpandedDimens
        }

        CompositionLocalProvider(
            LocalAppDimens provides appDimens,
            LocalWindowType provides windowType
        ) {
            content()
        }
    }
}





