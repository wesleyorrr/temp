package com.freelanceror.mytemp.data.repository

import com.freelanceror.mytemp.data.model.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat:Float, lng: Float): WeatherInfo
}
