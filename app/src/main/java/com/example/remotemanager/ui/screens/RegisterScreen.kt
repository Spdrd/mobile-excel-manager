package com.example.remotemanager.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.remotemanager.dto.ExcelLine
import com.example.remotemanager.service.ExcelService
import com.example.remotemanager.singleton.GlobalConfig
import com.example.remotemanager.singleton.RetrofitClient
import com.example.remotemanager.ui.theme.Color2
import com.example.remotemanager.ui.theme.RemoteManagerTheme
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import java.util.UUID



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    navController: NavController
) {

    val fields = GlobalConfig.fields

    // State for text inputs
    val values = remember {
        mutableStateMapOf<String, String>().apply {
            fields.forEach { put(it, "") }
        }
    }

    Column(
        modifier = Modifier
            .background(Color2)
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {

        // Title
        Text(
            text = "Registrar",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "Completa los campos requeridos",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Card container
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {

            Column(modifier = Modifier.padding(16.dp)) {

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.heightIn(max = 300.dp)
                ) {
                    items(fields) { field ->

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {

                            Text(
                                text = field,
                                modifier = Modifier.weight(1f)
                            )

                            OutlinedTextField(
                                value = values[field] ?: "",
                                onValueChange = { values[field] = it },
                                modifier = Modifier.weight(1.5f),
                                singleLine = true
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Buttons

                val context = LocalContext.current
                val scope = rememberCoroutineScope()
                Button(
                    onClick = {
                        scope.launch {
                            try {
                                RetrofitClient.api.sendLine(
                                    ExcelLine(
                                        UUID.randomUUID().toString(),
                                        GlobalConfig.fileName,
                                        values.toMap()
                                    )
                                )

                                // ✅ Toast de éxito
                                Toast.makeText(
                                    context,
                                    "Registro enviado correctamente",
                                    Toast.LENGTH_SHORT
                                ).show()

                            } catch (e: Exception) {

                                // ❌ Toast de error
                                Toast.makeText(
                                    context,
                                    "Error al enviar el registro",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                ) {
                    Text("Confirmar")
                }


                Spacer(modifier = Modifier.height(12.dp))

                OutlinedButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                ) {
                    Text("Regresar")
                }
            }
        }
    }
}

@Preview
@Composable
fun RegisterPrev(){
    val navController = rememberNavController()
    RemoteManagerTheme {
        RegisterScreen(
            navController = navController
        )

    }
}
