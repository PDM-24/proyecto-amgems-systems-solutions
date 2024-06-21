package com.alvarado.backpack.ui.components

import android.app.Activity
import android.content.Context
import android.content.Intent
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alvarado.backpack.MainViewModel
import com.alvarado.backpack.R
import com.alvarado.backpack.UiState
import com.alvarado.backpack.domain.model.LoginModel
import com.alvarado.backpack.navigate.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginForm(navController: NavController, viewModel: MainViewModel) {
    val emailState: MutableState<String> = remember { mutableStateOf("") }
    val passwordState: MutableState<String> = remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    val uiState by viewModel.uiState.collectAsState()

    Box(
        modifier = Modifier
            .shadow(elevation = 50.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
            .height(530.dp)
            .width(300.dp)
            .padding(30.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.logo_backpack), contentDescription = "BackPack", modifier = Modifier.width(70.dp))
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
                    onValueChange = { emailState.value = it },
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .background(Color(0xFFF7F7F8)),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.None
                    ),
                    singleLine = true,
                    leadingIcon = {
                        Image(painter = painterResource(id = R.drawable.ic_email), contentDescription = "Email icon")
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
                        unfocusedIndicatorColor = Color.Transparent
                    ),
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
                    onValueChange = { passwordState.value = it },
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .background(Color(0xFFF7F7F8)),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.None
                    ),
                    singleLine = true,
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_password),
                            contentDescription = "Password icon"
                        )
                    },
                    trailingIcon = {
                        val image = if (passwordVisible)
                            painterResource(id = R.drawable.ic_visibility)
                        else
                            painterResource(id = R.drawable.ic_visibility_off)

                        IconButton(onClick = {
                            passwordVisible = !passwordVisible
                        }) {
                            Image(
                                painter = image,
                                contentDescription = "Toggle password visibility"
                            )
                        }
                    },
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
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
                        unfocusedIndicatorColor = Color.Transparent
                    ),
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
                            val loginModel = LoginModel(emailState.value, passwordState.value)
                            viewModel.login(loginModel)
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
                        Image(painter = painterResource(id = R.drawable.ico_register), contentDescription = "Register")
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                when (uiState) {
                    is UiState.Loading -> {
                        CircularProgressIndicator()
                    }
                    is UiState.Success -> {
                        Text(text = "Login Successful!", color = Color.Green, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth())
                        navController.navigate(AppScreens.AppController.route)
                    }
                    is UiState.Error -> {
                        Text(text = "Login Failed!", color = Color.Red, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth())
                    }
                    else -> {}
                }
            }
        }
    }
}
