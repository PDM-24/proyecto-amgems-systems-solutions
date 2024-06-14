package com.alvarado.backpack.navigate

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alvarado.backpack.ui.screens.ContributionScreen
import com.alvarado.backpack.ui.screens.FavoriteScreen
import com.alvarado.backpack.ui.screens.HomeScreen

@Composable
fun NavBarNavigation(){
    val navController = rememberNavController()

    Box(

    ) {
        NavHost(navController = navController, startDestination = NavScreens.HomeScreen.route) {
            composable(
                route = NavScreens.HomeScreen.route,
                enterTransition = {
                    slideIntoContainer(
                        towards = AnimatedContentTransitionScope.SlideDirection.Start,
                        animationSpec = tween(500)
                    )
                },
                exitTransition = {
                    slideOutOfContainer(
                        towards = AnimatedContentTransitionScope.SlideDirection.End,
                        animationSpec = tween(500)
                    )
                }
            ) {
              HomeScreen(navController)
            }

            composable(
                route = NavScreens.Contributions.route,
                enterTransition = {
                    slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Start, animationSpec = tween(500))
                },
                exitTransition = {
                    slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.End, animationSpec = tween(500))
                }
            ){
                ContributionScreen(navController)
            }

            composable(
                route = NavScreens.Favorites.route,
                enterTransition = {
                    slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Start, animationSpec = tween(500))
                },
                exitTransition = {
                    slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.End, animationSpec = tween(500))
                }
            ){
                FavoriteScreen(navController)
            }

        }
    }
}
