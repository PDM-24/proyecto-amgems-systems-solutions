package com.alvarado.backpack.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.alvarado.backpack.MainViewModel
import com.alvarado.backpack.ui.components.PostComponent
import com.alvarado.backpack.ui.components.SearchComponent
import com.alvarado.backpack.ui.components.navBar.NavBarComponent

@Composable
fun FavoriteScreen(
    navController : NavController,
    viewModel : MainViewModel
) {

    LaunchedEffect(Unit) {
        viewModel.getSavedPosts()
    }

    val postList = viewModel.postListFavorite.collectAsState().value

    Scaffold(
        topBar = {

        },
        bottomBar = {
            BottomAppBar {
                NavBarComponent(navController)
            }
        }
    ) {  innerPadding ->
        Column (
            modifier = Modifier
                .fillMaxHeight()
                .padding(vertical = 10.dp, horizontal = 15.dp)
        ) {
            SearchComponent (
                modifier = Modifier
                    .weight(3f),
                title="Favorites",
                subTitle = "Your favorites documents"
            )
            LazyColumn (
                modifier = Modifier
                    .weight(8f)
                    .padding(innerPadding)
            ) {
                items(postList) { post ->
                    PostComponent(navController, post, viewModel)
                }
            }
        }
    }
}

