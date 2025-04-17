package com.nnamanistephen.countryexplorer.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nnamanistephen.countryexplorer.presentation.screens.CountryDetailScreen
import com.nnamanistephen.countryexplorer.presentation.screens.CountryListScreen

@Composable
fun CountryNavigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "countries"
    ) {
        composable("countries"){
            CountryListScreen { code ->
                navController.navigate("country/$code")
            }
        }
        composable("country/{code}"){ backStackEntry ->  
            val code = backStackEntry.arguments?.getString("code") ?: return@composable
            CountryDetailScreen(code = code)
        }
    }
}