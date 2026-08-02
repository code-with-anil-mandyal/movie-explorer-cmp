package com.codewithmandyal.movie_explorer.features.details.defaults.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.codewithmandyal.movie_explorer.core.components.SpaceVertical
import com.codewithmandyal.movie_explorer.core.ui.defaults.CastCardDefaults
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.LocalAppDimens
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.LocalWindowType
import com.codewithmandyal.movie_explorer.domain.model.CastAndCrew
import movieexplorer.shared.generated.resources.Res
import movieexplorer.shared.generated.resources.movie_explorer_logo
import org.jetbrains.compose.resources.painterResource

@Composable
fun CreditItem(
    castAndCrew: CastAndCrew
) {

    val dimens = LocalAppDimens.current
    val windowType = LocalWindowType.current

    Column(
        modifier = Modifier.width(
            CastCardDefaults.cardWidth(windowType)
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AsyncImage(
            model = castAndCrew.profilePath,
            contentDescription = null,
            placeholder = painterResource(Res.drawable.movie_explorer_logo),
            error = painterResource(Res.drawable.movie_explorer_logo),
            fallback = painterResource(Res.drawable.movie_explorer_logo),
            modifier = Modifier
                .size(
                    CastCardDefaults.imageSize(windowType)
                )
                .border(
                    BorderStroke(
                        1.dp,
                        Color.Red
                    ),
                    CircleShape
                )
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        SpaceVertical(dimens.itemSpacing / 2)

        Text(
            text = castAndCrew.name,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = dimens.captionFont,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        )

        SpaceVertical(dimens.itemSpacing / 2)

        Text(
            text = castAndCrew.character,
            modifier = Modifier.height(
                CastCardDefaults.roleHeight(windowType)
            ),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodySmall.copy(
                fontSize = dimens.captionFont,
                color = Color(0xFFF6BDBD)
            )
        )
    }
}