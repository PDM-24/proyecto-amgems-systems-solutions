package com.alvarado.backpack.ui.components.navBar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.alvarado.backpack.R

@Composable
fun NavBarComponent(navController: NavController) {

    val currentRoute = navController.currentBackStackEntry?.destination?.route

    Box(
        modifier = Modifier
            .padding(vertical = 10.dp, horizontal = 15.dp)
            .shadow(8.dp, RoundedCornerShape(8.dp)),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            NavButton(
                currentRoute = currentRoute,
                route = "Home_Screen",
                navController = navController,
                iconId = R.drawable.ic_home
            )
            NavButton(
                currentRoute = currentRoute,
                route = "contributions",
                navController = navController,
                iconId = R.drawable.ic_contri
            )
            NavButton(
                currentRoute = currentRoute,
                route = "favorites",
                navController = navController,
                iconId = R.drawable.ic_fav
            )
            NavButton(
                currentRoute = currentRoute,
                route = "profile",
                navController = navController,
                iconId = R.drawable.ic_prof
            )
        }
    }
}

@Composable
fun NavButton(currentRoute: String?, route: String, navController: NavController, iconId: Int) {
    val isSelected = currentRoute == route
    Button(
        onClick = {
            if (currentRoute != route) {
                navController.navigate(route)
            }
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) Color(0xFF4C72F5) else Color.Transparent
        ),
        modifier = Modifier
            .width(70.dp)
            .height(70.dp)
            .background(
                color = if (isSelected) Color(0xFF4C72F5) else Color.Transparent,
                shape = RoundedCornerShape(25.dp)
            )
    ) {
        Image(
            painter = painterResource(id = iconId),
            contentDescription = null,
            modifier = Modifier
                .width(40.dp)
                .height(40.dp),
            colorFilter = if (isSelected) ColorFilter.tint(Color.White) else null
        )
    }
}
