package com.helium4.weatherapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.helium4.weatherapp.screen.login.LoginScreen
import com.helium4.weatherapp.screen.main.MainScreen
import com.helium4.weatherapp.screen.main.MainViewModel
import com.helium4.weatherapp.screen.splash.WeatherSplashScreen
import com.helium4.weatherapp.screen.user.UserScreen


@Composable
fun WeatherNavigation() {
    
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination =  WeatherScreens.SplashScreen.name){

        composable(WeatherScreens.SplashScreen.name){
            WeatherSplashScreen(navController =navController)
        }


        composable(WeatherScreens.MainScreen.name){
            val mainViewModel = hiltViewModel<MainViewModel>()
            MainScreen(navController =navController,mainViewModel)
        }

        composable(WeatherScreens.LoginScreen.name){
            val mainViewModel = hiltViewModel<MainViewModel>()
            LoginScreen(navController =navController)
        }
        composable(WeatherScreens.UserScreen.name){
            val mainViewModel = hiltViewModel<MainViewModel>()
            UserScreen(navController =navController)
        }

    }
}