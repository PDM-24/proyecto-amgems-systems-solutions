package com.alvarado.backpack.ui.components.addMaterial

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.alvarado.backpack.MainViewModel
import android.Manifest
import android.content.pm.PackageManager
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.documentfile.provider.DocumentFile
import com.alvarado.backpack.R
import com.alvarado.backpack.domain.model.PostDataModel
import com.alvarado.backpack.domain.model.SubjectModel
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddMaterial(viewModel: MainViewModel, subjectList: List<SubjectModel>) {
    val titleState = remember { mutableStateOf("") }
    val dateState = remember { mutableStateOf("") }
    val cicleState = remember { mutableStateOf("") }
    val selectedFileName = remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    // Estado para el elemento seleccionado en el menú desplegable
    val selectedSubject = remember { mutableStateOf(subjectList.firstOrNull()?.name ?: "") }

    // Launcher para seleccionar archivos
    val filePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.data?.let { uri: Uri ->
                viewModel.selectedFileUri.value = uri
                selectedFileName.value = uri.lastPathSegment ?: "Unknown file"
                Log.d("AddMaterial", "Selected file URI: $uri")
            }
        }
    }

    // Launcher para solicitar permisos
    val requestPermissionsLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val granted = permissions.entries.all { it.value }
        if (granted) {
            val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
                type = "*/*"
            }
            filePickerLauncher.launch(intent)
        } else {
            // Manejar el caso donde los permisos no son concedidos
            Log.e("AddMaterial", "Permisos no concedidos")
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            modifier = Modifier
                .padding(10.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xFF4C72F5))
                .padding(18.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 0.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Ready to share?",
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.ic_addcircle),
                    contentDescription = "Add icon",
                    modifier = Modifier
                        .size(32.dp)
                        .padding(top = 10.dp)
                )
            }
            Text(
                text = "Teach the world your knowledge",
                fontSize = 15.sp,
                color = Color.White,
                modifier = Modifier,
                fontWeight = FontWeight(300)
            )
        }
        Column(
            modifier = Modifier
                .padding(16.dp)
                .clip(RoundedCornerShape(34.dp))
                .background(Color.White)
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(15.dp))
            TextField(
                value = titleState.value,
                onValueChange = { titleState.value = it },
                label = { Text("Title for the material") },
                leadingIcon = {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .background(Color.Black, shape = RoundedCornerShape(10.dp))
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_let),
                            contentDescription = "Title icon",
                            tint = Color.White,
                            modifier = Modifier
                                .size(24.dp)
                                .align(Alignment.Center)
                        )
                    }
                },
                colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
                modifier = Modifier
                    .shadow(10.dp)
                    .height(55.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            Spacer(modifier = Modifier.height(18.dp))
            TextField(
                value = dateState.value,
                onValueChange = { dateState.value = it },
                label = { Text("Material year") },
                leadingIcon = {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .background(Color.Black, shape = RoundedCornerShape(10.dp))
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_date),
                            contentDescription = "Date icon",
                            tint = Color.White,
                            modifier = Modifier
                                .size(24.dp)
                                .align(Alignment.Center)
                        )
                    }
                },
                colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
                modifier = Modifier
                    .shadow(10.dp)
                    .height(55.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            Spacer(modifier = Modifier.height(18.dp))
            TextField(
                value = cicleState.value,
                onValueChange = { cicleState.value = it },
                label = { Text("Material cycle") },
                leadingIcon = {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .background(Color.Black, shape = RoundedCornerShape(10.dp))
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_cycle),
                            contentDescription = "Cycle icon",
                            tint = Color.White,
                            modifier = Modifier
                                .size(24.dp)
                                .align(Alignment.Center)
                        )
                    }
                },
                colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
                modifier = Modifier
                    .shadow(10.dp)
                    .height(55.dp)
                    .clip(RoundedCornerShape(10.dp))
            )

            Spacer(modifier = Modifier.height(18.dp))
            // Dropdown Menu
            Text("Select Subject")
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                var expanded by remember { mutableStateOf(false) }
                OutlinedTextField(
                    value = selectedSubject.value,
                    onValueChange = {},
                    label = { Text("Subject") },
                    readOnly = true,
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Dropdown icon",
                            Modifier.clickable { expanded = true }
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { expanded = true }
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    subjectList.forEach { subject ->
                        DropdownMenuItem(
                            text = { Text(subject.name) }, // Asegúrate de usar la propiedad correcta del SubjectModel
                            onClick = {
                                selectedSubject.value = subject.id // Actualiza con el nombre del sujeto
                                expanded = false
                            }
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(14.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(34.dp))
                    .padding(5.dp)
            ) {
                Button(
                    onClick = {
                        val permissions = arrayOf(
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                        )
                        if (permissions.all { ContextCompat.checkSelfPermission(context, it) == PackageManager.PERMISSION_GRANTED }) {
                            val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
                                type = "*/*"
                            }
                            filePickerLauncher.launch(intent)
                        } else {
                            requestPermissionsLauncher.launch(permissions)
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_cloud),
                            contentDescription = "Add icon",
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Select a file", color = Color.White,
                            fontFamily = FontFamily(Font(R.font.poppins_regular))
                        )
                    }
                }
                if (selectedFileName.value.isNotEmpty()) {
                    Text(
                        text = "Selected file: ${selectedFileName.value}",
                        color = Color.Gray,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .padding(16.dp)
                .clip(RoundedCornerShape(34.dp))
                .padding(16.dp)
        ) {
            Button(
                onClick = {
                    val uri = viewModel.selectedFileUri.value
                    if (uri != null) {
                        coroutineScope.launch {
                            try {
                                val file = getFileFromUri(uri, context)
                                Log.d("AddMaterial", "File path: ${file.path}")
                                val filePdf: MultipartBody.Part = MultipartBody.Part.createFormData(
                                    "file",
                                    file.name,
                                    file.asRequestBody("application/pdf".toMediaTypeOrNull())
                                )
                                val postDataModel = PostDataModel(
                                    title = titleState.value,
                                    publicationYear = dateState.value.toInt(),
                                    publicationCycle = cicleState.value.toInt(),
                                    subject = selectedSubject.value,
                                    topics = "Algebra",
                                    category = "Parcial"
                                )
                                viewModel.savePost(postDataModel, filePdf)
                            } catch (e: Exception) {
                                Log.e("AddMaterial", "Error uploading file", e)
                            }
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4C72F5))
            ) {
                Text(
                    text = "Add", color = Color.White,
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold))
                )
            }
        }
    }
}

@SuppressLint("Recycle")
fun getFileFromUri(uri: Uri, context: Context): File {
    val inputStream: InputStream? = context.contentResolver.openInputStream(uri)
    val documentFile = DocumentFile.fromSingleUri(context, uri)
    val fileName = documentFile?.name ?: "tempFile"
    val file = File(context.cacheDir, fileName)

    inputStream?.use { input ->
        FileOutputStream(file).use { output ->
            val buffer = ByteArray(4 * 1024)
            var read: Int
            while (input.read(buffer).also { read = it } != -1) {
                output.write(buffer, 0, read)
            }
            output.flush()
        }
    }
    return file
}

