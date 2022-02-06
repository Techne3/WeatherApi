package com.example.weatherapi.network

import com.example.weatherapi.network.models.WeatherModel
import retrofit2.Response
import retrofit2.http.GET

interface WeatherService {


    @GET("")
    suspend fun getWeather(): Response<List<WeatherModel>>

}