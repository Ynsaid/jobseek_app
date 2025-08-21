package com.example.jopsearchapp

import DetailsScreen
import com.example.jopsearchapp.Screens.SplashScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jopsearchapp.ui.theme.JopSearchAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            JopSearchAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(navController = navController, startDestination = Route.Splash,modifier = Modifier.padding(innerPadding)){
                        composable(Route.Splash) { SplashScreen(navController) }
                        composable(Route.Home) { HomeScreen(navController) }
                        composable(Route.Details) {
                            val job = navController.previousBackStackEntry?.savedStateHandle?.get<Job>("job")
                            job?.let { DetailsScreen(navController, it) }
                        }
                    }
                }
            }
        }
    }
}

