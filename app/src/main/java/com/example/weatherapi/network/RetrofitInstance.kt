package com.example.weatherapi.network

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {

    const val cityName = "Denver"
    const val API_KEY = "ed2eb8c47fe2e682c0a3afccc0bea6d5"

    private const val BASE_URL = "api.openweathermap.org/data/2.5/weather?q=${cityName}&appid=${API_KEY}"



    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(

                MoshiConverterFactory
                    .create(
                        Moshi.Builder()
                            .build()
                    )
            )
            .build()
    }

}