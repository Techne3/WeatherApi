package com.example.weatherapi.repository

import android.util.Log
import com.example.weatherapi.TAG
import com.example.weatherapi.network.ApiManager
import com.example.weatherapi.network.models.WeatherModel
import java.lang.Exception


class WeatherRepository(
    private val apiManager: ApiManager
) {
    suspend fun getWeather() : List<WeatherModel>? {
        return try {
            val response = apiManager.getWeather()
            if (response.isSuccessful) {
                Log.v(TAG," HEEERRRREEEE IS IT SUCCESSFUL ${response.isSuccessful}")
                Log.d(TAG," $response")
                response.body()
            } else {
                emptyList()
            }
        } catch (ex : Exception) {
            emptyList()
        }
    }

}