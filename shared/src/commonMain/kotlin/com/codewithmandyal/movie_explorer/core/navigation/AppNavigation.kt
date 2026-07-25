package com.codewithmandyal.movie_explorer.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.codewithmandyal.movie_explorer.core.navigation.animation.fadeScaleIn
import com.codewithmandyal.movie_explorer.core.navigation.animation.fadeScaleOut
import com.codewithmandyal.movie_explorer.core.navigation.animation.popFadeScaleIn
import com.codewithmandyal.movie_explorer.core.navigation.animation.popFadeScaleOut
import com.codewithmandyal.movie_explorer.core.utils.ListingType
import com.codewithmandyal.movie_explorer.core.utils.MediaType
import com.codewithmandyal.movie_explorer.features.details.DetailsScreen
import com.codewithmandyal.movie_explorer.features.home.HomeScreen
import com.codewithmandyal.movie_explorer.features.imageGallery.ImageGallery
import com.codewithmandyal.movie_explorer.features.listingScreen.ListingScreen
import com.codewithmandyal.movie_explorer.features.splash.SplashScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = SplashRoute
    ) {

        composable<SplashRoute> {
            SplashScreen(
                onSplashFinished = {
                    navController.navigate(HomeRoute) {
                        popUpTo<SplashRoute> {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<HomeRoute> {
            HomeScreen(
                onDetailsScreen = { movieId, mediaType ->
                    navController.navigate(
                        DetailsRoute(movieId, mediaType.name)
                    )
                },
                onListingScreen = {
                    navController.navigate(
                        ListingRoute( it.name)
                    )
                }
            )
        }

        composable<DetailsRoute>(
            enterTransition = fadeScaleIn,
            exitTransition = fadeScaleOut,
            popEnterTransition = popFadeScaleIn,
            popExitTransition = popFadeScaleOut
        ) { backStackEntry ->



            val route = backStackEntry.toRoute<DetailsRoute>()

            val mediaType = MediaType.valueOf(route.mediaType)

            DetailsScreen(
                movieId = route.movieId,
                mediaType = mediaType,
                onBackPress = {
                    navController.popBackStack()
                },
                viewAllImages = { movieId, mediaType ->
                    navController.navigate(
                        GalleryRoute(movieId, mediaType.name)
                    )
                },
                onViewDetails = { movieId, mediaType ->
                    navController.navigate(
                        DetailsRoute(movieId, mediaType.name)
                    )
                }
            )
        }

        composable<ListingRoute>(
            enterTransition = fadeScaleIn,
            exitTransition = fadeScaleOut,
            popEnterTransition = popFadeScaleIn,
            popExitTransition = popFadeScaleOut
        ) { backStackEntry ->
            val route = backStackEntry.toRoute<ListingRoute>()

            val listingType = ListingType.valueOf(route.listingType)

            ListingScreen(
                listingType,
                onBackPress = {
                    navController.popBackStack()
                },
                onDetailsScreen = { id, mediaType ->
                    navController.navigate(
                        DetailsRoute(id, mediaType.name)
                    )
                }
            )
        }

        composable<GalleryRoute>(
            enterTransition = fadeScaleIn,
            exitTransition = fadeScaleOut,
            popEnterTransition = popFadeScaleIn,
            popExitTransition = popFadeScaleOut
        ) { backStackEntry ->

            val route = backStackEntry.toRoute<GalleryRoute>()

            val mediaType = MediaType.valueOf(route.mediaType)

            ImageGallery(
                onBackPress = {
                    navController.popBackStack()
                },
                route.movieId,
                mediaType
            )
        }
    }
}