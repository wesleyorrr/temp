package com.freelanceror.mytemp.data.remote

import com.freelanceror.mytemp.data.remote.response.WeatherDataResponse

interface RemoteDataSource {
    suspend fun getWeatherDataResponse(lat:Float,lng:Float): WeatherDataResponse

}