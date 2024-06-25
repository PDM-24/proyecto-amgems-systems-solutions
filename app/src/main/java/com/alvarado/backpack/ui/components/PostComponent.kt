package com.alvarado.backpack.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alvarado.backpack.MainViewModel
import com.alvarado.backpack.R
import com.alvarado.backpack.domain.model.PostModel
import com.alvarado.backpack.navigate.NavScreens
import kotlinx.coroutines.launch

@Composable
fun PostComponent(
    navController: NavController,
    post: PostModel,
    viewModel : MainViewModel,
    isFavorite : Boolean = true
) {
    val coroutineScope = rememberCoroutineScope()
    val likeAPostValue = remember { mutableStateOf(isFavorite) }

    Surface (
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
            .height(125.dp)
            .clickable {
                navController.navigate(NavScreens.ViewMaterial.createRoute(post.url))
            },
        shadowElevation = 4.dp,
        shape = RoundedCornerShape(8.dp),
        color = Color.White
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column (
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(3f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image (
                    painter = painterResource(id = R.drawable.ic_pdf),
                    contentDescription = "Like count"
                )
            }
            Column (
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(horizontal = 4.dp)
                    .weight(11f)
                    .padding(end = 4.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text (
                    text = "[${post.category}] - ${post.title}",
                    maxLines = 2,
                    fontSize = 16.sp
                )
                Text(
                    text = "Documento PDF",
                    maxLines = 3,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Año: ${post.publicationYear}",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Ciclo: 0${post.publicationCycle}",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }
            }
            Column (
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box (
                    modifier = Modifier
                        .clickable {
                            likeAPostValue.value = !likeAPostValue.value
                            coroutineScope.launch{
                                viewModel.favoritePost(post.id)
                            }
                        }
                ) {
                    if (!likeAPostValue.value) {
                        Image (
                            painter = painterResource(id = R.drawable.ic_heart_gray),
                            contentDescription = "Like count"
                        )
                    } else {
                        Image (
                            painter = painterResource(id = R.drawable.ic_heart_red),
                            contentDescription = "Like count"
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .clickable {
                            navController.navigate("reporting")
                            viewModel.setPostSelected(post.id)
                        }
                ){

                    Image (
                        painter = painterResource(id = R.drawable.ic_denuncia_alert),
                        contentDescription = "Denuncia alert"
                    )
                }
            }
        }
    }
}

