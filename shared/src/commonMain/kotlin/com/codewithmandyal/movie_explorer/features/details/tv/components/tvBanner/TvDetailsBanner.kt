package com.codewithmandyal.movie_explorer.features.details.tv.components.tvBanner

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import com.codewithmandyal.movie_explorer.core.ui.defaults.tv.TvBannerDefaults
import com.codewithmandyal.movie_explorer.core.ui.responsive.tv.LocalTvWindowType
import com.codewithmandyal.movie_explorer.core.ui.responsive.tv.TvWindowType
import com.codewithmandyal.movie_explorer.domain.model.Banner
import com.codewithmandyal.movie_explorer.domain.model.Movie

@Composable
fun TvDetailsBanner(
    banner: Banner,
    movie: Movie,
    watchRequester: FocusRequester,
    watchListRequester: FocusRequester,
    upRequester: FocusRequester,
    downRequester: FocusRequester
) {

    val windowType = LocalTvWindowType.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(TvBannerDefaults.detailsBannerHeight(windowType))
            .background(Color.Black)
    ) {

        TvBannerBackground(
            banner = banner,
            isCompact = windowType == TvWindowType.Compact
        )

        TvBannerContent(
            movie = movie,
            modifier = Modifier.align(Alignment.BottomStart),
            watchRequester = watchRequester,
            watchListRequester = watchListRequester,
            upRequester = upRequester,
            downRequester = downRequester
        )
    }
}