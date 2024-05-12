package com.alvarado.backpack.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alvarado.backpack.R
import com.alvarado.backpack.navigate.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginForm(navController: NavController){

    val emailState: MutableState<String> = remember { mutableStateOf("") }
    val passwordState: MutableState<String> = remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .shadow(elevation = 50.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
            .height(500.dp)
            .width(300.dp)
            .padding(30.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "BackPack")
            Text(
                text = "BACKPACK",
                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                fontSize = 30.sp,
                color = Color(0xFF333333)
            )

            Spacer(modifier = Modifier.padding(5.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Email :",
                    fontFamily = FontFamily(Font(R.font.poppins_light)),
                    fontSize = 23.sp
                )

                TextField(
                    value = emailState.value,
                    onValueChange = { emailState.value = it},
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .background(Color(0xFFF7F7F8)),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.None
                    ),
                    singleLine = true,
                    leadingIcon = {
                        Image(painter = painterResource(id =  R.drawable.ic_email), contentDescription = "Email icon")
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        unfocusedLabelColor = Color(0xFF333333),
                        focusedLabelColor = Color(0xFF333333),
                        cursorColor = Color(0xFF333333),
                        focusedLeadingIconColor = Color(0xFF333333),
                        unfocusedLeadingIconColor = Color(0xFF333333),
                        focusedTrailingIconColor = Color(0xFF333333),
                        unfocusedTrailingIconColor = Color(0xFF333333),
                        focusedIndicatorColor = Color.Transparent,
                        containerColor = Color(0xFFF7F7F8),
                        focusedTextColor = Color(0xFF333333),
                        unfocusedIndicatorColor = Color.Transparent),
                    shape = RoundedCornerShape(10.dp)
                )

                Spacer(modifier = Modifier.padding(10.dp))

                Text(
                    text = "Password :",
                    fontFamily = FontFamily(Font(R.font.poppins_light)),
                    fontSize = 23.sp
                )

                TextField(
                    value = passwordState.value,
                    onValueChange = { passwordState.value = it},
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .background(Color(0xFFF7F7F8)),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.None
                    ),
                    singleLine = true,
                    leadingIcon = {
                        Image(painter = painterResource(id =  R.drawable.ic_password), contentDescription = "Email icon")
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        unfocusedLabelColor = Color(0xFF333333),
                        focusedLabelColor = Color(0xFF333333),
                        cursorColor = Color(0xFF333333),
                        focusedLeadingIconColor = Color(0xFF333333),
                        unfocusedLeadingIconColor = Color(0xFF333333),
                        focusedTrailingIconColor = Color(0xFF333333),
                        unfocusedTrailingIconColor = Color(0xFF333333),
                        focusedIndicatorColor = Color.Transparent,
                        containerColor = Color(0xFFF7F7F8),
                        focusedTextColor = Color(0xFF333333),
                        unfocusedIndicatorColor = Color.Transparent),
                    shape = RoundedCornerShape(20.dp)
                )

                Spacer(modifier = Modifier.padding(10.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        modifier = Modifier
                            .widthIn(100.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFF4C72F5)),
                        onClick = {

                        }
                    ) {
                        Image(painter = painterResource(id = R.drawable.ic_next_log), contentDescription = "Login")
                    }

                    Button(
                        modifier = Modifier
                            .widthIn(100.dp)
                            .heightIn(max = 45.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFF3F2AC5)),
                        onClick = {
                            navController.navigate(AppScreens.RegisterScreen.route)
                        }
                    ) {
                        Image(painter = painterResource(id = R.drawable.ico_register), contentDescription = "Login")
                    }
                }
            }
        }
    }
}