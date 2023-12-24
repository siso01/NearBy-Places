package com.example.nearBy.data.repository

import com.example.nearBy.data.local.database.NearByResponseModel
import kotlinx.coroutines.flow.Flow

interface NearbyRepository {

   suspend fun fetchNearbyPlaces(
        userId: Int,
        page: Int,
        clientId: String,
        lat: Double,
        lon: Double,
        range: String,
        q: String
    ): NearByResponseModel

}