package com.codewithmandyal.movie_explorer.features.home.defaults.components.topbar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.codewithmandyal.movie_explorer.core.components.SpacerHorizontal
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.LocalAppDimens

@Composable
fun SearchBar(
    onClick: () -> Unit = {}
) {

    val dimens = LocalAppDimens.current

    Surface(
        modifier = Modifier
            .width(dimens.searchBarWidth)
            .height(dimens.searchBarHeight)
            .clip(RoundedCornerShape(50))
            .clickable(onClick = onClick),
        color = Color(0xFF252525).copy(alpha = 0.85f),
        border = BorderStroke(
            width = 1.dp,
            color = Color.White.copy(alpha = 0.08f)
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = dimens.screenPadding),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Color.Gray,
                modifier = Modifier.size(20.dp)
            )

            SpacerHorizontal(dimens.itemSpacing)

            Text(
                text = "Search movies...",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = dimens.bodyFont,
                    color = Color.Gray
                ),
                maxLines = 1
            )
        }
    }
}