package com.codewithmandyal.movie_explorer

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.codewithmandyal.movie_explorer.core.navigation.AppNavigation
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.ResponsiveTheme
import com.codewithmandyal.movie_explorer.core.ui.responsive.tv.TvResponsiveTheme

@Composable
fun App(
    isTv: Boolean
) {
    if (isTv) {
        TvResponsiveTheme {
            AppNavigation(isTv = true)
        }
    } else {
        ResponsiveTheme {
            AppNavigation(isTv = false)
        }
    }
}