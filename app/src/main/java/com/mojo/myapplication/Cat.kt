package com.mojo.myapplication

import com.google.gson.annotations.SerializedName

data class Cat(
    @SerializedName("breeds") var breeds: ArrayList<Breed> = arrayListOf(),
    @SerializedName("id") var id: String,
    @SerializedName("url") var url: String,
    @SerializedName("width") var width: Int,
    @SerializedName("height") var height: Int
)
