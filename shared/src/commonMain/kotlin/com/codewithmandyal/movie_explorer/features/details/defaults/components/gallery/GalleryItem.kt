package com.codewithmandyal.movie_explorer.features.details.defaults.components.gallery

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.compose.SubcomposeAsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.codewithmandyal.movie_explorer.domain.model.Banner
import movieexplorer.shared.generated.resources.Res
import movieexplorer.shared.generated.resources.movie_explorer_logo
import org.jetbrains.compose.resources.painterResource

//@Composable
//fun GalleryItem(
//    banner: Banner,
//    isCompact: Boolean,
//    itemWidth: Dp
//) {
//    AsyncImage(
//        model = banner.filePath,
//        contentDescription = null,
//        placeholder = painterResource(Res.drawable.movie_explorer_logo),
//        error = painterResource(Res.drawable.movie_explorer_logo),
//        fallback = painterResource(Res.drawable.movie_explorer_logo),
//        modifier = Modifier
//            .width(if (isCompact) itemWidth else 200.dp)
//            .height(if (isCompact) 150.dp else 200.dp),
//        contentScale = ContentScale.Crop
//    )
//}

@Composable
fun GalleryItem(
    banner: Banner,
    width: Dp,
    height: Dp
) {
//    AsyncImage(
//        model = banner.filePath,
//        contentDescription = null,
//        placeholder = painterResource(Res.drawable.movie_explorer_logo),
//        error = painterResource(Res.drawable.movie_explorer_logo),
//        fallback = painterResource(Res.drawable.movie_explorer_logo),
//        modifier = Modifier
//            .width(width)
//            .height(height),
//        contentScale = ContentScale.Crop
//    )

    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalPlatformContext.current)
            .data(banner.filePath)
            .crossfade(true)
            .crossfade(300)
            .build(),
        contentDescription = null,
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
        },
        modifier = Modifier
            .width(width)
            .height(height),
        contentScale = ContentScale.Crop
    )
}