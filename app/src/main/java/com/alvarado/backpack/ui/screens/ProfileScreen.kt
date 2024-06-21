package com.alvarado.backpack.ui.screens



import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.alvarado.backpack.MainViewModel
import com.alvarado.backpack.ui.components.navBar.NavBarComponent
import com.alvarado.backpack.ui.components.profile.ProfileInfoComponent

@Composable
fun ProfileScreen(navController: NavController, viewModel: MainViewModel) {

    Scaffold(
        topBar = {

        },
        bottomBar = {
            BottomAppBar {
                NavBarComponent(navController)
            }
        }
    ) {  innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxHeight()
        ) {
            LazyColumn (
                modifier = Modifier
                    .weight(9f)
                    .padding(innerPadding)
            ) {
                itemsIndexed(listOf(1)) { index, item ->
                    ProfileInfoComponent(navController, viewModel)
                }
            }
        }
    }



}
