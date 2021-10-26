package com.github.kadehar.newsfeed.features.news_screen.data.api.model

import com.google.gson.annotations.SerializedName

data class ArticlesRemoteModel(
    @SerializedName("articles")
    val articles: List<ArticleRemoteModel>
)
