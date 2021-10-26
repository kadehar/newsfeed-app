package com.github.kadehar.newsfeed.features.news_screen.domain.model

data class Article(
    val title: String,
    val description: String?,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val isBookmarked: Boolean = false
)
