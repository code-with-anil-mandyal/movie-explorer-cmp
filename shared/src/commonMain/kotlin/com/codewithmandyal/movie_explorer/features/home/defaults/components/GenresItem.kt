package com.codewithmandyal.movie_explorer.features.home.defaults.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.LocalAppDimens

@Composable
fun GenreItem(genre: String) {

    val dimens = LocalAppDimens.current

    Column(
        modifier = Modifier
            .background(
                Color(0xFF0F0F0F),
                shape = RoundedCornerShape(dimens.cornerMedium)
            )
            .border(
                BorderStroke(0.5.dp, Color.LightGray),
                shape = RoundedCornerShape(dimens.cornerMedium)
            )
            .padding(
                horizontal = dimens.itemSpacing,
                vertical = 0.dp
            )
    ) {

        Text(
            text = genre,
            color = Color(0xFFF6C7C7),
            fontSize = dimens.captionFont,
            fontWeight = FontWeight.Medium
        )
    }
}