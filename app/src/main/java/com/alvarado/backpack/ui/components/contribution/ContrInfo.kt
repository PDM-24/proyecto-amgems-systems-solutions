package com.alvarado.backpack.ui.components.contribution

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alvarado.backpack.R

@Composable
fun ContributionInfo(modifier: Modifier) {
    Column(
        modifier = Modifier
            .size(width = 380.dp, height = 180.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(Color(0xFF4C72F5))
    ) {
        Row {
            Box(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Contributioins",
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 25.dp, top = 10.dp),
                    fontFamily = FontFamily(Font(R.font.poppins_bold)),
                    fontSize = 26.sp,
                    color = Color.White
                )
            }
            // image
            Box{
                Image(
                    painter = painterResource(id = R.drawable.ic_blue_bubble),
                    contentDescription = "Fondo Azul",
                    modifier = Modifier
                        .padding(top = 10.dp, end = 10.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_campanita),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(top = 19.dp, start = 10.dp)
                        .size(20.dp)
                )
            }
        }
        // description
        Text(
            text = "help others to help you",
            modifier = Modifier.padding(start = 25.dp),
            fontFamily = FontFamily(Font(R.font.poppins_light)),
            fontSize = 13.sp,
            color = Color.White
        )

        // search bar
    }
}

@Composable
@Preview(showBackground = true)
private fun ContributionInfoReview() {
    ContributionInfo(modifier = Modifier)
}