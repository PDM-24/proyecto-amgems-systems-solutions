package com.alvarado.backpack.ui.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.alvarado.backpack.ui.components.PostComponent
import com.alvarado.backpack.ui.components.navBar.NavBarComponent
import com.alvarado.backpack.ui.components.profile.ProfileInfoComponent

@Composable
fun ProfileScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxHeight()
    ) {
        LazyColumn (
            modifier = Modifier
                .weight(9f)
        ) {
            itemsIndexed(listOf(1)) { index, item ->
                ProfileInfoComponent()
            }
        }

        NavBarComponent(navController = navController)

    }

}
