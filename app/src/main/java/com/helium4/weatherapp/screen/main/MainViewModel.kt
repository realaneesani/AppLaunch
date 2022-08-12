package com.helium4.weatherapp.screen.main

import androidx.lifecycle.ViewModel
import com.helium4.weatherapp.data.DataOrException
import com.helium4.weatherapp.model.Weather
import com.helium4.weatherapp.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: WeatherRepository)
    :ViewModel(){
//        val data : MutableState<DataOrException <Weather,Boolean,Exception>>
//        = mutableStateOf(DataOrException(null, true, Exception("")))


        suspend fun getWeatherData(city: String):
        DataOrException<Weather,Boolean,Exception>{
            return repository.getWeather(cityQuery = city)
        }





//    init {
//        loadWeather()
//    }
//
//    private fun loadWeather() {
//        getWeather("Seattle")
//    }
//
//    private fun getWeather(city: String) {
//        viewModelScope.launch {
//            if (city.isEmpty()) return@launch
//
//            data.value.loading = true
//            data.value =repository.getWeather(cityQuery = city )
//            if (data.value.data.toString().isEmpty()) data.value.loading =false
//
//        }
//        Log.d("GET","GetWeather: ${data.value.data.toString() }")
//
//    }
}