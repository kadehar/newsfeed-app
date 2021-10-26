package com.github.kadehar.newsfeed.features.news_screen.data.api

import com.github.kadehar.newsfeed.features.news_screen.domain.model.Article

interface NewsRepository {
    suspend fun topHeadlinesNews(): List<Article>
}