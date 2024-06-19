package com.alvarado.backpack.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.alvarado.backpack.ui.components.PostComponent
import com.alvarado.backpack.ui.components.SearchComponent
import com.alvarado.backpack.ui.components.navBar.NavBarComponent
import com.alvarado.backpack.ui.components.report.ReportInfo
import com.alvarado.backpack.ui.components.report.ReportReasons

@Composable
fun ReportScreen(navController: NavController) {
    // report variables
    val cycleInfo: MutableState<String> = remember { mutableStateOf("") }
    val dateInfo: MutableState<String> = remember { mutableStateOf("") }
    val titleInfo: MutableState<String> = remember { mutableStateOf("") }

    Scaffold(
        bottomBar = {
            BottomAppBar {
                NavBarComponent(navController)
            }
        }
    ) {  innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 10.dp, horizontal = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            LazyColumn (
                modifier = Modifier
                    .weight(9f)
                    .padding(innerPadding)
            ) {
                itemsIndexed(listOf(1)) { index, item ->
                    ReportInfo(
                        modifier = Modifier.weight(0.5f),
                        documentCycle = cycleInfo.value,
                        documentDate = dateInfo.value,
                        documentTitle = titleInfo.value
                    )

                    // list
                    ReportReasons(modifier = Modifier.weight(0.5f))
                }
            }
        }
    }


}
