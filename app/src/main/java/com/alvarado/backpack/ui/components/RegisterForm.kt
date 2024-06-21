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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.alvarado.backpack.MainViewModel
import com.alvarado.backpack.R
import com.alvarado.backpack.domain.model.RegisterModel
import com.alvarado.backpack.navigate.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterForm(navController: NavController, viewModel: MainViewModel){

    val emailState: MutableState<String> = remember { mutableStateOf("") }
    val passwordState: MutableState<String> = remember { mutableStateOf("") }
    val nameState: MutableState<String> = remember { mutableStateOf("") }
    val lastNameState: MutableState<String> = remember { mutableStateOf("") }
    val careerState: MutableState<String> = remember { mutableStateOf("") }
    val carnetState: MutableState<String> = remember { mutableStateOf("") }


    var passwordVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .shadow(elevation = 50.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
            .height(650.dp)
            .width(350.dp)
            .padding(30.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
        ) {

            Spacer(modifier = Modifier.padding(5.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {

                LazyColumn {
                    this.itemsIndexed(listOf(1)){ index, item ->
                        Text(
                            text = "Carnet :",
                            fontFamily = FontFamily(Font(R.font.poppins_light)),
                            fontSize = 17.sp
                        )

                        TextField(
                            value = carnetState.value,
                            onValueChange = { carnetState.value = it},
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .background(Color(0xFFF7F7F8)),
                            keyboardOptions = KeyboardOptions.Default.copy(
                                imeAction = ImeAction.None
                            ),
                            singleLine = true,
                            leadingIcon = {
                                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Carnet icon")
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
                        Spacer(modifier = Modifier.padding(5.dp))

                        Text(
                            text = "Name :",
                            fontFamily = FontFamily(Font(R.font.poppins_light)),
                            fontSize = 17.sp
                        )

                        TextField(
                            value = nameState.value,
                            onValueChange = { nameState.value = it},
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .background(Color(0xFFF7F7F8)),
                            keyboardOptions = KeyboardOptions.Default.copy(
                                imeAction = ImeAction.None
                            ),
                            singleLine = true,
                            leadingIcon = {
                                Image(painter = painterResource(id =  R.drawable.ic_person), contentDescription = "Email icon")
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
                        Spacer(modifier = Modifier.padding(5.dp))


                        Text(
                            text = "Last Name :",
                            fontFamily = FontFamily(Font(R.font.poppins_light)),
                            fontSize = 17.sp
                        )

                        TextField(
                            value = lastNameState.value,
                            onValueChange = { lastNameState.value = it},
                            modifier = Modifier
                                .padding(top = 5.dp)
                                .background(Color(0xFFF7F7F8)),
                            keyboardOptions = KeyboardOptions.Default.copy(
                                imeAction = ImeAction.None
                            ),
                            singleLine = true,
                            leadingIcon = {
                                Image(painter = painterResource(id =  R.drawable.ic_person), contentDescription = "Email icon")
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

                        Spacer(modifier = Modifier.padding(5.dp))

                        Text(
                            text = "Career :",
                            fontFamily = FontFamily(Font(R.font.poppins_light)),
                            fontSize = 17.sp
                        )

                        TextField(
                            value = careerState.value,
                            onValueChange = { careerState.value = it},
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .background(Color(0xFFF7F7F8)),
                            keyboardOptions = KeyboardOptions.Default.copy(
                                imeAction = ImeAction.None
                            ),
                            singleLine = true,
                            leadingIcon = {
                                Image(painter = painterResource(id =  R.drawable.ic_career), contentDescription = "Email icon")
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

                        Spacer(modifier = Modifier.padding(5.dp))

                        Text(
                            text = "Email :",
                            fontFamily = FontFamily(Font(R.font.poppins_light)),
                            fontSize = 17.sp
                        )

                        TextField(
                            value = emailState.value,
                            onValueChange = { emailState.value = it},
                            modifier = Modifier
                                .padding(top = 5.dp)
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

                        Spacer(modifier = Modifier.padding(5.dp))

                        Text(
                            text = "Password :",
                            fontFamily = FontFamily(Font(R.font.poppins_light)),
                            fontSize = 17.sp
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

                                    val registerModel = RegisterModel(
                                        carnetState.value,
                                        nameState.value,
                                        lastNameState.value,
                                        emailState.value,
                                        careerState.value,
                                        passwordState.value
                                    )
//                                    viewModel.register(registerModel)

                                    navController.navigate(AppScreens.LoginScreen.route)
                                }
                            ) {
                                Image(painter = painterResource(id = R.drawable.ic_add), contentDescription = "Register")
                            }

                            Button(
                                modifier = Modifier
                                    .widthIn(100.dp)
                                    .heightIn(max = 45.dp),
                                shape = RoundedCornerShape(10.dp),
                                colors = ButtonDefaults.buttonColors(Color(0xFF3F2AC5)),
                                onClick = {
                                    nameState.value = ""
                                    lastNameState.value = ""
                                    emailState.value = ""
                                    careerState.value = ""
                                    passwordState.value = ""
                                }
                            ) {
                                Image(painter = painterResource(id = R.drawable.ic_trash), contentDescription = "Trash")
                            }
                        }
                    }
                }
            }
        }
    }
}