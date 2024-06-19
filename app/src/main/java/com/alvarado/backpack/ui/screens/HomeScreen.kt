package com.alvarado.backpack.ui.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.alvarado.backpack.R
import com.alvarado.backpack.ui.components.CourseCard
import com.alvarado.backpack.ui.components.PostComponent
import com.alvarado.backpack.ui.components.SearchComponent
import com.alvarado.backpack.ui.components.navBar.NavBarComponent

@Composable
fun HomeScreen(navController: NavController){

    val image: Painter = painterResource(id = R.drawable.movil)

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
                .padding(vertical = 10.dp, horizontal = 15.dp)
        ) {
            SearchComponent(
                modifier = Modifier
                    .weight(3f),
                title="Hello",
                subTitle = "We are going to learn"
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(8.dp),
                modifier = Modifier
                    .weight(9f)
                    .padding(innerPadding)
            ) {
                itemsIndexed(listOf(1,2,3,4,6,7,8)) { index, item ->
                    CourseCard(
                        image = image,
                        title = "PDM",
                        subtitle = "2 courses",
                        navController = navController
                    )
                }
            }

        }
    }
}