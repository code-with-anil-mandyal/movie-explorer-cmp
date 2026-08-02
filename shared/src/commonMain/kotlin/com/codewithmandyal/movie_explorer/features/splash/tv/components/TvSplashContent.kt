package com.codewithmandyal.movie_explorer.features.splash.tv.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.unit.dp
import com.codewithmandyal.movie_explorer.core.components.SpaceVertical
import com.codewithmandyal.movie_explorer.core.ui.defaults.tv.TvSplashDefaults
import com.codewithmandyal.movie_explorer.core.ui.responsive.tv.LocalTvDimens
import com.codewithmandyal.movie_explorer.core.ui.responsive.tv.LocalTvWindowType
import com.codewithmandyal.movie_explorer.features.splash.common.LoadingBar
import kotlinx.coroutines.delay

@Composable
fun TvSplashContent(
    onSplashFinished: () -> Unit
){
    val dimens = LocalTvDimens.current
    val windowType = LocalTvWindowType.current



    LaunchedEffect(Unit) {
        delay(3000)
        onSplashFinished()
    }

//    Box(
//        modifier = Modifier.fillMaxSize()
//    ) {
//
//        TvAnimatedBackground()
//
//        Column(
//            modifier = Modifier
//                .align(Alignment.Center)
//                .offset(y = (-24).dp), // Slightly higher for better visual balance
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//
//            Box(
//                contentAlignment = Alignment.Center
//            ) {
//
//                TvAnimatedGlow()
//
//                TvSplashLogo()
//            }
//
//            SpaceVertical(dimens.sectionSpacing)
//
//            TvSplashTitle()
//        }
//
//        Column(
//            modifier = Modifier
//                .align(Alignment.BottomCenter)
//                .widthIn(max = TvSplashDefaults.loadingWidth(windowType))
//                .fillMaxWidth()
//                .padding(
//                    horizontal = dimens.screenPadding,
//                    vertical = dimens.sectionSpacing
//                ),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//
//            LoadingBar()
//
//            SpaceVertical(dimens.itemSpacing)
//
//            TvLoadingText()
//        }
//    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        TvAnimatedBackground()

        Column(
            modifier = Modifier
                .align(Alignment.Center),
                //.offset(y = (-24).dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(contentAlignment = Alignment.Center) {
                TvAnimatedGlow()
                TvSplashLogo(

                )
            }

            SpaceVertical(dimens.itemSpacing)

            TvSplashTitle(
                modifier = Modifier.offset(y = (-35).dp)
            )

            SpaceVertical(dimens.itemSpacing)

            LoadingBar(
                modifier = Modifier.width(
                    TvSplashDefaults.loadingWidth(windowType)
                )
            )

            //SpaceVertical(dimens.itemSpacing)

           // TvLoadingText()
        }
    }
}