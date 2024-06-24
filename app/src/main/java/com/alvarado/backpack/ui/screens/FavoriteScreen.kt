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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

    val searchQuery = remember { mutableStateOf("") }

    val filteredPostList = postList.filter { post ->
        post.title.contains(searchQuery.value, ignoreCase = true) ||
                post.publicationCycle.contains(searchQuery.value, ignoreCase = true)
    }

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
                subTitle = "Your favorites documents",
                onSearch = { query -> searchQuery.value = query }
            )
            LazyColumn (
                modifier = Modifier
                    .weight(8f)
                    .padding(innerPadding)
            ) {
                items(filteredPostList) { post ->
                    PostComponent(navController, post, viewModel)
                }
            }
        }
    }
}

