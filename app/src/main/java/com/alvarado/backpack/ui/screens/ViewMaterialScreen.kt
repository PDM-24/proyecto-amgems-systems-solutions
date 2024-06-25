package com.alvarado.backpack.ui.screens



import android.content.Context
import android.os.Environment
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.alvarado.backpack.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream
import java.io.IOException
import java.net.SocketTimeoutException
@Composable
fun ViewMaterialScreen(navController: NavController, postUrl: String) {

    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .background(Color(0xFFF2F2F2)),
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(painter = painterResource(id = R.drawable.img_bubble_blue_top), contentDescription = "Bubble blue")

                Box(modifier = Modifier.padding(start = 0.dp, end = 30.dp)){
                    Button(
                        colors = ButtonDefaults.buttonColors(Color.White),
                        modifier = Modifier
                            .width(70.dp)
                            .height(70.dp),
                        shape = CircleShape,
                        onClick = {
                            navController.popBackStack()
                        }) {
                        Image(painter = painterResource(id = R.drawable.ic_arrow_back), contentDescription = "Back", modifier = Modifier.fillMaxSize())
                    }
                }
            }
        }
        
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    coroutineScope.launch {
                        downloadFile(navController.context, postUrl)
                    }
                },
                modifier = Modifier
                    .padding(20.dp)
                    .widthIn(300.dp)
                    .heightIn(60.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF4C72F5)),
            ) {
                Text(text = "Download")
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.End
        ) {
            Image(painter = painterResource(id = R.drawable.img_bubble_blue_bottom), contentDescription = "Bubble blue")
        }
    }
}

suspend fun downloadFile(context: Context, fileUrl: String) {
    val client = OkHttpClient()

    val request = Request.Builder()
        .url(fileUrl)
        .build()

    try {
        val response = withContext(Dispatchers.IO) { client.newCall(request).execute() }

        if (response.isSuccessful) {
            response.body?.let { body ->
                val inputStream: InputStream = body.byteStream()
                val file = File(
                    context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS),
                    "downloaded_file.pdf"  // Cambia la extensión y nombre según tu necesidad
                )
                val outputStream: OutputStream = FileOutputStream(file)
                inputStream.use { input ->
                    outputStream.use { output ->
                        input.copyTo(output)
                    }
                }

                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Archivo descargado en: ${file.absolutePath}", Toast.LENGTH_LONG).show()
                }
            } ?: throw IOException("Cuerpo de la respuesta nulo")
        } else {
            throw IOException("Error al descargar el archivo: ${response.message}")
        }
    } catch (e: SocketTimeoutException) {
        withContext(Dispatchers.Main) {
            Toast.makeText(context, "Tiempo de espera agotado al descargar el archivo", Toast.LENGTH_LONG).show()
        }
    } catch (e: IOException) {
        withContext(Dispatchers.Main) {
            Toast.makeText(context, "Error de IO: ${e.message}", Toast.LENGTH_LONG).show()
        }
    } catch (e: Exception) {
        withContext(Dispatchers.Main) {
            Toast.makeText(context, "Error desconocido: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }
}