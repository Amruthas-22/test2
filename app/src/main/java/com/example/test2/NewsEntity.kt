package com.example.test2

import com.google.gson.annotations.SerializedName

data class NewsEntity (
    @SerializedName("data") val data: List<Article>
){}

    data class Article(
        @SerializedName("title") val title: String,
        @SerializedName("description") val description: String,
        @SerializedName("Source") val source: String,
        @SerializedName("country") val country: String,

    ){}


