package com.freelanceror.mytemp.data.di

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {

    @Binds
    fun bindWeatherRepository(repository:WeatherRepositoryImpl):WeatherRepository
}