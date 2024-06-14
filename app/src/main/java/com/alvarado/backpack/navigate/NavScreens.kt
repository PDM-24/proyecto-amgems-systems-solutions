package com.alvarado.backpack.navigate

sealed class NavScreens(val route: String) {
    object HomeScreen : AppScreens("Home_Screen")
    object Contributions : NavScreens("contributions")
    object Favorites : NavScreens("favorites")
    object Profile : NavScreens("profile")
    object Reporting : NavScreens("reporting")
    object AddMaterial : NavScreens("add_material")
}