package com.github.kadehar.newsfeed.features.news_screen.data.api

import com.github.kadehar.newsfeed.features.news_screen.data.api.model.ArticlesRemoteModel

class NewsRemoteSource(private val api: NewsApi) {
    suspend fun topHeadlinesNews(): ArticlesRemoteModel = api.topHeadlinesNews()
}