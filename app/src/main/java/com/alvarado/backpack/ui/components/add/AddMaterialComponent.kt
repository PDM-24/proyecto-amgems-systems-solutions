package com.alvarado.backpack.ui.components.add

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alvarado.backpack.R
import kotlin.math.round

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddMaterial() {

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .background(Color(0xFFF2F2F2)),
    ) {
        Spacer(modifier = Modifier.height(12.dp))

        Column(
            modifier = Modifier
                .padding(10.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(Color(0xFF4C72F5))
                .padding(22.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 18.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Ready to share?",
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    fontSize = 28.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.ic_addcircle),
                    contentDescription = "Add icon",
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.CenterVertically)
                )
            }
            Text(
                text = "Teach the world your knowledge",
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.poppins_light)),
                fontSize = 16.sp
            )
        }

        Column(
            modifier = Modifier
                .padding(16.dp)
                .clip(RoundedCornerShape(34.dp))
                .background(Color.White)
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(15.dp))
            TextField(
                value = TextFieldValue(""),
                onValueChange = {},
                label = { Text("Title for the material") },
                leadingIcon = {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .background(Color.Black, shape = RoundedCornerShape(10.dp))
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_text),
                            contentDescription = "Title icon",
                            tint = Color.White,
                            modifier = Modifier
                                .size(24.dp)
                                .align(Alignment.Center)
                        )
                    }
                },
                // color (focused - unfocused)
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White, unfocusedContainerColor = Color.White
                ),
                // la sombra
                modifier = Modifier
                    .shadow(10.dp)
                    .height(44.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            Spacer(modifier = Modifier.height(15.dp))

            TextField(
                value = TextFieldValue(""),
                onValueChange = {},
                label = { Text("Material date")},
                leadingIcon = {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .background(Color.Black, shape = RoundedCornerShape(10.dp))
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_date),
                            contentDescription = "date icon",
                            tint = Color.White,
                            modifier = Modifier
                                .size(24.dp)
                                .align(Alignment.Center)
                        )
                    }
                },
                // color (focused - unfocused)
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White, unfocusedContainerColor = Color.White
                ),
                // la sombra
                modifier = Modifier
                    .shadow(tat0.dp)
                    .height(48.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            Spacer(modifier = Modifier.height(15.dp))
            TextField(
                value = TextFieldValue(""),
                onValueChange = {},
                label = { Text("Material cycle") },
                leadingIcon = {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .background(Color.Black, shape = RoundedCornerShape(10.dp))
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_cycle),
                            contentDescription = "cycle icon",
                            tint = Color.White,
                            modifier = Modifier
                                .size(24.dp)
                                .align(Alignment.Center)
                        )
                    }
                },
                // color (focused - unfocused)
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White, unfocusedContainerColor = Color.White
                ),
                // la sombra
                modifier = Modifier
                    .shadow(10.dp)
                    .height(48.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            Spacer(modifier = Modifier.height(15.dp))
            // description
            Box() {
                Column {
                    Card(
                        colors = CardDefaults.cardColors(containerColor = Color.Black),
                        modifier = Modifier.width(280.dp)
                    ) {
                        Row (
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Box(
                                modifier = Modifier
                                    .size(48.dp)
                                    .fillMaxWidth()
                                    .padding(5.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_description),
                                    contentDescription = "Description icon",
                                    tint = Color.White,
                                    modifier = Modifier
                                        .size(24.dp)
                                        .align(Alignment.Center)
                                )
                            }

                            Text(
                                text = "   Description",
                                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                                color = Color.White
                            )
                        }
                    }
                    TextField(
                        value = TextFieldValue(""),
                        onValueChange = {},
                        label = { Text("Add a description to the material...") },
                        modifier = Modifier.size(width = 280.dp, height = 120.dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White, unfocusedContainerColor = Color.White
                        )

                    )
                }
            }

            Spacer(modifier = Modifier.height(4.dp))

            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_cloud),
                        contentDescription = "Add icon",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Select a file", color = Color.White,
                    fontFamily = FontFamily(Font(R.font.poppins_regular))
                    )

                }
            }
        }

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4C72F5))
        ) {
            Text(
                text = "Add", color = Color.White,
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semibold))
            ) //para las fuentes que importo mi nv
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewAddMaterial() {
    AddMaterial()
}
