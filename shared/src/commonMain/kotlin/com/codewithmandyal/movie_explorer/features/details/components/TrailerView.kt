package com.codewithmandyal.movie_explorer.features.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleFilled
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import com.codewithmandyal.movie_explorer.core.ui.defaults.TrailerDefaults
import com.codewithmandyal.movie_explorer.core.ui.responsive.LocalAppDimens
import com.codewithmandyal.movie_explorer.core.ui.responsive.LocalWindowType
import com.codewithmandyal.movie_explorer.core.ui.responsive.WindowType
import com.codewithmandyal.movie_explorer.domain.model.Video

@Composable
fun TrailerView(
    video: Video,
    openYoutube: (videoId: String) -> Unit
) {

    val dimens = LocalAppDimens.current
    val windowType = LocalWindowType.current

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {

        val bannerModifier =
            if (windowType == WindowType.Compact) {

                Modifier
                    .fillMaxWidth()

            } else {

                Modifier
                    .widthIn(
                        max = TrailerDefaults.contentMaxWidth(windowType)
                    )
                    .fillMaxWidth()
            }

        Box(
            modifier = bannerModifier
                .aspectRatio(16f / 9f)
                .padding(horizontal = dimens.screenPadding)
                .clip(RoundedCornerShape(dimens.cornerLarge))
                .clickable {
                    openYoutube(video.key)
                }
        ) {

            AsyncImage(
                model = "https://img.youtube.com/vi/${video.key}/maxresdefault.jpg",
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Color.Black.copy(alpha = 0.25f)
                    )
            )

            Icon(
                imageVector = Icons.Default.PlayCircleFilled,
                contentDescription = null,
                tint = Color.Red,
                modifier = Modifier
                    .size(
                        TrailerDefaults.playButtonSize(windowType)
                    )
                    .align(Alignment.Center)
            )
        }
    }
}

