package com.alvarado.backpack.navigate

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alvarado.backpack.ui.screens.LoginScreen
import com.alvarado.backpack.ui.screens.RegisterScreen

@Composable
fun AppNavigation(modifier: Modifier = Modifier){
    val navController = rememberNavController()

    Box(
        modifier = modifier
    ) {
        NavHost(navController = navController, startDestination = AppScreens.LoginScreen.route) {
            composable(AppScreens.LoginScreen.route){
                LoginScreen(navController)
            }
            composable(AppScreens.RegisterScreen.route){
                RegisterScreen(navController)
            }
        }
    }
}