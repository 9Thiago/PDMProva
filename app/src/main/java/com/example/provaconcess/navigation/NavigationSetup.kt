package com.example.provaconcess.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.provaconcess.screens.HomeScreen
import com.example.provaconcess.screens.SettingsScreen

@Composable
fun NavigationSetup(navController: NavHostController, formFields: Unit) {
    NavHost(navController, startDestination = BottomNavItem.Home.route) {
        composable(BottomNavItem.Home.route) {
            HomeScreen()
        }
        composable(BottomNavItem.Settings.route) {
            SettingsScreen(navController)
        }
    }
}