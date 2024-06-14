package com.alvarado.backpack.ui.components.navBar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.alvarado.backpack.R

@Composable
fun NavBarComponent(navController: NavController){
        Box(
            modifier = Modifier
                .shadow(8.dp, RoundedCornerShape(8.dp))

        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(25.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Button(
                    onClick = {
                        navController.navigate("Home_Screen")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_home),
                        contentDescription = "Back",
                        modifier = Modifier
                            .width(25.dp)
                            .height(25.dp),
                    )
                }

                Button(
                    onClick = {
                        navController.navigate("contributions")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_contri),
                        contentDescription = "Back",
                        modifier = Modifier
                            .width(25.dp)
                            .height(25.dp),
                    )
                }

                Button(
                    onClick = {
                        navController.navigate("favorites")

                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_fav),
                        contentDescription = "Back",
                        modifier = Modifier
                            .width(25.dp)
                            .height(25.dp),
                    )
                }

                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_prof),
                        contentDescription = "Back",
                        modifier = Modifier
                            .width(25.dp)
                            .height(25.dp),
                    )
                }
            }
        }
}

