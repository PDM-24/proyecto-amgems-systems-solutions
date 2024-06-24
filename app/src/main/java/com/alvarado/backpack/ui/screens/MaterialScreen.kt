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
import androidx.compose.runtime.getValue
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
fun MaterialScreen(
    navController: NavController,
    viewModel: MainViewModel
) {

    val subjectId = viewModel.getSubjectSelected()
    val postList by viewModel.postListByDegree.collectAsState()
    val user = viewModel.user.collectAsState().value
    val searchQuery = remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        viewModel.whoami()
        viewModel.getPostBySubject(subjectId)
    }

    val filteredPostList = postList.filter { post ->
        post.title.contains(searchQuery.value, ignoreCase = true) ||
                post.category.contains(searchQuery.value, ignoreCase = true)
    }

    Scaffold(
        bottomBar = {
            BottomAppBar {
                NavBarComponent(navController)
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
                title = "Programación de dispositivos móviles",
                subTitle = "Ciclo 01 - 2024",
                onSearch = { query -> searchQuery.value = query }
            )

            LazyColumn(
                modifier = Modifier
                    .weight(8f)
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

