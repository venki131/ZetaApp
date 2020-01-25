package com.example.zetaapp.models


import com.google.gson.annotations.SerializedName

data class Metatag(
    @SerializedName("og:description")
    val ogDescription: String,
    @SerializedName("og:image")
    val ogImage: String,
    @SerializedName("og:title")
    val ogTitle: String,
    @SerializedName("og:type")
    val ogType: String,
    @SerializedName("og:url")
    val ogUrl: String,
    @SerializedName("twitter:card")
    val twitterCard: String,
    @SerializedName("twitter:description")
    val twitterDescription: String,
    @SerializedName("twitter:image:src")
    val twitterImageSrc: String,
    @SerializedName("twitter:title")
    val twitterTitle: String,
    @SerializedName("viewport")
    val viewport: String
)