package com.github.kadehar.newsfeed.features.news_screen.data.api

import com.github.kadehar.newsfeed.base.consts.Constants.NEWS_API_BASE_PATH
import com.github.kadehar.newsfeed.features.news_screen.data.api.model.ArticlesRemoteModel
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface NewsApi {
    @GET(NEWS_API_BASE_PATH)
    suspend fun topHeadlinesNews(
        @Query("country") country: String = Locale.getDefault().country
    ) : ArticlesRemoteModel
}