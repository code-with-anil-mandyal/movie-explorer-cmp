package com.codewithmandyal.movie_explorer.features.details.tv.components.tvBanner

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.codewithmandyal.movie_explorer.core.components.SpaceVertical
import com.codewithmandyal.movie_explorer.core.components.SpacerHorizontal
import com.codewithmandyal.movie_explorer.core.ui.defaults.tv.TvBannerDefaults
import com.codewithmandyal.movie_explorer.core.ui.responsive.tv.LocalTvDimens
import com.codewithmandyal.movie_explorer.core.ui.responsive.tv.LocalTvWindowType

@Composable
fun TvBannerActions(
    watchRequester: FocusRequester,
    watchListRequester: FocusRequester,
    upRequester: FocusRequester,
    downRequester: FocusRequester,
    onWatchNow: () -> Unit = {},
    onWatchList: () -> Unit = {}
){
    val dimens = LocalTvDimens.current
    val windowType = LocalTvWindowType.current

    var watchFocused by remember {
        mutableStateOf(false)
    }

    var watchListFocused by remember {
        mutableStateOf(false)
    }

    val watchScale by animateFloatAsState(
        targetValue = if (watchFocused) 1.05f else 1f,
        animationSpec = tween(150),
        label = "WatchScale"
    )

    val watchListScale by animateFloatAsState(
        targetValue = if (watchListFocused) 1.05f else 1f,
        animationSpec = tween(150),
        label = "WatchListScale"
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .focusRequester(watchRequester)
                .focusProperties {
                    up = upRequester
                    down = watchListRequester
                }
                .onFocusChanged {
                    watchFocused = it.isFocused
                }
                .focusable()
                .clickable {
                    onWatchNow()
                }
                .fillMaxWidth()
                .height(
                    TvBannerDefaults.detailsButtonHeight(windowType)
                )
                .graphicsLayer {
                    scaleX = watchScale
                    scaleY = watchScale
                }
                .background(
                    Color.Red,
                    RoundedCornerShape(dimens.cornerSmall)
                ),
            contentAlignment = Alignment.Center
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = null,
                    tint = Color.White
                )

                SpacerHorizontal(dimens.itemSpacing)

                Text(
                    text = "Watch Now",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = dimens.bodyFont,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                )
            }
        }

        SpaceVertical(dimens.itemSpacing)

        Box(
            modifier = Modifier
                .focusRequester(watchListRequester)
                .focusProperties {
                    up = watchRequester
                    down = downRequester
                }
                .onFocusChanged {
                    watchListFocused = it.isFocused
                }
                .focusable()
                .clickable {
                    onWatchList()
                }
                .fillMaxWidth()
                .height(
                    TvBannerDefaults.detailsButtonHeight(windowType)
                )
                .graphicsLayer {
                    scaleX = watchListScale
                    scaleY = watchListScale
                }
                .background(
                    Color.DarkGray,
                    RoundedCornerShape(dimens.cornerSmall)
                )
                .border(
                    BorderStroke(
                        0.5.dp,
                        Color.LightGray
                    ),
                    RoundedCornerShape(dimens.cornerSmall)
                ),
            contentAlignment = Alignment.Center
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Outlined.Bookmark,
                    contentDescription = null,
                    tint = Color.White
                )

                SpacerHorizontal(dimens.itemSpacing)

                Text(
                    text = "Add To Watchlist",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = dimens.bodyFont,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                )
            }
        }
    }
}