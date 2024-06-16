package com.alvarado.backpack.ui.components.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alvarado.backpack.R

@Composable
fun ProfileInfoComponent(navController: NavController) {
    val email = remember { mutableStateOf("example@example.com") }
    val career = remember { mutableStateOf("Computing Student") }
    val name = remember { mutableStateOf("Alicia Flores") }
    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = {
                Text(
                    text = "LOG OUT",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                )
            },
            text = {
                Text(
                    "Are you sure you want to log out?",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                )
            },
            confirmButton = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = {
                            showDialog = false
                            navController.navigate("Login_Screen") {
                                popUpTo("profile") { inclusive = true }
                            }
                        },
                        colors = ButtonDefaults.buttonColors(Color(0xFF4C72F5)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Confirm", fontFamily = FontFamily(Font(R.font.poppins_semibold)))
                    }
                }
            },
            dismissButton = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = { showDialog = false },
                        colors = ButtonDefaults.buttonColors(Color(0xFF4C72F5)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Cancel", fontFamily = FontFamily(Font(R.font.poppins_semibold)),)
                    }
                }
            }
        )
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(12.dp))

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(30.dp))
                .background(Color(0xFF4C72F5))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    "Profile",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    modifier = Modifier.padding(end = 128.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .border(2.dp, Color.White, CircleShape)
                        .clip(CircleShape)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.mochila),
                        contentDescription = "Profile Image",
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    "Alicia Flores",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_medium))
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    "Computing Student",
                    color = Color.White.copy(alpha = 0.7f),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_light))
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "Number of favorites",
                        color = Color.White,
                        fontSize = 10.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily(Font(R.font.poppins_bold)),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_prof_like),
                            contentDescription = "like icon",
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            "20",
                            color = Color.White,
                            fontSize = 15.sp,
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily(Font(R.font.poppins_bold))
                        )
                    }
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "Number of contributions",
                        color = Color.White,
                        fontSize = 10.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily(Font(R.font.poppins_bold)),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_prof_stat),
                            contentDescription = "stats icon",
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            "12",
                            color = Color.White,
                            fontSize = 15.sp,
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily(Font(R.font.poppins_bold))
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(36.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_mail),
                            contentDescription = "email icon",
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Column(
                            modifier = Modifier.padding(start = 10.dp)
                        ) {
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(color = Color.LightGray)) {
                                        append("Email: ")
                                    }
                                },
                                textAlign = TextAlign.Left,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                modifier = Modifier.padding(vertical = 0.dp)
                            )
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(color = Color.Black)) {
                                        append("${email.value}")
                                    }
                                },
                                textAlign = TextAlign.Left,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                modifier = Modifier.padding(top = 0.dp)
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(6.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_grad),
                            contentDescription = "career icon",
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Column(
                            modifier = Modifier.padding(start = 10.dp)
                        ) {
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(color = Color.LightGray)) {
                                        append("Career: ")
                                    }
                                },
                                textAlign = TextAlign.Left,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                modifier = Modifier.padding(vertical = 0.dp)
                            )
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(color = Color.Black)) {
                                        append(career.value)
                                    }
                                },
                                textAlign = TextAlign.Left,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                modifier = Modifier.padding(top = 0.dp)
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(6.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_us_prof),
                            contentDescription = "name icon",
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Column(
                            modifier = Modifier.padding(start = 10.dp)
                        ) {
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(color = Color.LightGray)) {
                                        append("Name: ")
                                    }
                                },
                                textAlign = TextAlign.Left,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                modifier = Modifier.padding(vertical = 0.dp)
                            )
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(color = Color.Black)) {
                                        append("${name.value}")
                                    }
                                },
                                textAlign = TextAlign.Left,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                modifier = Modifier.padding(top = 0.dp)
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(36.dp))

            Button(
                onClick = { showDialog = true },
                modifier = Modifier
                    .height(48.dp)
                    .width(400.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            ) {
                Text("Log out", color = Color.White)
            }
        }
    }
}