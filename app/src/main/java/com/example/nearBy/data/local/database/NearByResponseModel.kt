package com.example.nearBy.data.local.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NearByResponseModel(val name : String, val address : String, val mobileNumber : Int?){

    @PrimaryKey(autoGenerate = true)
    var uId : Int = 0
}
