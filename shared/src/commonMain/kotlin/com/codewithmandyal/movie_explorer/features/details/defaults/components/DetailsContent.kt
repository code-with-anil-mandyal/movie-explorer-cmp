package com.codewithmandyal.movie_explorer.features.details.defaults.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.codewithmandyal.movie_explorer.core.components.SpaceVertical
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.LocalAppDimens
import com.codewithmandyal.movie_explorer.core.utils.MediaType
import com.codewithmandyal.movie_explorer.core.utils.YoutubeLauncher
import com.codewithmandyal.movie_explorer.domain.model.Banner
import com.codewithmandyal.movie_explorer.domain.model.Credits
import com.codewithmandyal.movie_explorer.domain.model.Movie
import com.codewithmandyal.movie_explorer.domain.model.Review
import com.codewithmandyal.movie_explorer.domain.model.Video
import com.codewithmandyal.movie_explorer.features.details.defaults.components.banner.DetailsScreenBanners
import com.codewithmandyal.movie_explorer.features.details.defaults.components.gallery.ImageGallery
import com.codewithmandyal.movie_explorer.features.details.defaults.components.review.ReviewScreen
import com.codewithmandyal.movie_explorer.features.details.defaults.components.topBar.DetailsTopBar
import com.codewithmandyal.movie_explorer.features.home.defaults.components.ContentSection

@Composable
fun DetailsContent(
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
) {

    val dimens = LocalAppDimens.current

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
            _root_ide_package_.com.codewithmandyal.movie_explorer.features.details.defaults.components.topBar.DetailsTopBar(
                onBackPress = onBackPress,
                title = movie.originalTitle,
                elevated = elevated
            )
        }

        item {
            _root_ide_package_.com.codewithmandyal.movie_explorer.features.details.defaults.components.banner.DetailsScreenBanners(
                banners = banners,
                movie = movie
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }

        item {
            _root_ide_package_.com.codewithmandyal.movie_explorer.features.details.defaults.components.CastView(
                credits.casts
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }

        item {
            _root_ide_package_.com.codewithmandyal.movie_explorer.features.details.defaults.components.CrewView(
                credits.crew
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }

        if (videos.isNotEmpty()) {

            item {
                _root_ide_package_.com.codewithmandyal.movie_explorer.features.details.defaults.components.DetailTitles(
                    "Official Trailer"
                )
            }

            item {
                SpaceVertical(dimens.itemSpacing)
            }

            item {
                _root_ide_package_.com.codewithmandyal.movie_explorer.features.details.defaults.components.TrailerView(
                    videos[0],
                    openYoutube = {
                        YoutubeLauncher.openVideo(it)
                    }
                )
            }

            item {
                SpaceVertical(dimens.sectionSpacing)
            }
        }

        item {
            ContentSection(
                title = "RECOMMENDED FOR YOU",
                movieList = recommendations,
                onDetailsScreen = { id ->
                    onDetailsScreen(id)
                }
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }

        item {
            ContentSection(
                title = if(mediaType == MediaType.MOVIE) "SIMILAR MOVIES" else "SIMILAR TV SHOWS",
                movieList = similar,
                onDetailsScreen = {
                    onDetailsScreen(it)
                }
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }

        item {
            _root_ide_package_.com.codewithmandyal.movie_explorer.features.details.defaults.components.DetailTitles(
                "QUICK FACTS"
            )
        }

        item {
            SpaceVertical(dimens.itemSpacing)
        }

        item {
            _root_ide_package_.com.codewithmandyal.movie_explorer.features.details.defaults.components.QuickFacts(
                movie
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }


        if(reviews.isNotEmpty()){
            item {
                _root_ide_package_.com.codewithmandyal.movie_explorer.features.details.defaults.components.DetailTitles(
                    title = "REVIEWS",
                    isSowViewAll = true
                )
            }

            item {
                SpaceVertical(dimens.itemSpacing)
            }

            item {
                _root_ide_package_.com.codewithmandyal.movie_explorer.features.details.defaults.components.review.ReviewScreen(
                    reviews
                )
            }

            item {
                SpaceVertical(dimens.sectionSpacing)
            }
        }




        item {
            _root_ide_package_.com.codewithmandyal.movie_explorer.features.details.defaults.components.DetailTitles(
                "Image Gallery"
            )
        }

        item {
            SpaceVertical(dimens.itemSpacing)
        }

        item {
            _root_ide_package_.com.codewithmandyal.movie_explorer.features.details.defaults.components.gallery.ImageGallery(
                banners,
                onViewAll = {
                    viewAllImages()
                })
        }
    }
}