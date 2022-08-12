package com.helium4.weatherapp.widgets

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun WeatherAppBar(
    title: String = "AppName",
    icon: ImageVector ?=null,
    isMainScreen:Boolean = true,
    elevation: Dp = 0.dp,
    navController: NavController, 
onActionClicked:()-> Unit = {},
    onButtonClicked:()-> Unit ={}

){
    TopAppBar(title =  {
                      Text(text = title)
    }, actions = {},
        navigationIcon = {},
    backgroundColor = Color.Transparent,
    elevation = elevation)
//    {
//
////        Text(text = title,
////        color = MaterialTheme.colors.onSecondary,
////        style = TextStyle(fontSize = 15.sp,
////            fontWeight = FontWeight.Bold
////        )
////        )
//    }


}