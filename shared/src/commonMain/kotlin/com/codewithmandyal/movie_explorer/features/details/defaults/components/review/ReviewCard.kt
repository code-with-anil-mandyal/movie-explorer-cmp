package com.codewithmandyal.movie_explorer.features.details.defaults.components.review

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.codewithmandyal.movie_explorer.core.components.SpaceVertical
import com.codewithmandyal.movie_explorer.core.components.SpacerHorizontal
import com.codewithmandyal.movie_explorer.core.ui.defaults.ReviewCardDefaults
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.LocalAppDimens
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.LocalWindowType
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.WindowType
import com.codewithmandyal.movie_explorer.domain.model.Review


@Composable
fun ReviewCard(
    review: Review,
    onReadMore: (Review) -> Unit
) {

    val dimens = LocalAppDimens.current
    val windowType = LocalWindowType.current

    ElevatedCard(
        modifier = Modifier
            .width(ReviewCardDefaults.width(windowType))
            .height(ReviewCardDefaults.height(windowType)),
        shape = RoundedCornerShape(dimens.cornerLarge),
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color(0xFF1B1B1B)
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimens.itemSpacing * 1.5f)
        ) {

            if (windowType == WindowType.Compact) {

                // Mobile Layout
                Column {

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        _root_ide_package_.com.codewithmandyal.movie_explorer.features.details.defaults.components.review.Avatar(
                            avatarPath = review.avatarPath,
                            name = review.name
                        )

                        SpacerHorizontal(dimens.itemSpacing)

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {

                            Text(
                                text = review.name.orEmpty(),
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis,
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontSize = dimens.sectionTitleFont,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            )

                            Text(
                                text = review.date.orEmpty(),
                                style = MaterialTheme.typography.bodySmall.copy(
                                    fontSize = dimens.captionFont,
                                    color = Color.LightGray
                                )
                            )
                        }
                    }

                    SpaceVertical(dimens.itemSpacing)

                    _root_ide_package_.com.codewithmandyal.movie_explorer.features.details.defaults.components.review.RatingBadge(
                        review.rating ?: 0.0
                    )
                }

            } else {

                // Tablet/Desktop Layout
                Row(
                    verticalAlignment = Alignment.Top
                ) {

                    _root_ide_package_.com.codewithmandyal.movie_explorer.features.details.defaults.components.review.Avatar(
                        avatarPath = review.avatarPath,
                        name = review.name
                    )

                    SpacerHorizontal(dimens.itemSpacing)

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Text(
                            text = review.name.orEmpty(),
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontSize = dimens.sectionTitleFont,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        )

                        Text(
                            text = review.date.orEmpty(),
                            style = MaterialTheme.typography.bodySmall.copy(
                                fontSize = dimens.captionFont,
                                color = Color.LightGray
                            )
                        )
                    }

                    SpacerHorizontal(dimens.itemSpacing)

                    _root_ide_package_.com.codewithmandyal.movie_explorer.features.details.defaults.components.review.RatingBadge(
                        review.rating ?: 0.0
                    )
                }
            }

            SpaceVertical(dimens.itemSpacing * 2)

            Text(
                text = buildString {
                    append(review.content?.take(100).orEmpty())
                    if ((review.content?.length ?: 0) > 100) {
                        append("...")
                    }
                },
                maxLines = 5,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = dimens.bodyFont,
                    color = Color(0xFFECCACA),
                    fontStyle = FontStyle.Italic,
                    lineHeight = 24.sp
                )
            )

            Spacer(modifier = Modifier.weight(1f))

            if ((review.content?.length ?: 0) > 100) {

                Text(
                    text = "Read More",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = dimens.bodyFont,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Red
                    ),
                    modifier = Modifier.clickable {
                        onReadMore(review)
                    }
                )
            }
        }
    }
}

