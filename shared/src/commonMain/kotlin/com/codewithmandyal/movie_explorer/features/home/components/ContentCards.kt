package com.codewithmandyal.movie_explorer.features.home.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.compose.SubcomposeAsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.codewithmandyal.movie_explorer.core.components.SpaceVertical
import com.codewithmandyal.movie_explorer.core.ui.defaults.MovieCardDefaults
import com.codewithmandyal.movie_explorer.core.ui.responsive.LocalAppDimens
import com.codewithmandyal.movie_explorer.core.ui.responsive.LocalWindowType
import com.codewithmandyal.movie_explorer.core.utils.MediaType
import com.codewithmandyal.movie_explorer.core.utils.toYear
import com.codewithmandyal.movie_explorer.domain.model.Movie
import movieexplorer.shared.generated.resources.Res
import movieexplorer.shared.generated.resources.movie_explorer_logo
import org.jetbrains.compose.resources.painterResource

@Composable
fun ContentCards(movies: List<Movie>, onDetailsScreen: (id: Int) -> Unit) {

    val dimens = LocalAppDimens.current

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = dimens.screenPadding),
        horizontalArrangement = Arrangement.spacedBy(dimens.cardSpacing)
    ) {

        items(movies) {

            CardsView(
                it, onDetailsScreen = { id ->
                onDetailsScreen(id)
            })
        }
    }
}

@Composable
fun CardsView(
    movie: Movie,
    modifier: Modifier = Modifier,
    onDetailsScreen: (id: Int) -> Unit
) {
    val dimens = LocalAppDimens.current
    val windowType = LocalWindowType.current

    val interactionSource = remember { MutableInteractionSource() }
    val pressed by interactionSource.collectIsPressedAsState()

    val scale by animateFloatAsState(
        targetValue = if (pressed) 0.96f else 1f,
        label = "cardScale"
    )

    val height = MovieCardDefaults.height(windowType)

    Column(
        modifier = modifier
            .width( MovieCardDefaults.width(windowType))
            .background(Color(0xFF0F0F0F))

    ) {

        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .graphicsLayer{
                    scaleX = scale
                    scaleY = scale
                }
                .aspectRatio(2f / 3f)
                .clickable(
                    interactionSource = interactionSource,
                    indication = LocalIndication.current
                ) {
                    onDetailsScreen(movie.id)
                },
            colors = CardDefaults.cardColors(
                containerColor = Color.Black
            ),
            shape = RoundedCornerShape(dimens.cornerMedium),
            elevation = CardDefaults.elevatedCardElevation(6.dp)
        ) {


            SubcomposeAsyncImage(
                model = ImageRequest.Builder(LocalPlatformContext.current)
                    .data(movie.posterPath)
                    .crossfade(true)
                    .crossfade(300)
                    .build(),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds,
                loading = {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier.align(Alignment.Center),
                            color = Color(0xFFE50914)
                        )
                    }
                },
                error = {
                    painterResource(Res.drawable.movie_explorer_logo)
                }
            )


        }

        SpaceVertical(dimens.itemSpacing)

        Text(
            text = movie.originalTitle,
            minLines = 2,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            softWrap = true,
            style = MaterialTheme.typography.titleSmall.copy(
                fontWeight = FontWeight.SemiBold,
                fontSize = dimens.bodyFont
            ),
            color = Color.White,
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
            color = Color(0xFFF6BDBD),
            modifier = Modifier.padding(start = dimens.itemSpacing)
        )
    }
}