package com.freelanceror.mytemp.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.freelanceror.mytemp.data.model.WeatherInfo
import com.freelanceror.mytemp.data.remote.RemoteDataSource
import java.time.LocalDate
import java.time.format.TextStyle.FULL
import java.util.Locale
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : WeatherRepository {

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getWeatherData(lat: Float, lng: Float): WeatherInfo {
        val response = remoteDataSource.getWeatherDataResponse(lat, lng)
        val weather = response.weather[0]
        return WeatherInfo(
            locationName = response.name,
            conditionIcon = weather.icon,
            condition = weather.main,
            temperature = response.main.temp.roundToInt(),
            dayOfWeek = LocalDate.now().dayOfWeek.getDisplayName(FULL, Locale.getDefault()),
            isDay = weather.icon.last() == 'd'

        )
    }
}