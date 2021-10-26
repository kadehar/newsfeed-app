package com.github.kadehar.newsfeed.features.news_screen.domain

import com.github.kadehar.newsfeed.base.utils.attempt
import com.github.kadehar.newsfeed.features.news_screen.data.api.NewsRepository

class NewsScreenInteractor(private val newsRepository: NewsRepository) {
    suspend fun topHeadlinesNews() = attempt {
        newsRepository.topHeadlinesNews()
    }
}