package com.alvarado.backpack.ui.components.report

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alvarado.backpack.R
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow

@SuppressLint("MutableCollectionMutableState")
@Composable
fun ReportReasons(modifier: Modifier) {
    val reasons = listOf(
        "Contenido perjudicial",
        "Spam",
        "Información falsa",
        "Contenido inapropiado",
        "Discurso de odio",
        "Plagio",
        "Violación de privacidad"
    )
    val selectedReasons = remember { mutableStateOf(listOf<String>()) }
    val submittedReasons = remember { mutableStateOf(listOf<String>()) } // keep reasons selected

    Column(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        reasons.forEach { reason ->
            Card(colors = CardDefaults.cardColors(
                containerColor = if (selectedReasons.value.contains(reason)) Color(0xFF0E0B24) else Color.White
            ),
                border = BorderStroke(1.dp, Color.Gray),
                modifier = Modifier
                    .padding(8.dp)
                    .size(330.dp, 47.dp)
                    .shadow(10.dp)
                    .clickable {
                        if (selectedReasons.value.contains(reason)) {
                            selectedReasons.value -= reason // creates new list without reasons
                        } else {
                            selectedReasons.value += reason // creates new list with reasons
                        }
                    }) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = reason,
                        modifier = Modifier.padding(12.dp),
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 15.sp,
                        color = if (selectedReasons.value.contains(reason)) Color.White else Color.Black
                    )
                }
            }
        }
        // buttom
        Box() {
            Button(
                onClick = {
                    submittedReasons.value = selectedReasons.value
                },
                modifier = Modifier
                    .size(330.dp, 60.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF4C72F5)),
                shape = RoundedCornerShape(15.dp)
            ) {
                Text(
                    text = "Send",
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    fontSize = 20.sp
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PreviewReportReasons() {
    ReportReasons(modifier = Modifier)
}