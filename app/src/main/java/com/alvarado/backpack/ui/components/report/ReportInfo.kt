package com.alvarado.backpack.ui.components.report

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
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
fun ReportInfo(
    modifier: Modifier,
    documentCycle: String,
    documentDate: String,
    documentTitle: String
) {
    Column(
        modifier = Modifier
            .size(width = 380.dp, height = 230.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(Color(0xFF4C72F5))

    ) {
        Row {
            Box(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Report", modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 25.dp, top = 10.dp, bottom = 10.dp),
                    fontFamily = FontFamily(Font(R.font.poppins_bold)),
                    fontSize = 26.sp,
                    color = Color.White
                )
            }
            // image
            Box {
                Image(
                    painter = painterResource(id = R.drawable.ic_white_bg),
                    contentDescription = "Fondo Blanco",
                    modifier = Modifier
                        .padding(top = 10.dp, end = 10.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_exclamacion),
                    contentDescription = "Advertencia",
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .size(40.dp)
                )
            }
        }
        Box(
            modifier = Modifier
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 25.dp, bottom = 8.dp),
                fontFamily = FontFamily(Font(R.font.poppins_light)),
                fontSize = 16.sp,
                color = Color.White,
                text = "Tell us the reason"
            )
        }
        HorizontalDivider(
            modifier = Modifier.padding(
                start = 25.dp,
                end = 25.dp,
                top = 10.dp,
                bottom = 10.dp
            ),
            thickness = 2.dp
        )
        Text(
            text = documentCycle,
            modifier = Modifier.padding(start = 25.dp, top = 10.dp, bottom = 10.dp),
            fontFamily = FontFamily(Font(R.font.poppins_bold)),
            fontSize = 13.sp,
            color = Color.White
        )
        Text(
            text = documentDate,
            modifier = Modifier.padding(start = 25.dp, top = 10.dp, bottom = 10.dp),
            fontFamily = FontFamily(Font(R.font.poppins_bold)),
            fontSize = 13.sp,
            color = Color.White
        )
        Text(
            text = documentTitle,
            modifier = Modifier.padding(start = 25.dp, top = 10.dp, bottom = 10.dp),
            fontFamily = FontFamily(Font(R.font.poppins_medium)),
            fontSize = 16.sp,
            color = Color.White
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun ReportInfoPreview() {
    ReportInfo(
        modifier = Modifier,
        documentCycle = "Ciclo 02/2023",
        documentDate = "2023-03-01",
        documentTitle = "[PRESENTACION] - Matrices y Vectores"
    )
}