package com.alvarado.backpack.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.alvarado.backpack.R
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
            subTitle = ""
        )

        LazyColumn (
            modifier = Modifier
                .weight(9f)
        ) {
            itemsIndexed(listOf(1, 2, 3, 4,5, 6, 7, 8, 9, 10)) { index, item ->
                PostComponent(navController)
            }
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.End
        ) {
            Button(
                onClick = {
                        navController.navigate("add_material")
                },
                colors = ButtonDefaults.buttonColors(Color.Transparent),
            ) {
                Image(painter = painterResource(id = R.drawable.ic_add_contri), contentDescription = "Add Contribution")
            }
        }

        Spacer(modifier = Modifier.padding(5.dp))

        NavBarComponent(navController)
    }
}

