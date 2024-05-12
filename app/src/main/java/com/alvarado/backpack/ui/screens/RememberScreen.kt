package com.alvarado.backpack.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
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
fun RememberScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .background(Color(0xFFF2F2F2)),
    ) {

        Column(
            modifier = Modifier
                .padding(top = 40.dp)
                .fillMaxSize()
                .weight(1f),
        ) {
            Text(
                text = "Remember",
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
            )

            Text(text = "Lorem ipsum dolor sit amet,\n" +
                    "consectetur adipiscing elit, sed do\n" +
                    "eisumod tempor incididunt dolore \n" +
                    "magna aliqua",
                fontSize = 18.sp,
                color = Color.Gray,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bubbles_top_remember),
                    contentDescription = "Top Bubbles",
                    modifier = Modifier
                        .padding(start = 10.dp))
                Image(
                    painter = painterResource(id = R.drawable.rememberimg),
                    contentDescription = "IMG Remember",
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 110.dp)
                )

                Button(
                    onClick = { /* TODO: Handle click */ },
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(20.dp)
                        .widthIn(500.dp)
                        .heightIn(60.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFF4C72F5)),
                ) {
                    Text(text = "Next",
                        fontSize = 20.sp,
                    )
                }

            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun RememberScreenPreview() {
        RememberScreen()
}