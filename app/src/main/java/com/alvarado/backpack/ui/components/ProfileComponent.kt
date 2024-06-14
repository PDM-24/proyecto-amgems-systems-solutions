package com.alvarado.backpack.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.alvarado.backpack.R

@Composable
fun ProfileScreen() {
    val email = remember { mutableStateOf("example@example.com") }
    val career = remember { mutableStateOf("Computing Student") }
    val name = remember { mutableStateOf("Alicia Flores") }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .background(Color(0xFFF2F2F2))
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
                        .size(100.dp) // Tamaño del círculo
                        .border(2.dp, Color.White, CircleShape) // Borde blanco circular
                        .clip(CircleShape) // Recorte de la Box en forma circular
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_email), // Reemplaza con tu imagen
                        contentDescription = "Profile Image",
                        modifier = Modifier
                            .size(100.dp) // Tamaño de la imagen
                            .clip(CircleShape) // Recorte de la imagen en forma circular
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
                        fontFamily = FontFamily(Font(R.font.poppins_bold))
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_like),
                            contentDescription = "like icon",
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            "20",
                            color = Color.White,
                            fontSize = 15.sp,
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily(Font(R.font.poppins_bold))
                        )
                    }

                }
                Divider(
                    color = Color.White,
                    modifier = Modifier
                        .height(56.dp)
                        .width(1.dp)
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "Number of contributions",
                        color = Color.White,
                        fontSize = 10.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily(Font(R.font.poppins_bold))
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_stats),
                            contentDescription = "stats icon",
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
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
                            painter = painterResource(id = R.drawable.ic_email_gray),
                            contentDescription = "email icon",
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Column {
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
            Divider(color = Color.LightGray, thickness = 2.5.dp)
            Spacer(modifier = Modifier.height(6.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_career),
                            contentDescription = "career icon",
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Column {
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
            Divider(color = Color.LightGray, thickness = 2.5.dp)
            Spacer(modifier = Modifier.height(6.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_name),
                            contentDescription = "name icon",
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Column {
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
            Divider(color = Color.LightGray, thickness = 2.5.dp)
            Spacer(modifier = Modifier.height(36.dp))

            Button(
                onClick = {},
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


@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen() {
    ProfileScreen()
}
