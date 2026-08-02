package com.codewithmandyal.movie_explorer.features.home.tv.components

import androidx.compose.foundation.focusGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import com.codewithmandyal.movie_explorer.core.components.SpaceVertical
import com.codewithmandyal.movie_explorer.core.ui.responsive.tv.LocalTvDimens
import com.codewithmandyal.movie_explorer.core.utils.HomeRow
import com.codewithmandyal.movie_explorer.domain.model.Movie
import kotlinx.coroutines.launch

@Composable
fun TvContentRow(
    title: String,
    movies: List<Movie>,
    firstItemRequester: FocusRequester,
    upRequester: FocusRequester,
    downRequester: FocusRequester,
    onMovieClick: (Int) -> Unit,
    onFirstCardFocused: (HomeRow) -> Unit = {},
    row: HomeRow,

){



    val dimens = LocalTvDimens.current

    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()



    Column{
        TvHomeTitles(
            title = title,

        )

        SpaceVertical(dimens.sectionSpacing / 2)

        LazyRow(
            state = listState,
            modifier = Modifier.focusGroup(),
            horizontalArrangement = Arrangement.spacedBy(dimens.itemSpacing),
            contentPadding = PaddingValues(horizontal = dimens.screenPadding)
        )
        {

            itemsIndexed(movies) { index, movie ->


                TvCardsView(
                    movie = movie,
                    modifier =
                        if (index == 0) {
                            Modifier
                                .focusRequester(firstItemRequester)
                                .onFocusChanged {
                                    println(
                                        "TV_FOCUS FIRST CARD FOCUSED = ${it.isFocused}"
                                    )
                                }
                        } else {
                            Modifier
                        },
                    onDetailsScreen = onMovieClick,
                    onFocused = {
                        scope.launch {

                            // Horizontal scrolling
                            when {
                                index >= listState.firstVisibleItemIndex + 4 -> {
                                    listState.animateScrollToItem(index - 2)
                                }

                                index < listState.firstVisibleItemIndex + 1 -> {
                                    listState.animateScrollToItem(maxOf(index - 1, 0))
                                }
                            }

                            // Vertical scrolling (only first card)
                            if (index == 0) {
                                onFirstCardFocused(row)
                            }

                        }
                    }
                )

            }
        }
    }

}