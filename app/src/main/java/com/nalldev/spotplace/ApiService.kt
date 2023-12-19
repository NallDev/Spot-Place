package com.nalldev.spotplace

import com.nalldev.spotplace.model.WeatherModel
import retrofit2.http.GET

interface ApiService {
    @GET("weather/bali")
    suspend fun getWeather() : WeatherModel
}