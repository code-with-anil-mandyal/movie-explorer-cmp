package com.codewithmandyal.movie_explorer.features.details.defaults.components.banner

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.codewithmandyal.movie_explorer.core.components.SpaceVertical
import com.codewithmandyal.movie_explorer.core.components.SpacerHorizontal
import com.codewithmandyal.movie_explorer.core.ui.defaults.BannerDefaults
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.LocalAppDimens
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.LocalWindowType
import com.codewithmandyal.movie_explorer.core.utils.toYear
import com.codewithmandyal.movie_explorer.domain.model.Movie
import com.codewithmandyal.movie_explorer.features.home.defaults.components.GenreItem

@Composable
fun BannerContent(
    movie: Movie,
    modifier: Modifier = Modifier
) {

    val dimens = LocalAppDimens.current
    val windowType = LocalWindowType.current

    Column(
        modifier = modifier
            .widthIn(
                max = BannerDefaults.detailsContentWidth(windowType)
            )
            .padding(dimens.screenPadding)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "FEATURED",
                style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = dimens.captionFont,
                    fontWeight = FontWeight.SemiBold,
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
                style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = dimens.captionFont,
                    color = Color(0xFFF6BDBD)
                )
            )

            SpacerHorizontal(dimens.itemSpacing)

            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = Color(0xFFFFD250),
                modifier = Modifier.size(16.dp)
            )

//            SpacerHorizontal(dimens.itemSpacing / 2)
//
//            Text(
//                text = movie.voteAverage.toString(),
//                style = MaterialTheme.typography.bodySmall.copy(
//                    fontSize = dimens.captionFont,
//                    color = Color(0xFFF6BDBD)
//                )
//            )
        }

        SpaceVertical(dimens.itemSpacing)

        Text(
            text = movie.originalTitle,
            style = MaterialTheme.typography.headlineMedium.copy(
                fontSize = dimens.titleFont,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        )

        SpaceVertical(dimens.itemSpacing)

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(dimens.cardSpacing / 2)
        ) {

            items(movie.genres) {

                GenreItem(it)
            }
        }

        SpaceVertical(dimens.itemSpacing)

        Text(
            text = movie.overview,
            modifier = Modifier.height(
                BannerDefaults.detailsOverviewHeight(windowType)
            ),
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = dimens.bodyFont,
                color = Color(0xFFF6C7C7)
            )
        )

        SpaceVertical(dimens.itemSpacing)

        LazyRow(
            verticalAlignment = Alignment.CenterVertically
        ) {

            item {

                Text(
                    text = "Watch In",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = dimens.bodyFont,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                )
            }

            item {

                SpacerHorizontal(dimens.itemSpacing)
            }

            items(movie.languages) {

                Text(
                    text = it,
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontSize = dimens.captionFont,
                        color = Color(0xFFF6C7C7)
                    )
                )
            }
        }

        SpaceVertical(dimens.sectionSpacing / 2)

        _root_ide_package_.com.codewithmandyal.movie_explorer.features.details.defaults.components.banner.BannerActions()
    }
}