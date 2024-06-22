package com.alvarado.backpack.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alvarado.backpack.R
import com.alvarado.backpack.navigate.AppScreens

@Composable
fun ViewMaterialScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .background(Color(0xFFF2F2F2)),
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(painter = painterResource(id = R.drawable.img_bubble_blue_top), contentDescription = "Bubble blue")

                Box(modifier = Modifier.padding(start = 0.dp, end = 30.dp)){
                    Button(
                        colors = ButtonDefaults.buttonColors(Color.White),
                        modifier = Modifier
                            .width(70.dp)
                            .height(70.dp),
                        shape = CircleShape,
                        onClick = {
                            navController.popBackStack()
                        }) {
                        Image(painter = painterResource(id = R.drawable.ic_arrow_back), contentDescription = "Back", modifier = Modifier.fillMaxSize())
                    }
                }
            }
        }
        
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                
                }
            ) {
                Text(text = "Descargar")
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.End
        ) {
            Image(painter = painterResource(id = R.drawable.img_bubble_blue_bottom), contentDescription = "Bubble blue")
        }
    }
}