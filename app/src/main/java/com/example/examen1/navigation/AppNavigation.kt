package com.example.examen1.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.examen1.database.model.Worker
import com.example.examen1.screen.DeforestedAreaDetailScreen
import com.example.examen1.screen.DeforestedAreaListScreen
import com.example.examen1.screen.LoginScreen

@ExperimentalMaterial3Api
@Composable
fun AppNavigation(worker: Worker){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreen.LoginScreen.route){
        composable(route = AppScreen.LoginScreen.route) {
            LoginScreen(navController,worker)
        }
        composable(
            route = AppScreen.DeforestedAreaListScreen.route + "/{user_id}",
            arguments = listOf(
                navArgument(name = "user_id") { type = NavType.IntType }
            )
        ) {
            val userId = it.arguments?.getInt("user_id")
            DeforestedAreaListScreen(navController, userId,worker)
        }
        composable(
            route = AppScreen.DeforestedAreaDetailScreen.route + "/{user_id}/{deforested_area_id}",
            arguments = listOf(
                navArgument(name = "user_id") { type = NavType.IntType },
                navArgument(name = "deforested_area_id") { type = NavType.IntType }
            )
        ) {
            val userId = it.arguments?.getInt("user_id")
            val deforestedAreaId = it.arguments?.getInt("deforested_area_id")
            DeforestedAreaDetailScreen(navController, userId, deforestedAreaId)
        }

    }
}