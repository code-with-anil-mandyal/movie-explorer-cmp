package com.codewithmandyal.movie_explorer.features.imageGallery

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.codewithmandyal.movie_explorer.core.components.ErrorView
import com.codewithmandyal.movie_explorer.core.components.LoaderView
import com.codewithmandyal.movie_explorer.core.components.SpaceVertical
import com.codewithmandyal.movie_explorer.core.ui.defaults.GalleryDefaults
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.LocalAppDimens
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.LocalWindowType
import com.codewithmandyal.movie_explorer.core.utils.MediaType
import com.codewithmandyal.movie_explorer.features.details.common.DetailsIntent
import com.codewithmandyal.movie_explorer.features.details.common.DetailsViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ImageGallery(
    onBackPress: () -> Unit,
    movieId: Int,
    mediaType: MediaType,
    viewModel: DetailsViewModel = koinViewModel()
){



    val dimens = LocalAppDimens.current

    val state by viewModel.state.collectAsState()


    LaunchedEffect(movieId) {
        viewModel.onIntent(DetailsIntent.FetchDetailsData(movieId, mediaType))
    }

    when {
        state.isLoading -> {
            LoaderView()
        }

        state.error != null -> {
            ErrorView(state.error!!, onRetry = {
                viewModel.onIntent(DetailsIntent.Retry)
            })
        }

        else ->{

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF0F0F0F))
            ) {
                item {
                    _root_ide_package_.com.codewithmandyal.movie_explorer.features.details.defaults.components.topBar.DetailsTopBar(
                        elevated = true,
                        title = "Image Gallery",
                        onBackPress = onBackPress
                    )
                }

                item {
                    SpaceVertical(dimens.sectionSpacing)
                }

                item {

                    val windowType = LocalWindowType.current
                    val dimens = LocalAppDimens.current

                    BoxWithConstraints {

                        val columns = GalleryDefaults.columns(windowType)

                        val itemWidth = (maxWidth - dimens.cardSpacing * (columns - 1)) / columns

                        FlowRow(
                            modifier = Modifier.fillMaxWidth(),
                            maxItemsInEachRow = columns,
                            horizontalArrangement = Arrangement.spacedBy(dimens.cardSpacing),
                            verticalArrangement = Arrangement.spacedBy(dimens.cardSpacing)
                        ) {

                            state.banners.forEach { banner ->

                                _root_ide_package_.com.codewithmandyal.movie_explorer.features.details.defaults.components.gallery.GalleryItem(
                                    banner = banner,
                                    width = itemWidth,
                                    height = GalleryDefaults.imageHeight(windowType)
                                )
                            }
                        }
                    }

                }
            }
        }

        }


}