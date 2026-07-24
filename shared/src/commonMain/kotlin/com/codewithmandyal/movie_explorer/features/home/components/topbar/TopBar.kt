package com.codewithmandyal.movie_explorer.features.home.components.topbar

import androidx.compose.runtime.Composable
import com.codewithmandyal.movie_explorer.core.ui.responsive.LocalWindowType
import com.codewithmandyal.movie_explorer.core.ui.responsive.WindowType
import com.codewithmandyal.movie_explorer.core.utils.ListingType

@Composable
fun TopBar(
    elevated: Boolean,
    onListingScreen: (listingType: ListingType) -> Unit
) {
    when (LocalWindowType.current) {
        WindowType.Compact -> MobileTopBar(elevated, onListingScreen = {
            onListingScreen(it)
        })
        WindowType.Medium,
        WindowType.Expanded -> DesktopTopBar(elevated, onListingScreen = {
            onListingScreen(it)
        }
        )
    }
}