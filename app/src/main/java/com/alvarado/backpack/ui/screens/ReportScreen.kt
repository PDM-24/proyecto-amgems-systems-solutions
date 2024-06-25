package com.alvarado.backpack.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alvarado.backpack.MainViewModel
import com.alvarado.backpack.UiState
import com.alvarado.backpack.ui.components.navBar.NavBarComponent
import com.alvarado.backpack.ui.components.report.ReportInfo
import com.alvarado.backpack.ui.components.report.ReportReasons
import kotlinx.coroutines.launch

@Composable
fun ReportScreen(navController: NavController, viewModel: MainViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(uiState) {
        when (uiState) {
            is UiState.Success -> {
                coroutineScope.launch {
                    viewModel.resetUiState()
                    snackbarHostState.showSnackbar("Report sent successfully")
                }
            }
            is UiState.Error -> {
                coroutineScope.launch {
                    snackbarHostState.showSnackbar("Failed to send report")
                    viewModel.resetUiState()
                }
            }
            else -> {

            }
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        bottomBar = {
            BottomAppBar {
                NavBarComponent(navController)
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 10.dp, horizontal = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(
                modifier = Modifier
                    .weight(9f)
                    .padding(innerPadding)
            ) {
                itemsIndexed(listOf(1)) { index, item ->
                    ReportInfo(
                        modifier = Modifier.weight(0.5f),
                    )

                    ReportReasons(modifier = Modifier.weight(0.5f), viewModel = viewModel)
                }
            }
        }
    }
}
