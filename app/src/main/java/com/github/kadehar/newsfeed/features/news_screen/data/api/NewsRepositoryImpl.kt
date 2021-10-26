package com.github.kadehar.newsfeed.features.news_screen.data.api

import com.github.kadehar.newsfeed.features.news_screen.data.toDomainModel
import com.github.kadehar.newsfeed.features.news_screen.domain.model.Article

class NewsRepositoryImpl(private val source: NewsRemoteSource) : NewsRepository {
    override suspend fun topHeadlinesNews(): List<Article> =
        source.topHeadlinesNews().articles.map { it.toDomainModel() }
}