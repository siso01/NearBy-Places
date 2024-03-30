package com.example.domain.main.usecases

import com.example.nearBy.data.local.database.NearByResponseModel
import com.example.nearBy.domain.Repository.NearbyRepository
import javax.inject.Inject

class NearByUseCase @Inject constructor(
    private val repository: NearbyRepository
) {
    suspend fun fetchApi(
        userId: Int,
        page: Int,
        clientId: String,
        lat: Double,
        lon: Double,
        range: String,
        q: String

    ): NearByResponseModel {
        return repository.fetchNearbyPlaces(userId, page, clientId, lat, lon, range, q)
    }
}