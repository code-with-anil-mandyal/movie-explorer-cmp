package com.codewithmandyal.movie_explorer.core.navigation.animation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.navigation.NavBackStackEntry

val fadeScaleIn: AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition = {
    fadeIn(
        animationSpec = tween(300)
    ) + scaleIn(
        initialScale = 0.95f,
        animationSpec = tween(300)
    )
}

val fadeScaleOut: AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition = {
    fadeOut(
        animationSpec = tween(300)
    ) + scaleOut(
        targetScale = 0.95f,
        animationSpec = tween(300)
    )
}

val popFadeScaleIn: AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition = {
    fadeIn(
        animationSpec = tween(300)
    ) + scaleIn(
        initialScale = 0.95f,
        animationSpec = tween(300)
    )
}

val popFadeScaleOut: AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition = {
    fadeOut(
        animationSpec = tween(300)
    ) + scaleOut(
        targetScale = 0.95f,
        animationSpec = tween(300)
    )
}