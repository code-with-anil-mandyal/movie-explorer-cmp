package com.codewithmandyal.movie_explorer.features.home.tv.components

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
import androidx.compose.ui.unit.TextUnit
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.LocalAppDimens
import com.codewithmandyal.movie_explorer.core.ui.responsive.tv.LocalTvDimens

@Composable
fun TvHomeTitles(
    title: String,
    textSize: TextUnit = LocalTvDimens.current.sectionTitleFont,
    viewAllSize: TextUnit = LocalTvDimens.current.bodyFont
) {

    val dimens = LocalTvDimens.current

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