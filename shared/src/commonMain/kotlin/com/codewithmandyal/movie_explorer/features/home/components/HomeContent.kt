package com.codewithmandyal.movie_explorer.features.home.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.codewithmandyal.movie_explorer.core.components.SpaceVertical
import com.codewithmandyal.movie_explorer.core.ui.responsive.LocalAppDimens
import com.codewithmandyal.movie_explorer.core.utils.ListingType
import com.codewithmandyal.movie_explorer.core.utils.MediaType
import com.codewithmandyal.movie_explorer.features.home.components.topbar.TopBar
import com.codewithmandyal.movie_explorer.domain.model.Movie

@Composable
fun HomeContent(
    moviesList: List<Movie>,
    tvList: List<Movie>,
    topRatedMovies: List<Movie>,
    topRatedTv: List<Movie>,
    nowPlaying: List<Movie>,
    popularMovies: List<Movie>,
    popularTv: List<Movie>,
    onDetailsScreen: (id: Int,  mediaType: MediaType) -> Unit,
    onListingScreen: (listingType: ListingType) -> Unit
) {


    val listState = rememberLazyListState()

    val elevated by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 0 ||
                    listState.firstVisibleItemScrollOffset > 80
        }
    }

    val dimens = LocalAppDimens.current

    LazyColumn(
        state = listState,
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            bottom = dimens.sectionSpacing
        )
    ) {

        stickyHeader {
            TopBar(
                elevated = elevated,
                onListingScreen = {
                    onListingScreen(it)
                }
            )
        }

        item {
            BannerSlider(
                banners = nowPlaying.take(5),
                onDetailsScreen = { id ->
                    onDetailsScreen(id, MediaType.MOVIE)
                }
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }

        item {
            ContentSection(
                title = "POPULAR MOVIES",
                movieList = popularMovies,
                onDetailsScreen = {id ->
                    onDetailsScreen(id, MediaType.MOVIE)
                }
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }

        item {
            ContentSection(
                title = "POPULAR TV SHOWS",
                movieList = popularTv,
                onDetailsScreen = { id ->
                    onDetailsScreen(id, MediaType.TV)
                }
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }

        item {
            ContentSection(
                title = "TOP RATED MOVIES",
                movieList = topRatedMovies,
                onDetailsScreen = { id ->
                    onDetailsScreen(id, MediaType.MOVIE)
                }
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }

        item {
            ContentSection(
                title = "TOP RATED TV SHOWS",
                movieList = topRatedTv,
                onDetailsScreen = { id ->
                    onDetailsScreen(id, MediaType.TV)
                }
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }

        item {
            ContentSection(
                title = "WATCHLIST MOVIES",
                movieList = moviesList,
                onDetailsScreen = { id ->
                    onDetailsScreen(id, MediaType.MOVIE)
                }
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }

        item {
            ContentSection(
                title = "WATCHLIST TV SHOWS",
                movieList = tvList,
                onDetailsScreen = { id ->
                    onDetailsScreen(id, MediaType.TV)
                }
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }
    }
}