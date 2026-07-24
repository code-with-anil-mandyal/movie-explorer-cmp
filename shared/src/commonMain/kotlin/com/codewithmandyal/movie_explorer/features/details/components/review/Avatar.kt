package com.codewithmandyal.movie_explorer.features.details.components.review

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.codewithmandyal.movie_explorer.core.ui.defaults.ReviewCardDefaults
import com.codewithmandyal.movie_explorer.core.ui.responsive.LocalAppDimens
import com.codewithmandyal.movie_explorer.core.ui.responsive.LocalWindowType
import com.codewithmandyal.movie_explorer.data.remote.NetworkConstants.PROFILE_PIC_BASE_URL

@Composable
fun Avatar(
    avatarPath: String?,
    name: String?
) {

    val windowType = LocalWindowType.current
    val dimens = LocalAppDimens.current

    val avatarSize = ReviewCardDefaults.avatarSize(windowType)

    val imageUrl = avatarPath?.let {
        "$PROFILE_PIC_BASE_URL$it"
    }

    if (!imageUrl.isNullOrBlank()) {

        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = Modifier
                .size(avatarSize)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

    } else {

        Box(
            modifier = Modifier
                .size(avatarSize)
                .clip(CircleShape)
                .background(Color.DarkGray),
            contentAlignment = Alignment.Center
        ) {

            val initials = name
                ?.trim()
                ?.split(Regex("\\s+"))
                ?.filter { it.isNotBlank() }
                ?.take(2)
                ?.joinToString("") { it.first().uppercase() }
                ?: ""

            if (initials.isNotEmpty()) {

                Text(
                    text = initials,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = dimens.bodyFont,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )

            } else {

                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    }
}