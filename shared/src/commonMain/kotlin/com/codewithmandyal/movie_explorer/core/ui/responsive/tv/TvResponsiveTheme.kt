package com.codewithmandyal.movie_explorer.core.ui.responsive.tv

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

val LocalTvDimens = staticCompositionLocalOf<TvDimens> {
    error("No TvDimens provided")
}

val LocalTvWindowType = staticCompositionLocalOf<TvWindowType> {
    error("No TvWindowType provided")
}

@Composable
fun TvResponsiveTheme(
    content: @Composable () -> Unit
) {

    BoxWithConstraints {

        val windowType = getTvWindowType(maxWidth)

        val dimens = when (windowType) {
            TvWindowType.Compact -> CompactTvDimens
            TvWindowType.Medium -> MediumTvDimens
            TvWindowType.Expanded -> ExpandedTvDimens
        }

        CompositionLocalProvider(
            LocalTvDimens provides dimens,
            LocalTvWindowType provides windowType
        ) {
            content()
        }
    }
}