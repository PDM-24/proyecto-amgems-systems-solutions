package com.alvarado.backpack.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alvarado.backpack.MainViewModel
import com.alvarado.backpack.ui.components.PostComponent
import com.alvarado.backpack.ui.components.SearchComponent
import com.alvarado.backpack.ui.components.navBar.NavBarComponent
import kotlinx.coroutines.launch


@Composable
fun ContributionScreen(
    navController: NavController,
    viewModel: MainViewModel
) {
    val postList = viewModel.postListAll.collectAsState().value
    val user = viewModel.user.collectAsState().value

    val searchQuery = remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        viewModel.getAllPosts()
        viewModel.whoami()
    }

    val filteredPostList = postList.filter { post ->
        post.title.contains(searchQuery.value, ignoreCase = true)
    }

    Scaffold(
        topBar = {},
        bottomBar = {
            BottomAppBar {
                NavBarComponent(navController)
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("add_material")
                }
            ) {
                Icon(Icons.Default.AddCircle, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(vertical = 10.dp, horizontal = 15.dp)
        ) {
            SearchComponent(
                modifier = Modifier
                    .weight(3f),
                title = "Contributions",
                subTitle = "What you were looking for",
                onSearch = { query -> searchQuery.value = query }
            )

            LazyColumn(
                modifier = Modifier
                    .weight(9f)
                    .padding(innerPadding)
            ) {
                items(filteredPostList) { post ->
                    if (user.savedPosts.contains(post.id)) {
                        PostComponent(navController, post, viewModel, true)
                    } else {
                        PostComponent(navController, post, viewModel, false)
                    }
                }
            }
        }
    }
}
