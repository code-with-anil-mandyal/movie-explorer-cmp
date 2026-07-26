package com.codewithmandyal.movie_explorer.features.home.defaults.components.topbar

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.codewithmandyal.movie_explorer.core.components.SpacerHorizontal
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.LocalAppDimens
import com.codewithmandyal.movie_explorer.core.utils.ListingType
import movieexplorer.shared.generated.resources.Res
import movieexplorer.shared.generated.resources.movie_explorer_logo
import org.jetbrains.compose.resources.painterResource

@Composable
fun MobileTopBar(
    elevated: Boolean,
    onListingScreen: (listingType: ListingType) -> Unit
) {

    val dimens = LocalAppDimens.current

    var expanded by remember { mutableStateOf(false) }

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

            Spacer(Modifier.weight(1f))

            IconButton(
                onClick = {
                    onListingScreen(ListingType.SEARCH)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = Color.White
                )
            }

            Box {

                IconButton(
                    onClick = {
                        expanded = true
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu",
                        tint = Color.White
                    )
                }

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = {
                        expanded = false
                    }
                ) {

                    DropdownMenuItem(
                        text = { Text("Trending") },
                        onClick = {
                            expanded = false
                            onListingScreen(ListingType.TRENDING)
                        }
                    )

                    DropdownMenuItem(
                        text = { Text("Popular") },
                        onClick = {
                            expanded = false
                            onListingScreen(ListingType.TRENDING)
                        }
                    )

                    DropdownMenuItem(
                        text = { Text("Top Rated") },
                        onClick = {
                            expanded = false
                            onListingScreen(ListingType.TRENDING)
                        }
                    )
                }
            }
        }
    }
}