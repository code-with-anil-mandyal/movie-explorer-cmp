package com.codewithmandyal.movie_explorer.features.details.defaults.components.banner

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.codewithmandyal.movie_explorer.core.ui.defaults.BannerDefaults
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.LocalWindowType
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.WindowType
import com.codewithmandyal.movie_explorer.domain.model.Banner
import com.codewithmandyal.movie_explorer.domain.model.Movie

@Composable
fun DetailsBanner(
    banner: Banner,
    movie: Movie
) {

    val windowType = LocalWindowType.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(BannerDefaults.detailsBannerHeight(windowType))
            .background(Color.Black)
    ) {

        _root_ide_package_.com.codewithmandyal.movie_explorer.features.details.defaults.components.banner.BannerBackground(
            banner = banner,
            isCompact = windowType == WindowType.Compact
        )

        _root_ide_package_.com.codewithmandyal.movie_explorer.features.details.defaults.components.banner.BannerContent(
            movie = movie,
            modifier = Modifier.align(Alignment.BottomStart)
        )
    }
}

