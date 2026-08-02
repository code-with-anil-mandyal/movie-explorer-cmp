package com.codewithmandyal.movie_explorer.features.details.defaults.components.gallery

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ViewAllGalleryItem(
    width: Dp,
    height: Dp,
    remainingCount: Int,
    onClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .width(width)
            .height(height)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.DarkGray)
            .clickable {
                onClick()
            },
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "+$remainingCount",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "View All",
                color = Color.White,
                fontWeight = FontWeight.Medium
            )
        }
    }
}