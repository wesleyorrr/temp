package com.freelanceror.mytemp.data.remote

interface RemoteDataSource {
    suspend fun getWeatherDataResponse(lat:Float,lng:Float): WeatherDataResponse

}