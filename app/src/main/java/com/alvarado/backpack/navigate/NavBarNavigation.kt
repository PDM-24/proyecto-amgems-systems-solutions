package com.alvarado.backpack.navigate

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alvarado.backpack.MainViewModel
import com.alvarado.backpack.ui.screens.AddMaterialScreen
import com.alvarado.backpack.ui.screens.ContributionScreen
import com.alvarado.backpack.ui.screens.FavoriteScreen
import com.alvarado.backpack.ui.screens.HomeScreen
import com.alvarado.backpack.ui.screens.LoginScreen
import com.alvarado.backpack.ui.screens.MaterialScreen
import com.alvarado.backpack.ui.screens.ProfileScreen
import com.alvarado.backpack.ui.screens.RegisterScreen
import com.alvarado.backpack.ui.screens.RememberScreen
import com.alvarado.backpack.ui.screens.ReportScreen
import com.alvarado.backpack.ui.screens.ViewMaterialScreen

@Composable
fun NavBarNavigation(){
    val navController = rememberNavController()
    val viewModel : MainViewModel = hiltViewModel()

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

            composable(
                route = NavScreens.Profile.route,
                enterTransition = {
                    slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Start, animationSpec = tween(500))
                },
                exitTransition = {
                    slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.End, animationSpec = tween(500))
                }
            ){
                ProfileScreen(navController)
            }

            composable(
                route = NavScreens.Reporting.route,
                enterTransition = {
                    slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Start, animationSpec = tween(500))
                },
                exitTransition = {
                    slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.End, animationSpec = tween(500))
                }
            ){
                ReportScreen(navController)
            }

            composable(
                route = NavScreens.AddMaterial.route,
                enterTransition = {
                    slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Start, animationSpec = tween(500))
                },
                exitTransition = {
                    slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.End, animationSpec = tween(500))
                }
            ){
                AddMaterialScreen(navController)
            }

            composable(
                route = NavScreens.Material.route,
                enterTransition = {
                    slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Start, animationSpec = tween(500))
                },
                exitTransition = {
                    slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.End, animationSpec = tween(500))
                }
            ){
                MaterialScreen(navController)
            }

            composable(
                route = NavScreens.ViewMaterial.route,
                enterTransition = {
                    slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Start, animationSpec = tween(500))
                },
                exitTransition = {
                    slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.End, animationSpec = tween(500))
                }
            ){
                ViewMaterialScreen(navController)
            }

            composable(
                route = AppScreens.LoginScreen.route,
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
                LoginScreen(navController, viewModel)
            }

            composable(
                route = AppScreens.RegisterScreen.route,
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
                RegisterScreen(navController, viewModel)
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

        }
    }
}
