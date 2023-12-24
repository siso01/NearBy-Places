package com.example.nearBy.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NearByDao {

    @Query("SELECT * FROM NearByResponseModel ORDER BY uId DESC LIMIT 10")
    fun getEmployee() : Flow<List<NearByResponseModel>>

    @Insert
    suspend fun insertNearBy(item : NearByResponseModel)
}