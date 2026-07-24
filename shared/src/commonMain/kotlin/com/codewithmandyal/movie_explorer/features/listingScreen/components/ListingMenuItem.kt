package com.codewithmandyal.movie_explorer.features.listingScreen.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.codewithmandyal.movie_explorer.core.components.SpaceVertical
import com.codewithmandyal.movie_explorer.core.ui.responsive.LocalAppDimens

@Composable
fun ListingMenuItem(
    title: String,
    selected: Boolean,
    onClick: () -> Unit
) {

    val dimens = LocalAppDimens.current

    val color by animateColorAsState(
        targetValue = if (selected) Color.Red else Color.White,
        label = ""
    )

    Column(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(vertical = dimens.itemSpacing),
        horizontalAlignment = Alignment.Start
    ) {

        Text(
            text = title,
            fontSize = dimens.sectionTitleFont,
            fontWeight = FontWeight.Bold,
            color = color
        )

        SpaceVertical(6.dp)

        Box(
            modifier = Modifier
                .height(3.dp)
                .width(if (selected) 42.dp else 0.dp)
                .clip(RoundedCornerShape(50))
                .background(if (selected) Color.Red else Color.Transparent)
        )
    }
}