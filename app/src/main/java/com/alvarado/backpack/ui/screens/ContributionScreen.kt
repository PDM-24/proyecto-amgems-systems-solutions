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
import androidx.navigation.NavController
import com.alvarado.backpack.ui.components.PostComponent
import com.alvarado.backpack.ui.components.SearchComponent
import com.alvarado.backpack.ui.components.navBar.NavBarComponent

@Composable
fun ContributionScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(vertical = 10.dp, horizontal = 15.dp)
    ) {
        SearchComponent(
            modifier = Modifier
                .weight(3f),
            title="Contribution",
            subTitle = "what you were looking for"
        )

        LazyColumn (
            modifier = Modifier
                .weight(9f)
        ) {
            itemsIndexed(listOf(1, 2, 3, 4,5, 6, 7, 8, 9, 10)) { index, item ->
                PostComponent()
            }
        }
        NavBarComponent(navController)
    }
}

