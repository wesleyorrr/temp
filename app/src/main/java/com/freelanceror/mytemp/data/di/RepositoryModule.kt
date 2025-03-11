package com.freelanceror.mytemp.data.di

import com.freelanceror.mytemp.data.repository.WeatherRepository
import com.freelanceror.mytemp.data.repository.WeatherRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {

    @Binds
    fun bindWeatherRepository(repository: WeatherRepositoryImpl): WeatherRepository
}