package com.alvarado.backpack.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.alvarado.backpack.R
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun SubjectCard(modifier: Modifier, courseImage: Painter, courseName: String, courses: String) {

    Surface(
        modifier = Modifier
            .size(width = 164.dp, height = 169.dp)
            .clip(RoundedCornerShape(20.dp))
            .shadow(2.dp),
        color = Color.White // colocar color para que me crean
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // image
            Image(
                painter = courseImage,
                contentDescription = "Materia",
                modifier = Modifier
                    .size(100.dp)
            )
            // title
            Text(
                modifier = Modifier,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                fontSize = 14.sp,
                color = Color.Black,
                text = courseName
            )
            // courses
            Text(
                modifier = Modifier,
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                fontSize = 11.sp,
                color = Color.Gray,
                text = courses
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSubjectCard() {
    SubjectCard(
        modifier = Modifier,
        courseImage = painterResource(id = R.drawable.ic_materia),
        courseName = "Curso de prueba",
        courses = "3 cursos"
    )
}