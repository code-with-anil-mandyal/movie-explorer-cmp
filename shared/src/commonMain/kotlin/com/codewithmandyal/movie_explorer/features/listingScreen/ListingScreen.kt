package com.codewithmandyal.movie_explorer.features.listingScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.codewithmandyal.movie_explorer.core.components.ErrorView
import com.codewithmandyal.movie_explorer.core.components.LoaderView
import com.codewithmandyal.movie_explorer.core.components.SpaceVertical
import com.codewithmandyal.movie_explorer.core.ui.responsive.LocalAppDimens
import com.codewithmandyal.movie_explorer.core.ui.responsive.LocalWindowType
import com.codewithmandyal.movie_explorer.core.ui.responsive.WindowType
import com.codewithmandyal.movie_explorer.core.utils.ListingType
import com.codewithmandyal.movie_explorer.core.utils.MediaType
import com.codewithmandyal.movie_explorer.features.details.components.topBar.DetailsTopBar
import com.codewithmandyal.movie_explorer.features.home.components.CardsView
import com.codewithmandyal.movie_explorer.features.home.components.topbar.SearchBar
import com.codewithmandyal.movie_explorer.features.listingScreen.components.ListingMenuItem
import com.codewithmandyal.movie_explorer.features.listingScreen.components.NoSearchResult
import com.codewithmandyal.movie_explorer.features.listingScreen.components.SearchEmptyState
import kotlinx.coroutines.flow.drop
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ListingScreen(
    listingType: ListingType,
    onBackPress: () -> Unit = {},
    viewModel: ListingViewModel = koinViewModel(),
    onDetailsScreen: (id: Int, mediaType: MediaType) -> Unit,
) {


    val state by viewModel.state.collectAsStateWithLifecycle()

    var selectedMediaType by rememberSaveable {
        mutableStateOf(MediaType.MOVIE)
    }

    val dimens = LocalAppDimens.current

    val windowType = LocalWindowType.current

    val columns = when (windowType) {
        WindowType.Compact -> 3
        WindowType.Medium -> 4
        WindowType.Expanded -> 7
    }

    val movieRows = state.results.chunked(columns)

    val listState = rememberLazyListState()



    LaunchedEffect(listingType, selectedMediaType) {

        viewModel.onIntent(
            ListingIntent.FetchListingData(
                mediaType = selectedMediaType,
                listingType = listingType
            )
        )
    }

    LaunchedEffect(listState) {

        snapshotFlow {
            listState.layoutInfo
        }
            .drop(1) // Ignore the initial layout emission
            .collect { layoutInfo ->

                val lastVisibleItem =
                    layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0

                val totalItems = layoutInfo.totalItemsCount

                if (
                    totalItems > 0 &&
                    lastVisibleItem >= totalItems - 3 &&
                    !state.isLoading &&
                    !state.isLoadingMore &&
                    !state.endReached
                ) {
                    viewModel.onIntent(ListingIntent.LoadNextPage)
                }
            }
    }

    when {
        state.isLoading -> {
            LoaderView()
        }

        state.error != null -> {
            ErrorView(state.error!!, onRetry = {
                viewModel.onIntent(ListingIntent.Retry)
            })
        }


        else -> {




            LazyColumn(
                state = listState,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF0F0F0F))
            ) {

                stickyHeader {
                    val finalTitle = when(listingType.name){
                        ListingType.TOP_RATED.name ->{
                            "Top Rated"
                        }

                        ListingType.TRENDING.name ->{
                            "Trending"
                        }

                        ListingType.POPULAR.name ->{
                            "Popular"
                        }
                        ListingType.SEARCH.name ->{
                            "Search"
                        }
                        else -> {
                            "MOVIE EXPLORER"
                        }
                    }
                    DetailsTopBar(
                        showSearchBar = listingType == ListingType.SEARCH,
                        elevated = true,
                        searchQuery = state.query,
                        title = finalTitle,
                        onBackPress = onBackPress,
                        onSearchQueryChange = { query ->
                            viewModel.onEvent(
                                ListingEvent.OnSearchQueryChanged(query)
                            )
                        }
                    )
                }

                item {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = dimens.screenPadding)
                    ) {

                        //SpaceVertical(dimens.sectionSpacing)

                        if(listingType != ListingType.SEARCH){

                            Row(
                                horizontalArrangement = Arrangement.spacedBy(dimens.sectionSpacing),
                                verticalAlignment = Alignment.CenterVertically
                            ) {



                                ListingMenuItem(
                                    title = "MOVIES",
                                    selected = selectedMediaType == MediaType.MOVIE
                                ) {
                                    if (selectedMediaType != MediaType.MOVIE) {
                                        selectedMediaType = MediaType.MOVIE
                                    }
                                }

                                ListingMenuItem(
                                    title = "TV SHOWS",
                                    selected = selectedMediaType == MediaType.TV
                                ) {
                                    if (selectedMediaType != MediaType.TV) {
                                        selectedMediaType = MediaType.TV
                                    }
                                }
                            }

                        }

                        SpaceVertical(dimens.sectionSpacing)
                    }
                }


                if (listingType == ListingType.SEARCH && state.query.isBlank()) {

                    item {
                        SearchEmptyState(
                            modifier = Modifier.fillParentMaxSize()
                        )
                    }

                } else if (
                    listingType == ListingType.SEARCH &&
                    state.query.isNotBlank() &&
                    state.results.isEmpty()
                ) {

                    item {
                        NoSearchResult(
                            query = state.query,
                            modifier = Modifier.fillParentMaxSize()
                        )
                    }
                }else{
                    items(movieRows) { row ->

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = dimens.screenPadding),
                            horizontalArrangement = Arrangement.spacedBy(dimens.cardSpacing)
                        ) {

                            row.forEach { movie ->

                                CardsView(
                                    movie = movie,
                                    modifier = Modifier.weight(1f)
                                        .animateItem(),
                                    onDetailsScreen = { id ->
                                        onDetailsScreen(id, if(movie.mediaType == null) selectedMediaType else if(movie.mediaType == "movie") MediaType.MOVIE else MediaType.TV)
                                    }
                                )
                            }

                            repeat(columns - row.size) {
                                Spacer(modifier = Modifier.weight(1f))
                            }
                        }

                        Spacer(modifier = Modifier.height(dimens.sectionSpacing))
                    }
                }


                if (state.isLoadingMore) {

                    item {

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = dimens.sectionSpacing),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                }
            }
        }


    }
}

