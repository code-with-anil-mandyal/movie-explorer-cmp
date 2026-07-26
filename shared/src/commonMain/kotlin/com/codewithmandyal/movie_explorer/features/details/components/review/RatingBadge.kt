package com.codewithmandyal.movie_explorer.features.details.components.review

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.codewithmandyal.movie_explorer.core.components.SpacerHorizontal
import com.codewithmandyal.movie_explorer.core.ui.defaults.ReviewCardDefaults
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.LocalAppDimens
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.LocalWindowType


@Composable
fun RatingBadge(
    rating: Double,
    modifier: Modifier = Modifier
) {

    val dimens = LocalAppDimens.current
    val windowType = LocalWindowType.current

    val formattedRating = ((rating * 10).toInt() / 10.0).toString()

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(dimens.cornerMedium))
            .background(Color(0xFF1C1C1C))
            .border(
                BorderStroke(0.5.dp, Color(0xFFFFC107)),
                RoundedCornerShape(dimens.cornerMedium)
            )
            .padding(
                horizontal = dimens.itemSpacing * 0.75f,
                vertical = dimens.itemSpacing * 0.25f
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = null,
            tint = Color(0xFFFFC107),
            modifier = Modifier.size(
                ReviewCardDefaults.ratingIconSize(windowType) * 0.8f
            )
        )

        SpacerHorizontal(4.dp)

        Text(
            text = formattedRating,
            style = MaterialTheme.typography.bodySmall.copy(
                fontSize = dimens.captionFont,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        )

        Text(
            text = "/10",
            style = MaterialTheme.typography.bodySmall.copy(
                fontSize = dimens.captionFont * 0.9f,
                color = Color.Gray
            )
        )
    }
}