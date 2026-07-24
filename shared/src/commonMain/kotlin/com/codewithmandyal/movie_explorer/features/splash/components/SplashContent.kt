package com.codewithmandyal.movie_explorer.features.splash.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.codewithmandyal.movie_explorer.core.components.SpaceVertical
import com.codewithmandyal.movie_explorer.core.ui.defaults.SplashDefaults
import com.codewithmandyal.movie_explorer.core.ui.responsive.LocalAppDimens
import com.codewithmandyal.movie_explorer.core.ui.responsive.LocalWindowType
import kotlinx.coroutines.delay

@Composable
fun SplashContent(
    onSplashFinished: () -> Unit
) {

    val dimens = LocalAppDimens.current
    val windowType = LocalWindowType.current

    LaunchedEffect(Unit) {
        delay(3000)
        onSplashFinished()
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        AnimatedBackground()

        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (-24).dp), // Slightly higher for better visual balance
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                contentAlignment = Alignment.Center
            ) {

                AnimatedGlow()

                SplashLogo()
            }

            SpaceVertical(dimens.sectionSpacing)

            SplashTitle()
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .widthIn(max = SplashDefaults.loadingWidth(windowType))
                .fillMaxWidth()
                .padding(
                    horizontal = dimens.screenPadding,
                    vertical = dimens.sectionSpacing
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            LoadingBar()

            SpaceVertical(dimens.itemSpacing)

            LoadingText()
        }
    }
}