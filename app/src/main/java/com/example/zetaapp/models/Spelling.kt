package com.example.zetaapp.models


import com.google.gson.annotations.SerializedName

data class Spelling(
    @SerializedName("correctedQuery")
    val correctedQuery: String,
    @SerializedName("htmlCorrectedQuery")
    val htmlCorrectedQuery: String
)