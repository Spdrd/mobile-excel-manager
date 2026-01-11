package com.example.remotemanager.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.remotemanager.ui.theme.Color1
import com.example.remotemanager.ui.theme.Color2
import com.example.remotemanager.ui.theme.RemoteManagerTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SampleScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mi App") },
                modifier = Modifier,
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color1
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            Text("Contenido")
        }
    }
}

@Preview
@Composable
fun Preview(){
    RemoteManagerTheme {
        SampleScreen()
    }
}