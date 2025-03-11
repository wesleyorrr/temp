package com.freelanceror.mytemp.data

import com.freelanceror.mytemp.data.remote.RemoteDataSource
import com.freelanceror.mytemp.data.remote.response.WeatherDataResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

class KtorRemoteDataSource @Inject constructor(
    private val httpClient: HttpClient
) : RemoteDataSource {

    companion object {
        private const val BASE_URL = "https://api.openweathermap.org/data/2.5"
    }

    override suspend fun getWeatherDataResponse(lat: Float, lng: Float): WeatherDataResponse {
        return httpClient
            //  .get("${BASE_URL}/weather?lat=$lat&lon=$lng&appid=suachavedeapiaqui&units=metric")
            .get("${BASE_URL}/weather?lat=$lat&lon=$lng&appid=bcf9d4eeef0e4bad5873f2dff87edc4c&units=metric")
            .body()
    }
}