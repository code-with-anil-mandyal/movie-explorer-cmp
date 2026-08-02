package com.codewithmandyal.movie_explorer.features.home.tv.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.focusTarget
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.codewithmandyal.movie_explorer.core.components.SpaceVertical
import com.codewithmandyal.movie_explorer.core.components.SpacerHorizontal
import com.codewithmandyal.movie_explorer.core.ui.defaults.tv.TvBannerDefaults
import com.codewithmandyal.movie_explorer.core.ui.responsive.tv.LocalTvDimens
import com.codewithmandyal.movie_explorer.core.ui.responsive.tv.LocalTvWindowType
import com.codewithmandyal.movie_explorer.core.utils.toYear
import com.codewithmandyal.movie_explorer.domain.model.Movie

@Composable
fun TvBanner(
    watchRequester: FocusRequester,
    upRequester: FocusRequester,
    downRequester: FocusRequester,
    movie: Movie,
    onWatchNow: (Int) -> Unit = {},
    onDetailsScreen: (Int) -> Unit,
    onBannerFocusChanged: (Boolean) -> Unit,
    onWatchNowFocused: () -> Unit = {}
) {

    val dimens = LocalTvDimens.current
    val windowType = LocalTvWindowType.current


    val detailsRequester = remember { FocusRequester() }

    var watchFocused by remember { mutableStateOf(false) }
    var detailsFocused by remember { mutableStateOf(false) }


    val watchScale by animateFloatAsState(
        targetValue = if (watchFocused) 1.08f else 1f,
        animationSpec = tween(150),
        label = "WatchScale"
    )

    val detailsScale by animateFloatAsState(
        targetValue = if (detailsFocused) 1.08f else 1f,
        animationSpec = tween(150),
        label = "DetailsScale"
    )

    LaunchedEffect(watchFocused, detailsFocused) {
        onBannerFocusChanged(
            watchFocused || detailsFocused
        )
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(TvBannerDefaults.height(windowType))
            .background(Color.Black)
    ){

//        AsyncImage(
//            model = movie.backdropPath,
//            contentDescription = movie.originalTitle,
//            modifier = Modifier.fillMaxSize(),
//            contentScale = ContentScale.Fit
//        )

        AsyncImage(
            model = movie.backdropPath,
            contentDescription = movie.originalTitle,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.72f)
                .align(Alignment.CenterEnd),
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center
        )

//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(
//                    Brush.horizontalGradient(
//                        listOf(
//                            Color.Black.copy(alpha = .92f),
//                            Color.Black.copy(alpha = .75f),
//                            Color.Black.copy(alpha = .35f),
//                            Color.Transparent
//                        )
//                    )
//                )
//        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.horizontalGradient(
                        colorStops = arrayOf(
                            0.00f to Color.Black,
                            0.25f to Color.Black,
                            0.45f to Color.Black.copy(alpha = 0.90f),
                            0.62f to Color.Black.copy(alpha = 0.45f),
                            0.80f to Color.Black.copy(alpha = 0.12f),
                            1.00f to Color.Transparent
                        )
                    )
                )
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color.Transparent,
                            Color.Transparent,
                            Color.Black.copy(alpha = .45f),
                            Color.Black.copy(alpha = .8f)
                        )
                    )
                )
        )

        Column(
            modifier = Modifier
                .widthIn(max = TvBannerDefaults.contentWidth(windowType))
                .padding(dimens.screenPadding)
                .align(Alignment.BottomStart)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "FEATURED",
                    style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = dimens.captionFont,
                        color = Color.White
                    ),
                    modifier = Modifier
                        .background(
                            Color.Red,
                            RoundedCornerShape(dimens.cornerSmall)
                        )
                        .padding(
                            vertical = dimens.itemSpacing / 4,
                            horizontal = dimens.itemSpacing / 2
                        )
                )

                SpacerHorizontal(dimens.itemSpacing)

                Text(
                    text = movie.releaseDate.toYear(),
                    style = TextStyle(
                        fontSize = dimens.captionFont,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFFF6BDBD)
                    )
                )

                SpacerHorizontal(dimens.itemSpacing)

                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    tint = Color(0xFFFFD250),
                    modifier = Modifier.size(15.dp)
                )

                SpacerHorizontal(dimens.itemSpacing / 2)

                Text(
                    text = "8.7",
                    style = TextStyle(
                        fontSize = dimens.captionFont,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFFF6BDBD)
                    )
                )
            }

            SpaceVertical(dimens.itemSpacing)

            Text(
                text = movie.originalTitle,
                style = TextStyle(
                    fontSize = dimens.titleFont,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            )

            SpaceVertical(dimens.itemSpacing)

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(dimens.itemSpacing / 2)
            ) {
                items(movie.genres) { genre ->
                    TvGenreItem(genre)
                }
            }

            SpaceVertical(dimens.itemSpacing)


            Text(
                text = movie.overview,
                style = TextStyle(
                    fontSize = dimens.bodyFont,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFFF6C7C7)
                ),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.width(650.dp)
            )

            SpaceVertical(dimens.sectionSpacing / 2)

            Row(
                horizontalArrangement = Arrangement.spacedBy(dimens.itemSpacing)
            ) {

                //Watch now button
                Box(
                    modifier = Modifier
                        .focusRequester(watchRequester)
                        .focusProperties {
                            up = upRequester
                            down = downRequester
                            right = detailsRequester
                        }

                        .onFocusChanged {
                            watchFocused = it.isFocused

                            if (it.isFocused) {
                                onWatchNowFocused()
                            }
                        }
                        .graphicsLayer {
                            scaleX = watchScale
                            scaleY = watchScale
                        }.clickable {
                            onWatchNow(movie.id)
                        }
                        .focusTarget()
                        .width(TvBannerDefaults.watchButtonWidth(windowType))
                        .height(dimens.searchBarHeight)
                        .background(
                            Color.Red,
                            RoundedCornerShape(dimens.cornerMedium)
                        ),
                    contentAlignment = Alignment.Center
                ) {



                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = null,
                            tint = Color.White
                        )

                        SpacerHorizontal(dimens.itemSpacing)

                        Text(
                            text = "Watch Now",
                            style = TextStyle(
                                fontSize = dimens.bodyFont,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White
                            )
                        )
                    }
                }


                // Details button
                Box(
                    modifier = Modifier
                        .focusRequester(detailsRequester)
                        .focusProperties {
                            up = upRequester
                            down = downRequester
                            left = watchRequester
                        }
                        .onFocusChanged {
                            detailsFocused = it.isFocused
                        }
                        .graphicsLayer {
                            scaleX = detailsScale
                            scaleY = detailsScale
                        }
                        .clickable {
                            onDetailsScreen(movie.id)
                        }
                        .focusTarget()
                        .width(TvBannerDefaults.detailsButtonWidth(windowType))
                        .height(dimens.searchBarHeight)
                        .background(
                            Color.DarkGray,
                            RoundedCornerShape(dimens.cornerMedium)
                        )
                        .border(
                            BorderStroke(
                                width =  1.dp,
                                color =  Color.LightGray
                            ),
                            RoundedCornerShape(dimens.cornerMedium)
                        ),
                    contentAlignment = Alignment.Center
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            imageVector = Icons.Outlined.Info,
                            contentDescription = null,
                            tint = Color.White
                        )

                        SpacerHorizontal(dimens.itemSpacing)

                        Text(
                            text = "Details",
                            style = TextStyle(
                                fontSize = dimens.bodyFont,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White
                            )
                        )
                    }
                }
            }
        }
    }
}

