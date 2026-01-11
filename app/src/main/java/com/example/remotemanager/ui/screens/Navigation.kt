package com.example.remotemanager.ui.screens

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController



@Composable
fun NavigationStack(){
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val screens = listOf(
        Screen.Home
    )

    NavHost(navController = navController, startDestination = Screen
        .Home.route){
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }

        composable(route = Screen.Register.route) {
            RegisterScreen(navController)
        }
    }
}

sealed class Screen (val route: String){
    object Home : Screen("home")
    object Register : Screen(route = "register")
}