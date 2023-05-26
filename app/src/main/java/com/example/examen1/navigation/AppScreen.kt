package com.example.examen1.navigation

sealed class AppScreen(val route: String) {
    object LoginScreen: AppScreen("login")
    object DeforestedAreaListScreen: AppScreen("deforested-area-list")
    object DeforestedAreaDetailScreen: AppScreen("deforested-area-detail")
}
