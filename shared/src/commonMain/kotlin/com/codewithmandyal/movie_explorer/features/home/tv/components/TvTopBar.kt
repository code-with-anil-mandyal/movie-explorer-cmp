package com.codewithmandyal.movie_explorer.features.home.tv.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.codewithmandyal.movie_explorer.core.components.SpacerHorizontal
import com.codewithmandyal.movie_explorer.core.ui.responsive.tv.LocalTvDimens
import movieexplorer.shared.generated.resources.Res
import movieexplorer.shared.generated.resources.movie_explorer_logo
import org.jetbrains.compose.resources.painterResource

@Composable
fun TvTopBar(
    focusRequester : FocusRequester,
    downRequester : FocusRequester,
    onHomeClick: () -> Unit = {},
    onSearchClick: () -> Unit,
    onSettingsClick: () -> Unit = {},
    onInitialFocusRequested: () -> Unit,
    requestInitialFocus: Boolean
) {

    val dimens = LocalTvDimens.current

   // val logoRequester = remember { FocusRequester() }
    val searchRequester = remember { FocusRequester() }
    val settingsRequester = remember { FocusRequester() }

    var logoFocused by remember { mutableStateOf(false) }

//    LaunchedEffect(Unit) {
//        focusRequester.requestFocus()
//    }

    LaunchedEffect(requestInitialFocus) {
        if (requestInitialFocus) {
            focusRequester.requestFocus()
            onInitialFocusRequested()
        }
    }

    val logoScale by animateFloatAsState(
        targetValue = if (logoFocused) 1.08f else 1f,
        label = "LogoScale"
    )

    val logoTextColor by animateColorAsState(
        targetValue = if (logoFocused) {
            Color.Red
        } else {
            Color.White
        },
        label = "LogoTextColor"
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(dimens.topBarHeight)
            .padding(horizontal = dimens.horizontalPadding),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            modifier = Modifier
                .graphicsLayer {
                    scaleX = logoScale
                    scaleY = logoScale
                }
                .focusRequester(focusRequester)
                .focusProperties {
                    right = searchRequester
                    down = downRequester
                }
                .onFocusChanged {
                    logoFocused = it.isFocused
                }
                .focusable()
                .clickable(onClick = onHomeClick)
                .padding(vertical = dimens.itemSpacing / 2),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(Res.drawable.movie_explorer_logo),
                contentDescription = "Movie Explorer",
                modifier = Modifier.size(dimens.logoSize)
            )

            SpacerHorizontal(dimens.itemSpacing)

            Text(
                text = "MovieExplorer",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = dimens.sectionTitleFont
                ),
                color = logoTextColor
            )
        }

        Spacer(Modifier.weight(1f))

        TvTopBarButton(
            text = "Search",
            icon = Icons.Default.Search,
            modifier = Modifier
                .focusRequester(searchRequester)
                .focusProperties {
                    left = focusRequester
                    right = settingsRequester
                    down = downRequester
                },
            onClick = onSearchClick
        )

        SpacerHorizontal(dimens.buttonSpacing)

        TvTopBarButton(
            text = "Settings",
            icon = Icons.Default.Settings,
            modifier = Modifier
                .focusRequester(settingsRequester)
                .focusProperties {
                    left = searchRequester
                    down = downRequester
                },
            onClick = onSettingsClick
        )
    }
}