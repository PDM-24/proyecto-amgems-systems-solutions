package com.alvarado.backpack.navigate

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alvarado.backpack.ui.screens.LoginScreen
import com.alvarado.backpack.ui.screens.RegisterScreen
import com.alvarado.backpack.ui.screens.RememberScreen
import com.alvarado.backpack.ui.screens.WelcomeScreen

@Composable
fun AppNavigation(modifier: Modifier = Modifier){
    val navController = rememberNavController()

    Box(
        modifier = modifier
    ) {
        NavHost(navController = navController, startDestination = AppScreens.WelcomeScreen.route) {
            composable(
                route = AppScreens.WelcomeScreen.route,
                enterTransition = {
                    slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Start, animationSpec = tween(500))
                },
                exitTransition = {
                    slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.End, animationSpec = tween(500))
                }
            ){
                WelcomeScreen(navController)
            }

            composable(
                route = AppScreens.RememberScreen.route,
                enterTransition = {
                    slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Start, animationSpec = tween(500))
                },
                exitTransition = {
                    slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.End, animationSpec = tween(500))
                }
            ){
                RememberScreen(navController)
            }
            composable(
                route = AppScreens.LoginScreen.route,
                enterTransition = {
                    slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Start, animationSpec = tween(500))
                },
                exitTransition = {
                    slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.End, animationSpec = tween(500))
                }
            ){
                LoginScreen(navController)
            }
            composable(
                route = AppScreens.RegisterScreen.route,
                enterTransition = {
                    slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Start, animationSpec = tween(500))
                },
                exitTransition = {
                    slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.End, animationSpec = tween(500))
                }
                ){
                RegisterScreen(navController)
            }
        }
    }
}