package com.codewithmandyal.movie_explorer.features.home.tv.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import com.codewithmandyal.movie_explorer.core.components.SpaceVertical
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.LocalAppDimens
import com.codewithmandyal.movie_explorer.core.ui.responsive.tv.LocalTvDimens
import com.codewithmandyal.movie_explorer.core.utils.HomeRow
import com.codewithmandyal.movie_explorer.core.utils.MediaType
import com.codewithmandyal.movie_explorer.domain.model.Movie
import com.codewithmandyal.movie_explorer.features.home.tv.TvHomeFocusState
import kotlinx.coroutines.launch

@Composable
fun TvHomeContent(
    banners: List<Movie>,
    popularMovies: List<Movie>,
    popularTv: List<Movie>,
    topRatedMovies: List<Movie>,
    topRatedTv: List<Movie>,
    watchListMovies: List<Movie>,
    watchListTv: List<Movie>,
    onDetailsScreen: (id: Int,  mediaType: MediaType) -> Unit
){
    val focusState = remember { TvHomeFocusState() }

    val homeListState = rememberLazyListState()

    val scope = rememberCoroutineScope()

    var initialFocusRequested by rememberSaveable {
        mutableStateOf(false)
    }

    val dimens = LocalTvDimens.current

    LazyColumn(
        state = homeListState,
        modifier = Modifier.fillMaxSize()
    ) {

            item {
                TvTopBar(
                    focusRequester = focusState.topBar,
                    downRequester = focusState.watchNow,
                    onSearchClick = {},
                    onSettingsClick = {},
                    onInitialFocusRequested = {
                        initialFocusRequested = true
                    },
                    requestInitialFocus = !initialFocusRequested,
                )
            }

            item {


                TvBannerSlider(
                    watchRequester = focusState.watchNow,
                    upRequester = focusState.topBar,
                    downRequester = focusState.popularMovie,
                    banners = banners,
                    onDetailsScreen = { movieId ->
                        onDetailsScreen(movieId, MediaType.MOVIE)
                    },
                    onWatchNow = { movieId -> },
                    onWatchNowFocused = {
                        scope.launch {
                            homeListState.animateScrollToItem(1)
                        }
                    }
                )

            }


        item {
            SpaceVertical(dimens.sectionSpacing)
        }

            item {
                TvContentRow(
                    title = "POPULAR MOVIES",
                    movies = popularMovies,
                    firstItemRequester = focusState.popularMovie,
                    upRequester = focusState.watchNow,
                    downRequester = focusState.popularTv,
                    onMovieClick = {
                        onDetailsScreen(it, MediaType.MOVIE)
                    },
                    onFirstCardFocused = { row ->


                        scope.launch {

                            homeListState.animateScrollToItem(
                                index = row.rowIndex,
                                scrollOffset = -120
                            )

                        }

                    },
                    row = HomeRow.POPULAR_MOVIES
                )
            }


        item {
            SpaceVertical(dimens.sectionSpacing)
        }

        item {
            TvContentRow(
                title = "POPULAR TV SHOWS",
                movies = popularTv,
                firstItemRequester = focusState.popularTv,
                upRequester = focusState.popularMovie,
                downRequester = FocusRequester.Default,
                onMovieClick = {
                    onDetailsScreen(it, MediaType.TV)
                },
                onFirstCardFocused = { row ->

                    println("TV_SCROLL Focused Row = ${row.rowIndex}")

                        scope.launch {

                            homeListState.animateScrollToItem(
                                index = row.rowIndex,
                                scrollOffset = -120
                            )

                        }

                },
                row = HomeRow.POPULAR_TV
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }

        item {
            TvContentRow(
                title = "TOP RATED MOVIES",
                movies = topRatedMovies,
                firstItemRequester = focusState.topRatedMovies,
                upRequester = focusState.popularMovie,
                downRequester = FocusRequester.Default,
                onMovieClick = {
                    onDetailsScreen(it, MediaType.MOVIE)
                },
                onFirstCardFocused = { row ->


                    scope.launch {

                        homeListState.animateScrollToItem(
                            index = row.rowIndex,
                            scrollOffset = -120
                        )

                    }

                },
                row = HomeRow.TOP_RATED_MOVIES
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }

        item {
            TvContentRow(
                title = "TOP RATED TV SHOWS",
                movies = topRatedTv,
                firstItemRequester = focusState.topRatedTv,
                upRequester = focusState.topRatedMovies,
                downRequester = FocusRequester.Default,
                onMovieClick = {
                    onDetailsScreen(it, MediaType.TV)
                },
                onFirstCardFocused = { row ->


                    scope.launch {

                        homeListState.animateScrollToItem(
                            index = row.rowIndex,
                            scrollOffset = -120
                        )

                    }

                },
                row = HomeRow.TOP_RATED_TV
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }

        item {
            TvContentRow(
                title = "WATCHLIST MOVIES",
                movies = watchListMovies,
                firstItemRequester = focusState.watchListMovies,
                upRequester = focusState.topRatedTv,
                downRequester = FocusRequester.Default,
                onMovieClick = {
                    onDetailsScreen(it, MediaType.MOVIE)
                },
                onFirstCardFocused = { row ->


                    scope.launch {

                        homeListState.animateScrollToItem(
                            index = row.rowIndex,
                            scrollOffset = -120
                        )

                    }

                },
                row = HomeRow.WATCH_LIST_MOVIE
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }

        item {
            TvContentRow(
                title = "WATCHLIST TV SHOWS",
                movies = watchListTv,
                firstItemRequester = focusState.watchListTvShows,
                upRequester = focusState.watchListMovies,
                downRequester = FocusRequester.Default,
                onMovieClick = {
                    onDetailsScreen(it, MediaType.TV)
                },
                onFirstCardFocused = { row ->


                    scope.launch {

                        homeListState.animateScrollToItem(
                            index = row.rowIndex,
                            scrollOffset = -120
                        )

                    }

                },
                row = HomeRow.WATCH_LIST_TV
            )
        }

        }



}