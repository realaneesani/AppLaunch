package com.helium4.weatherapp.repository

import android.util.Log
import com.helium4.weatherapp.data.DataOrException
import com.helium4.weatherapp.model.Weather
import com.helium4.weatherapp.network.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: WeatherApi) {

    suspend fun getWeather(cityQuery:String): DataOrException<Weather,Boolean,Exception>  {

        val response = try{

            api.getWeather()
        }catch (e:Exception){
            Log.d("INSIDE","getweather: $e")

            return DataOrException(e=e)
        }
        Log.d("INSIDE","getweather: $response")
        return DataOrException(data = response)

    }
}