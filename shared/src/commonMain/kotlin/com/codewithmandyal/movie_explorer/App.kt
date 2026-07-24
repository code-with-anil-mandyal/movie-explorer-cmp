package com.codewithmandyal.movie_explorer

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.codewithmandyal.movie_explorer.core.navigation.AppNavigation
import com.codewithmandyal.movie_explorer.core.ui.responsive.ResponsiveTheme

@Composable
fun App() {
    MaterialTheme {

        ResponsiveTheme {
            AppNavigation()
        }

    }
}