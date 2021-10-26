package com.github.kadehar.newsfeed.features.news_screen.data.api.model

import com.google.gson.annotations.SerializedName

data class ArticleRemoteModel(
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String?,
    @SerializedName("url")
    val url: String,
    @SerializedName("urlToImage")
    val urlToImage: String?,
    @SerializedName("publishedAt")
    val publishedAt: String
)
