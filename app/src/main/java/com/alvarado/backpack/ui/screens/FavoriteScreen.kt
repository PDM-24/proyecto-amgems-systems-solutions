package com.alvarado.backpack.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alvarado.backpack.ui.components.PostComponent
import com.alvarado.backpack.ui.components.SearchComponent

@Composable
fun FavoriteScreen() {
    Column (
        modifier = Modifier
            .fillMaxHeight()
            .padding(vertical = 10.dp, horizontal = 15.dp)
    ) {
        SearchComponent (
            modifier = Modifier
                .weight(3f),
            title="Favorites"
        )
        LazyColumn (
            modifier = Modifier
                .weight(8f)
        ) {
            itemsIndexed(listOf(1, 2, 3, 4,)) { index, item ->
                PostComponent()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun FavoriteScreenPreview() {
    FavoriteScreen()
}