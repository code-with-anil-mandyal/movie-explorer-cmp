package com.codewithmandyal.movie_explorer.features.home.components.topbar

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.codewithmandyal.movie_explorer.core.components.SpacerHorizontal
import com.codewithmandyal.movie_explorer.core.ui.responsive.LocalAppDimens
import com.codewithmandyal.movie_explorer.core.utils.ListingType
import movieexplorer.shared.generated.resources.Res
import movieexplorer.shared.generated.resources.movie_explorer_logo
import org.jetbrains.compose.resources.painterResource

@Composable
fun DesktopTopBar(
    elevated: Boolean,
    onListingScreen: (listingType: ListingType) -> Unit
) {

    val dimens = LocalAppDimens.current

    val menus = listOf(
        "Trending",
        "Popular",
        "Top Rated"
    )

    val backgroundColor by animateColorAsState(
        targetValue = if (elevated) {
            Color(0xFF151515).copy(alpha = 0.95f)
        } else {
            Color(0xFF151515).copy(alpha = 0.75f)
        },
        label = "TopBarBackground"
    )

    val elevation by animateDpAsState(
        targetValue = if (elevated) 6.dp else 0.dp,
        label = "TopBarElevation"
    )

    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = backgroundColor,
        tonalElevation = elevation,
        shadowElevation = elevation
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(dimens.toolbarHeight)
                .padding(horizontal = dimens.screenPadding),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(Res.drawable.movie_explorer_logo),
                contentDescription = null,
                modifier = Modifier.size(dimens.logoSize)
            )

            SpacerHorizontal(dimens.itemSpacing)

            Text(
                text = "MovieExplorer",
                style = MaterialTheme.typography.titleMedium.copy(
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = dimens.titleFont
                )
            )

            SpacerHorizontal(dimens.sectionSpacing)

            SearchBar(
                onClick = {
                    onListingScreen(ListingType.SEARCH)
                }
            )

            Spacer(Modifier.weight(1f))

            menus.forEachIndexed { index, item ->

                Text(
                    text = item,
                    color = Color.White,
                    //color = if (index == 0) Color.Red else Color.White,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = dimens.bodyFont,
                        fontWeight = FontWeight.SemiBold
                    ),
                    modifier = Modifier
                        .padding(horizontal = dimens.itemSpacing)
                        .clickable {
                                when(index){
                                    0 ->{
                                        onListingScreen(ListingType.TRENDING)
                                    }
                                    1 ->{
                                        onListingScreen(ListingType.POPULAR)
                                    }
                                    2 ->{
                                        onListingScreen(ListingType.TOP_RATED)
                                    }
                                }
                        }
                )
            }
        }
    }
}