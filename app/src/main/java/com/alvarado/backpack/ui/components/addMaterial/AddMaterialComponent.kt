package com.alvarado.backpack.ui.components.addMaterial

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alvarado.backpack.R
import kotlin.math.round

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddMaterial() {

    val titleState: MutableState<String> = remember { mutableStateOf("") }
    val dateState: MutableState<String> = remember { mutableStateOf("") }
    val cicleState: MutableState<String> = remember { mutableStateOf("") }
    val descriptionState: MutableState<String> = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        Column(
            modifier = Modifier
                .padding(10.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xFF4C72F5))
                .padding(18.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 0.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Ready to share?",
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.weight(1f))

                Image(
                    painter = painterResource(id = R.drawable.ic_addcircle),
                    contentDescription = "Add icon",
                    modifier = Modifier
                        .size(32.dp)
                        .padding(top = 10.dp)
                )
            }

            Text(
                text = "Teach the world your knowledge",
                fontSize = 15.sp,
                color = Color.White,
                modifier = Modifier,
                fontWeight = FontWeight(300)
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
                value = titleState.value,
                onValueChange = {titleState.value = it},
                label = { Text("Title for the material") },
                leadingIcon = {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .background(Color.Black, shape = RoundedCornerShape(10.dp))
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_let),
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
                    .height(55.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            Spacer(modifier = Modifier.height(18.dp))

            TextField(
                value = dateState.value,
                onValueChange = {dateState.value = it},
                label = { Text("Material year")},
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
                    .shadow(10.dp)
                    .height(55.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            Spacer(modifier = Modifier.height(18.dp))
            TextField(
                value = cicleState.value,
                onValueChange = {cicleState.value = it},
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
                    .height(55.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            Spacer(modifier = Modifier.height(18.dp))
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
                                    .size(50.dp)
                                    .fillMaxWidth()
                                    .padding(15.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_des),
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
                        value = descriptionState.value,
                        onValueChange = {descriptionState.value = it},
                        label = { Text("Add a description to the material...") },
                        modifier = Modifier.size(width = 280.dp, height = 120.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.White,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        )

                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(34.dp))
                    .padding(5.dp)
            ) {
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
                        Text(
                            text = "Select a file", color = Color.White,
                            fontFamily = FontFamily(Font(R.font.poppins_regular))
                        )
                    }
                }
            }
        }
        Column(
            modifier = Modifier
                .padding(16.dp)
                .clip(RoundedCornerShape(34.dp))
                .padding(16.dp)
        ) {
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
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewAddMaterial() {
    AddMaterial()
}