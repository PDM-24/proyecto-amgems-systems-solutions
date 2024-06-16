package com.alvarado.backpack.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alvarado.backpack.ui.components.PostComponent
import com.alvarado.backpack.ui.components.SearchComponent
import com.alvarado.backpack.ui.components.navBar.NavBarComponent

@Composable
fun MaterialScreen(navController: NavController) {
    Column (
        modifier = Modifier
            .fillMaxHeight()
            .padding(vertical = 10.dp, horizontal = 15.dp)
    ) {
        SearchComponent (
            modifier = Modifier
                .weight(3f),
            title="Programación de dispositivos móviles",
            subTitle = ""
        )
        LazyColumn (
            modifier = Modifier
                .weight(8f)
        ) {
            itemsIndexed(listOf(1, 2, 3, 4,)) { index, item ->
                PostComponent(navController = navController)
            }
        }
        
        NavBarComponent(navController = navController)
    }
}