package com.example.nearBy.data.repositoryImpl

import com.example.nearBy.data.local.database.NearByResponseModel
import com.example.nearBy.data.network.ApiService
import com.example.nearBy.domain.Repository.NearbyRepository
import javax.inject.Inject

class INearbyRepositoryImpl @Inject constructor(
    private val service: ApiService
) : NearbyRepository {
    override suspend fun fetchNearbyPlaces(
        userId: Int,
        page: Int,
        clientId: String,
        lat: Double,
        lon: Double,
        range: String,
        q: String

    ): NearByResponseModel {
       return service.getNearBy(userId, page, clientId, lat, lon, range, q)
    }
}