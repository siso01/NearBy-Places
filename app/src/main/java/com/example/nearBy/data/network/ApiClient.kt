package com.example.nearBy.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {


    object RetrofitInstance {

        private val apiClient: ApiClient

        init {
            val okHttpClient = createOkHttpClient()
            val retrofit = createRetrofitInstance(okHttpClient)
            apiClient = retrofit.create(ApiClient::class.java)
        }

        fun getMyApi(): ApiClient {
            return apiClient
        }

        private fun createOkHttpClient(): OkHttpClient {
            return OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build()
        }

        private fun createRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                .baseUrl(NetworkConstant.baseUrl)  // Replace with your base URL
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
        }
    }
}