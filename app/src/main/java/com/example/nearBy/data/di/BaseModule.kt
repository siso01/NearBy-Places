package com.example.nearBy.data.di

import com.example.nearBy.data.network.ApiClient
import com.example.nearBy.data.network.ApiService
import com.example.nearBy.domain.Repository.NearbyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class BaseModule {


    @Provides
    @Singleton
    fun provideNetworkService() : ApiService {
        return ApiClient.RetrofitInstance.getApiClient()
    }
}