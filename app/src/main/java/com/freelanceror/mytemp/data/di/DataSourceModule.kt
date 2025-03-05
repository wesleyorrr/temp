package com.freelanceror.mytemp.data.di

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {
    @Binds
    @Singleton
    fun bindRemoteDataSource(remoteDataSource: KtorRemoteDataSource): RemoteDataSource
}