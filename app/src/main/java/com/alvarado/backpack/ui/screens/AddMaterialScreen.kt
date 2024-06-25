package com.alvarado.backpack.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.alvarado.backpack.MainViewModel
import com.alvarado.backpack.ui.components.PostComponent
import com.alvarado.backpack.ui.components.SearchComponent
import com.alvarado.backpack.ui.components.addMaterial.AddMaterial
import com.alvarado.backpack.ui.components.navBar.NavBarComponent
import com.alvarado.backpack.ui.components.profile.ProfileInfoComponent

@Composable
fun AddMaterialScreen(
    navController: NavController,
    viewModel: MainViewModel
){

    val subjectList by viewModel.subjectList.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getSubjectByDegree()
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
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(vertical = 10.dp, horizontal = 15.dp)

        ) {
            LazyColumn (
                modifier = Modifier
                    .weight(9f)
                    .padding(innerPadding)
            ) {
                itemsIndexed(listOf(1)) { index, item ->
                    AddMaterial(viewModel)
                }
            }
        }

        }
    }
