package com.helium4.weatherapp.screen.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.helium4.weatherapp.data.DataOrException
import com.helium4.weatherapp.model.Weather
import com.helium4.weatherapp.widgets.WeatherAppBar

@Composable
fun MainScreen(navController: NavController,
               mainViewModel: MainViewModel ) {



    val weatherData= produceState<DataOrException<Weather,Boolean,Exception>>(
        initialValue =DataOrException(loading = true)){
        value = mainViewModel.getWeatherData(city = "Seattle")
    }.value



   // Text(text = "MainScreen ${weatherData.data!!.city.name }")


    if(weatherData.loading == true){
        CircularProgressIndicator()

    }else if (weatherData.data != null){

        MainScaffold(weather = weatherData.data!!,navController)

    }
}

@Composable
fun MainScaffold(weather: Weather, navController: NavController) {



    Scaffold(topBar = {
        WeatherAppBar(title = "WeatherApp",navController = navController, elevation = 5.dp)
    }) {
        
        MainContent( data = weather)
        
    }

}

@Composable
fun MainContent(data: Weather) {
    Column(verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Clouds : "+data.current.clouds)
        Text(text = "Dew Points : "+data.current.dew_point)
        Text(text = "DT : "+data.current.dt)
        Text(text = "Feels Like  : "+data.current.feels_like)
        Text(text = "Humidity : "+data.current.humidity)
        Text(text = "Pressure : "+data.current.pressure)
        Text(text = "Sunrise : "+data.current.sunrise)
        Text(text = "Sunset : "+data.current.sunset)
        Text(text = "Temp : "+data.current.temp)
        Text(text = "UVI : "+data.current.uvi)
        Text(text = "Visibility : "+data.current.visibility)
        Text(text = "Weather : "+data.current.weather)
        Text(text = "Wind Degree : "+data.current.wind_deg)
        Text(text = "Speed : "+data.current.wind_speed)
    }
    





}

