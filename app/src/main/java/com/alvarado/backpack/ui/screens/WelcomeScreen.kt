package com.alvarado.backpack.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alvarado.backpack.R

@Composable
fun WelcomeScreen(modifier: Modifier = Modifier){

    Column(        modifier = modifier
        .fillMaxSize()
        .fillMaxHeight()
        .background(Color(0xFFF2F2F2)),
        ) {

            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp)
            ){
                Image(painter = painterResource(id = R.drawable.img_bubbles_welcome), contentDescription = "Bubble blue")
                Image(painter = painterResource(id = R.drawable.tablet), contentDescription = "BackPack",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(top = 45.dp)
                        .size(360.dp)
                )
            }

        Text(
            text = "Welcome to BackPack",
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(top = 32.dp, bottom = 8.dp)
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center

        )

        Spacer(modifier = Modifier.padding(5.dp))

        // Description text
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt dolore magna aliqua",
            fontSize = 18.sp,
            color = Color.Gray,
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.padding(2.dp))

        // Button at the bottom
        Button(
            onClick = { /* TODO: Handle click */ },
            modifier = Modifier
                .padding(20.dp)
                .widthIn(500.dp)
                .heightIn(60.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF4C72F5)),
        ) {
            Text(text = "Get Started",
                fontSize = 20.sp,
            )
        }
        }

}
@Preview(showSystemUi = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen()
}