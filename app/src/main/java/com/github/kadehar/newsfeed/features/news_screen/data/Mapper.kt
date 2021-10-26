package com.github.kadehar.newsfeed.features.news_screen.data

import com.github.kadehar.newsfeed.features.news_screen.data.api.model.ArticleRemoteModel
import com.github.kadehar.newsfeed.features.news_screen.domain.model.Article

fun ArticleRemoteModel.toDomainModel(): Article =
    Article(
        title = title,
        description = description,
        url = url,
        urlToImage = urlToImage,
        publishedAt = publishedAt
    )