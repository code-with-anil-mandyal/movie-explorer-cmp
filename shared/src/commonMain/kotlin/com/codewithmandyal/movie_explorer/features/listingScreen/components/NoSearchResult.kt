package com.codewithmandyal.movie_explorer.features.listingScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codewithmandyal.movie_explorer.core.components.SpaceVertical

@Composable
fun NoSearchResult(
    query: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "😔",
            fontSize = 60.sp
        )

        SpaceVertical(height = 16.dp)

        Text(
            text = "No movies found",
            style = MaterialTheme.typography.titleMedium,
            color = Color.White
        )

        SpaceVertical(height = 8.dp)

        Text(
            text = "Try another keyword.",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White
        )

        SpaceVertical(height = 4.dp)

        Text(
            text = "\"$query\"",
            style = MaterialTheme.typography.bodySmall,
            color = Color.White
        )
    }
}