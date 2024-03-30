package com.example.nearBy.ui.di

import com.example.nearBy.data.network.ApiService
import com.example.nearBy.data.repositoryImpl.INearbyRepositoryImpl
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
    fun provideNearByRepository(service: ApiService) : NearbyRepository {
        return INearbyRepositoryImpl(service)
    }
}