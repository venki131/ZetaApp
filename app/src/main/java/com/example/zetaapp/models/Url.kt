package com.example.zetaapp.models


import com.google.gson.annotations.SerializedName

data class Url(
    @SerializedName("template")
    val template: String,
    @SerializedName("type")
    val type: String
)