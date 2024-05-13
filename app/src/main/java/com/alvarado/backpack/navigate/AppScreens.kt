package com.alvarado.backpack.navigate

sealed class AppScreens(val route : String) {
    object LoginScreen : AppScreens("Login_Screen")
    object RegisterScreen : AppScreens("Register_Screen")
    object WelcomeScreen : AppScreens("Welcome_Screen")

    object RememberScreen : AppScreens("Remember_Screen")
}