package com.alvarado.backpack.ui.components

import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alvarado.backpack.R
@Composable
fun SearchComponent(
    modifier: Modifier = Modifier,
    title: String,
    subTitle: String,
    onSearch: (String) -> Unit
) {
    val search = remember { mutableStateOf("") }

    Surface(
        modifier = modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth(),
        shadowElevation = 4.dp,
        shape = RoundedCornerShape(20.dp),
        color = Color(0xFF4C72F5)
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp),
        ) {
            Row(
                modifier = Modifier
                    .weight(4f)
            ) {

                Column {
                    Text(
                        text = title,
                        fontSize = 25.sp,
                        color = Color.White,
                        modifier = Modifier,
                        fontWeight = FontWeight(700)
                    )

                    Text(
                        text = subTitle,
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = Modifier,
                        fontWeight = FontWeight(300)
                    )
                }

            }
            Spacer(modifier = Modifier.weight(1f))
            TextField(
                value = search.value,
                onValueChange = {
                    search.value = it
                    onSearch(it)
                },
                modifier = Modifier
                    .fillMaxWidth(),
                label = { Text(text = "Search") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                },
                shape = RoundedCornerShape(50.dp),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    disabledTextColor = Color.Black,
                    errorTextColor = Color.Black,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.Black,
                    errorContainerColor = Color.Red,
                    cursorColor = Color.Black,
                    errorCursorColor = Color.Black,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Black,
                    errorIndicatorColor = Color.Black,
                    focusedLeadingIconColor = Color.Black,
                    unfocusedLeadingIconColor = Color.Black,
                    disabledLeadingIconColor = Color.Black,
                    errorLeadingIconColor = Color.Black,
                    focusedTrailingIconColor = Color.Black,
                    unfocusedTrailingIconColor = Color.Black,
                    disabledTrailingIconColor = Color.Black,
                    errorTrailingIconColor = Color.Black,
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.Black,
                    disabledLabelColor = Color.Black,
                    errorLabelColor = Color.Black,
                    focusedPlaceholderColor = Color.Black,
                    unfocusedPlaceholderColor = Color.Black,
                    disabledPlaceholderColor = Color.Black,
                    errorPlaceholderColor = Color.Black,
                    focusedSupportingTextColor = Color.Black,
                    unfocusedSupportingTextColor = Color.White,
                    disabledSupportingTextColor = Color.Black,
                    errorSupportingTextColor = Color.Black,
                    focusedPrefixColor = Color.Black,
                    unfocusedPrefixColor = Color.White,
                    disabledPrefixColor = Color.Black,
                    errorPrefixColor = Color.Black,
                    focusedSuffixColor = Color.Black,
                    unfocusedSuffixColor = Color.White,
                    disabledSuffixColor = Color.Black,
                    errorSuffixColor = Color.Black
                ),
            )
        }
    }
}
