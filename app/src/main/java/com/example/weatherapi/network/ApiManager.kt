package com.example.weatherapi.network

class ApiManager {

    private  var weatherService: WeatherService =
    RetrofitInstance.providesRetrofit().create(WeatherService::class.java)

    suspend fun getWeather() = weatherService.getWeather()
}