package com.codewithmandyal.movie_explorer.features.home.tv.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusTarget
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil3.compose.LocalPlatformContext
import coil3.compose.SubcomposeAsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.codewithmandyal.movie_explorer.core.components.SpaceVertical
import com.codewithmandyal.movie_explorer.core.ui.defaults.tv.TvMovieCardDefaults
import com.codewithmandyal.movie_explorer.core.ui.responsive.tv.LocalTvDimens
import com.codewithmandyal.movie_explorer.core.ui.responsive.tv.LocalTvWindowType
import com.codewithmandyal.movie_explorer.core.utils.toYear
import com.codewithmandyal.movie_explorer.domain.model.Movie
import movieexplorer.shared.generated.resources.Res
import movieexplorer.shared.generated.resources.movie_explorer_logo
import org.jetbrains.compose.resources.painterResource

@Composable
fun TvCardsView(
    movie: Movie,
    modifier: Modifier = Modifier,
    onDetailsScreen: (id: Int) -> Unit,
    onFocused: () -> Unit = {}
) {

    val dimens = LocalTvDimens.current
    val windowType = LocalTvWindowType.current

    var focused by remember {
        mutableStateOf(false)
    }

    val scale by animateFloatAsState(
        targetValue = if (focused) 1.08f else 1f,
        animationSpec = tween(150),
        label = "CardScale"
    )

    val borderColor by animateColorAsState(
        targetValue = if (focused) Color.Red else Color.Transparent,
        animationSpec = tween(150),
        label = "BorderColor"
    )

    val elevation by animateDpAsState(
        targetValue = if (focused) 18.dp else 6.dp,
        animationSpec = tween(150),
        label = "CardElevation"
    )

    Column(
        modifier = Modifier
            .width(TvMovieCardDefaults.width(windowType))
            .background(Color(0xFF0F0F0F))

    ) {

        ElevatedCard(
            modifier = modifier
                .fillMaxWidth()
                .aspectRatio(2f / 3f)
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                }
                .zIndex(if (focused) 1f else 0f)
                .onFocusChanged {
                    focused = it.isFocused
                    if (it.isFocused) {
                        onFocused()
                    }
                }
                .clickable {
                    onDetailsScreen(movie.id)
                }
                .focusTarget()
                .border(
                    width = if (focused) 3.dp else 0.dp,
                    color = borderColor,
                    shape = RoundedCornerShape(dimens.cornerMedium)
                ),
            colors = CardDefaults.cardColors(
                containerColor = Color.Black
            ),
            shape = RoundedCornerShape(dimens.cornerMedium),
            elevation = CardDefaults.elevatedCardElevation(elevation)
        ) {

            SubcomposeAsyncImage(
                model = ImageRequest.Builder(LocalPlatformContext.current)
                    .data(movie.posterPath)
                    .crossfade(true)
                    .crossfade(300)
                    .build(),
                contentDescription = movie.originalTitle,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                loading = {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(
                            color = Color(0xFFE50914)
                        )
                    }
                },
                error = {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(Res.drawable.movie_explorer_logo),
                            contentDescription = null
                        )
                    }
                }
            )
        }

        SpaceVertical(dimens.itemSpacing)

        Text(
            text = movie.originalTitle,
            minLines = 2,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleSmall.copy(
                fontWeight = FontWeight.SemiBold,
                fontSize = dimens.bodyFont
            ),
            color = if (focused) Color.White else Color(0xFFE0E0E0),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimens.itemSpacing)
        )

        SpaceVertical(dimens.itemSpacing / 2)

        Text(
            text = movie.releaseDate.toYear(),
            style = MaterialTheme.typography.bodySmall.copy(
                fontWeight = FontWeight.SemiBold,
                fontSize = dimens.captionFont
            ),
            color = if (focused) Color.White else Color(0xFFF6BDBD),
            modifier = Modifier.padding(start = dimens.itemSpacing)
        )
    }
}