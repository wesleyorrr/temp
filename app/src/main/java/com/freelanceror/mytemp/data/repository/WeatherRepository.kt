package com.freelanceror.mytemp.data.repository

interface WeatherRepository {
    suspend fun getWeatherData(lat:Float, lng: Float):WeatherInfo
}
