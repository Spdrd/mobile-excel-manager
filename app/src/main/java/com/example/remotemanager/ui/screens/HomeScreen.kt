package com.example.remotemanager.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.remotemanager.ui.theme.Color1
import com.example.remotemanager.ui.theme.Color2
import com.example.remotemanager.ui.theme.RemoteManagerTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    onConfigurarClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .background(Color2)
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Título
        Text(
            text = "Bienvenid@",
            style = androidx.compose.material3.MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Selecciona una opción para continuar",
            style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 8.dp, bottom = 32.dp)
        )

        // Card contenedora
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = androidx.compose.material3.CardDefaults.cardElevation(8.dp)
        ) {

            Column(
                modifier = Modifier
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                Button(
                    onClick = {
                        navController.navigate(Screen.Register.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                ) {
                    Text("Iniciar")
                }

                OutlinedButton(
                    onClick = onConfigurarClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                ) {
                    Text("Configurar")
                }
            }
        }
    }
}

@Composable
@Preview
fun HomePrev(){
    val navController = rememberNavController()
    RemoteManagerTheme {
        HomeScreen(navController)
    }
}