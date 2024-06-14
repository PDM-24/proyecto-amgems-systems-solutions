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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alvarado.backpack.R

@Composable
fun PostComponent(navController: NavController) {
    val likeAPost = remember { mutableStateOf(false) }

    Surface (
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
            .height(125.dp),
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
                    text = "[CLASE] - Desarrollo de Integrales",
                    maxLines = 2,
                    fontSize = 16.sp
                )
                Text(
                    text = "Desarrollo de la clase donde vemos intregales y....",
                    maxLines = 3,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Fecha: 07/10/2023",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.width(30.dp))
                    Text(
                        text = "Ciclo: 01",
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
                        .clickable { likeAPost.value = !likeAPost.value }
                ) {
                    if (!likeAPost.value) {
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
                        .clickable { navController.navigate("reporting") }
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

