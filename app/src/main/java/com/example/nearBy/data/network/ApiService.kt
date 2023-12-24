package com.example.nearBy.data.network

import com.example.example.NearBy
import com.example.nearBy.data.local.database.NearByResponseModel
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("per_page/{perPage}/page/{page}/client_id/{clientId}/lat/{lat}/lon/{lon}/range/{range}/q/{q}")
    suspend fun getNearBy(
        @Path("perPage") userId: Int,
        @Path("page") page: Int,
        @Path("clientId") clientId: String,
        @Path("lat") lat: Double,
        @Path("lon") lon: Double,
        @Path("range") range: String,
        @Path("q") q: String
    ) : NearByResponseModel
}