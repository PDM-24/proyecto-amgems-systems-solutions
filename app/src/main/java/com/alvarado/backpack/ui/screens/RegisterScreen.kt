package com.alvarado.backpack.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alvarado.backpack.MainViewModel
import com.alvarado.backpack.R
import com.alvarado.backpack.UiState
import com.alvarado.backpack.navigate.AppScreens
import com.alvarado.backpack.ui.components.RegisterForm

@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: MainViewModel
) {
    val uiState by viewModel.uiState.collectAsState()

    when (uiState) {
        is UiState.Loading -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFF2F2F2)),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        is UiState.Success -> {
            LaunchedEffect(Unit) {
                navController.navigate(AppScreens.LoginScreen.route)
            }
        }
        is UiState.Error -> {
            // Mostrar mensaje de error con botón para regresar al formulario de registro
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFF2F2F2)),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "USER NOT REGISTER", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = {
                            viewModel.resetUiState()
                        },
                        modifier = Modifier
                            .padding(20.dp)
                            .widthIn(500.dp)
                            .heightIn(60.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFF4C72F5)),
                    ) {
                        Text("Back to Register", fontSize = 20.sp)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = {
                            navController.navigate(AppScreens.LoginScreen.route)
                        },
                        modifier = Modifier
                            .padding(20.dp)
                            .widthIn(500.dp)
                            .heightIn(60.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFF4C72F5)),
                    ) {
                        Text("Back to Login",fontSize = 20.sp)
                    }
                }
            }
        }
        else -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxHeight()
                    .background(Color(0xFFF2F2F2)),
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF3F2AC5)),
                    horizontalAlignment = Alignment.Start
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "REGISTER",
                            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                            modifier = Modifier
                                .padding(start = 40.dp),
                            color = Color.White,
                            fontSize = 30.sp,
                        )
                        Box(modifier = Modifier.padding(start = 0.dp, end = 10.dp, top = 20.dp, bottom = 20.dp)) {
                            Button(
                                colors = ButtonDefaults.buttonColors(Color.White),
                                modifier = Modifier
                                    .width(70.dp)
                                    .height(70.dp),
                                shape = CircleShape,
                                onClick = {
                                    navController.navigate(AppScreens.LoginScreen.route)
                                }) {
                                Image(painter = painterResource(id = R.drawable.ic_arrow_back), contentDescription = "Back", modifier = Modifier.fillMaxSize())
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.padding(10.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    RegisterForm(navController, viewModel)
                }
            }
        }
    }
}
