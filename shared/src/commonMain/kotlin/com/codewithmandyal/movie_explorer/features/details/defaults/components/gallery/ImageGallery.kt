package com.codewithmandyal.movie_explorer.features.details.defaults.components.gallery

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.codewithmandyal.movie_explorer.core.ui.defaults.GalleryDefaults
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.LocalAppDimens
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.LocalWindowType
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.WindowType
import com.codewithmandyal.movie_explorer.domain.model.Banner

@Composable
fun ImageGallery(
    banners: List<Banner>,
    onViewAll: () -> Unit
) {

    val windowType = LocalWindowType.current
    val dimens = LocalAppDimens.current

    BoxWithConstraints {

        val columns = GalleryDefaults.columns(windowType)

        val maxItems = when (windowType) {
            WindowType.Compact -> 6
            WindowType.Medium,
            WindowType.Expanded -> 12
        }

        val hasMore = banners.size > maxItems

        val visibleItems =
            if (hasMore) {
                banners.take(maxItems - 1)
            } else {
                banners.take(maxItems)
            }

        val itemWidth =
            (maxWidth - dimens.cardSpacing * (columns - 1)) / columns

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            maxItemsInEachRow = columns,
            horizontalArrangement = Arrangement.spacedBy(dimens.cardSpacing),
            verticalArrangement = Arrangement.spacedBy(dimens.cardSpacing)
        ) {

            visibleItems.forEach { banner ->

                _root_ide_package_.com.codewithmandyal.movie_explorer.features.details.defaults.components.gallery.GalleryItem(
                    banner = banner,
                    width = itemWidth,
                    height = GalleryDefaults.imageHeight(windowType)
                )
            }

            if (hasMore) {

                _root_ide_package_.com.codewithmandyal.movie_explorer.features.details.defaults.components.gallery.ViewAllGalleryItem(
                    width = itemWidth,
                    height = GalleryDefaults.imageHeight(windowType),
                    remainingCount = banners.size - (maxItems - 1),
                    onClick = onViewAll
                )
            }
        }
    }
}

