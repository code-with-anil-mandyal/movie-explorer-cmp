package com.codewithmandyal.movie_explorer.features.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.codewithmandyal.movie_explorer.core.ui.responsive.LocalAppDimens

@Composable
fun HomeTitles(
    title: String,
    textSize: TextUnit = LocalAppDimens.current.sectionTitleFont,
    viewAllSize: TextUnit = LocalAppDimens.current.bodyFont
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
            style = MaterialTheme.typography.titleLarge.copy(
                fontSize = textSize,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        )

        Text(
            text = "VIEW ALL",
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = viewAllSize,
                fontWeight = FontWeight.Bold,
                color = Color.Red
            )
        )
    }
}