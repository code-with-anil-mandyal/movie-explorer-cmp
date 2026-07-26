package com.codewithmandyal.movie_explorer.features.details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.LocalAppDimens

@Composable
fun DetailTitles(
    title: String,
    isSowViewAll: Boolean = false
) {

    val dimens = LocalAppDimens.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = dimens.screenPadding),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium.copy(
                fontSize = dimens.sectionTitleFont,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        )

        if (isSowViewAll) {

            Text(
                text = "VIEW ALL",
                style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = dimens.captionFont,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red
                )
            )
        }
    }
}