package com.codewithmandyal.movie_explorer.features.details.tv.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.codewithmandyal.movie_explorer.core.ui.responsive.tv.LocalTvDimens
import com.codewithmandyal.movie_explorer.core.utils.MediaType
import com.codewithmandyal.movie_explorer.domain.model.Banner
import com.codewithmandyal.movie_explorer.domain.model.Credits
import com.codewithmandyal.movie_explorer.domain.model.Movie
import com.codewithmandyal.movie_explorer.domain.model.Review
import com.codewithmandyal.movie_explorer.domain.model.Video
import com.codewithmandyal.movie_explorer.features.details.tv.TvDetailsFocusState
import com.codewithmandyal.movie_explorer.features.details.tv.components.tvBanner.TvDetailsScreenBanners
import com.codewithmandyal.movie_explorer.features.details.tv.components.tvTopBar.TvDetailsTopBar

@Composable
fun TvDetailsContent(
    onBackPress: () -> Unit,
    banners: List<Banner>,
    credits: Credits,
    movie: Movie,
    recommendations: List<Movie>,
    similar: List<Movie>,
    videos: List<Video>,
    reviews: List<Review>,
    mediaType: MediaType,
    viewAllImages : () -> Unit,
    onDetailsScreen: (id: Int) -> Unit
){

    val focusState = remember {
        TvDetailsFocusState()
    }

    LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(200)
        focusState.back.requestFocus()
    }

    val dimens = LocalTvDimens.current

    val listState = rememberLazyListState()

    val elevated by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 0 ||
                    listState.firstVisibleItemScrollOffset > 80
        }
    }


    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            bottom = dimens.sectionSpacing
        )
    ) {

        stickyHeader {


                TvDetailsTopBar(
                    onBackPress = onBackPress,
                    title = movie.originalTitle,
                    elevated = elevated,
                    focusRequester = focusState.back,
                    downRequester = focusState.watchNow
                )



        }

        item {
            TvDetailsScreenBanners(
                banners = banners,
                movie = movie,
                watchRequester = focusState.watchNow,
                watchListRequester = focusState.watchList,
                upRequester = focusState.back,
                downRequester = focusState.cast
            )
        }

    }

}