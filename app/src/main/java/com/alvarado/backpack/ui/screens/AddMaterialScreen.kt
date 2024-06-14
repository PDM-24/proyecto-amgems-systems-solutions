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
import com.alvarado.backpack.ui.components.addMaterial.AddMaterial
import com.alvarado.backpack.ui.components.navBar.NavBarComponent
import com.alvarado.backpack.ui.components.profile.ProfileInfoComponent

@Composable
fun AddMaterialScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(vertical = 10.dp, horizontal = 15.dp)

    ) {
        LazyColumn (
            modifier = Modifier
                .weight(9f)
        ) {
            itemsIndexed(listOf(1)) { index, item ->
                AddMaterial()
            }
        }

        NavBarComponent(navController = navController)

    }
}