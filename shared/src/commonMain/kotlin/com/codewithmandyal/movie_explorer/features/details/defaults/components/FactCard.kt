package com.codewithmandyal.movie_explorer.features.details.defaults.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.codewithmandyal.movie_explorer.core.components.SpaceVertical
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.LocalAppDimens


@Composable
fun FactCard(
    modifier: Modifier = Modifier,
    title: String,
    value: String
) {

    val dimens = LocalAppDimens.current

    ElevatedCard(
        modifier = modifier.height(160.dp),
        shape = RoundedCornerShape(dimens.cornerLarge),
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color(0xFF1B1B1B)
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimens.screenPadding)
        ) {

            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = dimens.bodyFont,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFFE8BDBD)
                )
            )

            SpaceVertical(dimens.itemSpacing)

            Text(
                text = value,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = dimens.sectionTitleFont,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            )
        }
    }
}