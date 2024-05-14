package com.alvarado.backpack.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alvarado.backpack.R

@Composable
fun ProfileScreen() {
    val email = remember { mutableStateOf("") }
    val career = remember { mutableStateOf("") }
    val name = remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .fillMaxHeight()
            .background(Color(0xFFF2F2F2)),
    ) {
        Spacer(modifier = Modifier.padding(12.dp))

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(30.dp))//para bordear el colum papu
                .background(Color(0xFF4C72F5)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .padding(12.dp)
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = "back icon",)
                }
                Spacer(modifier = Modifier.width(70.dp))
                Column(
                    verticalArrangement = Arrangement.Bottom,
                    modifier = Modifier
                        .height(85.dp)
                ) {

                    Text(
                        "Profile",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier

                            .padding(bottom = 16.dp)
                    )
                }
            }


            Column {
                Image(
                    painter = painterResource(id = R.drawable.ic_email),
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.CenterHorizontally)
                        .border(2.dp, Color.White, CircleShape)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    "Alicia Flores",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    "Computing Student",
                    color = Color.White.copy(alpha = 0.7f),
                    fontSize = 16.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 2.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight(0.1f)
                    ) {
                        Text(
                            "Number of favorites",
                            color = Color.White,
                            fontSize = 10.sp,
                            modifier = Modifier.weight(1f)
                        )

                        Text(
                            "20",
                            color = Color.White,
                            modifier = Modifier.weight(1f),
                            textAlign = TextAlign.Justify
                        )
                    }
                    Divider(
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxHeight(0.1f)
                            .width(1.dp)
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxHeight(0.1f)
                    ) {

                        Text(
                            "Number of contributions",
                            color = Color.White,
                            fontSize = 10.sp,
                            modifier = Modifier.weight(1f)
                        )

                        Text(
                            "12",
                            color = Color.White,
                            modifier = Modifier.weight(1f),
                            textAlign = TextAlign.Justify
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(36.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.Start
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_email_gray),
                    contentDescription = "email icon",
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    text = "Email: ${email.value}",
                    modifier = Modifier.padding(vertical = 8.dp),
                    textAlign = TextAlign.Left,
                    color = Color.LightGray
                )
            }
            Divider(color = Color.LightGray, thickness = 2.5.dp)
            Spacer(modifier = Modifier.height(36.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_career),
                    contentDescription = "career icon",
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    text = "Career: ${career.value}",
                    modifier = Modifier.padding(vertical = 8.dp),
                    color = Color.LightGray
                )
            }
            Divider(color = Color.LightGray, thickness = 2.5.dp)
            Spacer(modifier = Modifier.height(36.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_name),
                    contentDescription = "name icon",
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    text = "Name: ${name.value}",
                    modifier = Modifier.padding(vertical = 8.dp),
                    textAlign = TextAlign.Left,
                    color = Color.LightGray
                )
            }
            Divider(color = Color.LightGray, thickness = 2.5.dp)
            Spacer(modifier = Modifier.height(36.dp))

            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(10.dp),

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



