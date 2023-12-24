package com.example.example

import com.google.gson.annotations.SerializedName


data class NearBy(
    @SerializedName("venues") var venues: ArrayList<Venues> = arrayListOf(),
    @SerializedName("meta") var meta: Meta? = Meta()
)