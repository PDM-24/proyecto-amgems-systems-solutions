package com.alvarado.backpack.navigate

import android.net.Uri

sealed class NavScreens(val route: String) {
    object HomeScreen : AppScreens("Home_Screen")
    object Contributions : NavScreens("contributions")
    object Favorites : NavScreens("favorites")
    object Profile : NavScreens("profile")
    object Reporting : NavScreens("reporting")
    object AddMaterial : NavScreens("add_material")
    object Material : NavScreens("material")
    object ViewMaterial : NavScreens("view_material/{postUrl}") {
        fun createRoute(postUrl: String): String {
            return "view_material/${Uri.encode(postUrl)}"
        }
    }
}