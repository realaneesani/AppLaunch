package com.helium4.weatherapp.network

import com.helium4.weatherapp.model.Weather
import com.helium4.weatherapp.utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton


@Singleton
interface WeatherApi {

    @GET(value = "/data/2.5/onecall?")
    suspend fun getWeather(
        @Query("lat") lat : String = "12.9082847623315",
        @Query("lon") lon : String = "77.65197822993314",

        @Query("units") units: String = "imperial",
        @Query("appid") appid: String = API_KEY // your api key
    ): Weather


}