package com.codewithmandyal.movie_explorer.features.home.defaults.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.codewithmandyal.movie_explorer.core.components.SpaceVertical
import com.codewithmandyal.movie_explorer.core.components.SpacerHorizontal
import com.codewithmandyal.movie_explorer.core.ui.defaults.BannerDefaults
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.LocalAppDimens
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.LocalWindowType
import com.codewithmandyal.movie_explorer.core.utils.toYear
import com.codewithmandyal.movie_explorer.domain.model.Movie

@Composable
fun HomeBanner(
    movie: Movie,
    onDetailsScreen: (id: Int) -> Unit
) {

    val dimens = LocalAppDimens.current
    val windowType = LocalWindowType.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(BannerDefaults.height(windowType))
            .background(Color.Black)
    ) {

        AsyncImage(
            model = movie.backdropPath,
            contentDescription = "Movie Poster",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .widthIn(max = BannerDefaults.contentWidth(windowType))
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
                    GenreItem(genre)
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
                modifier = Modifier.height(100.dp)
            )

            SpaceVertical(dimens.sectionSpacing / 2)

            Row(
                horizontalArrangement = Arrangement.spacedBy(dimens.itemSpacing)
            ) {

                Box(
                    modifier = Modifier
                        .width(BannerDefaults.watchButtonWidth(windowType))
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

                Box(
                    modifier = Modifier
                        .width(BannerDefaults.detailsButtonWidth(windowType))
                        .height(dimens.searchBarHeight)
                        .background(
                            Color.DarkGray,
                            RoundedCornerShape(dimens.cornerMedium)
                        )
                        .border(
                            BorderStroke(0.5.dp, Color.LightGray),
                            RoundedCornerShape(dimens.cornerMedium)
                        )
                        .clickable {
                            onDetailsScreen(movie.id)
                        },
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