package com.github.kadehar.newsfeed.features.news_screen.ui

import com.github.kadehar.newsfeed.base.events.Event
import com.github.kadehar.newsfeed.features.news_screen.domain.model.Article

data class NewsViewState(
    val articles: List<Article>,
    val isLoading: Boolean,
    val errorMessage: String?
) {
    val isInErrorState: Boolean = errorMessage != null
}

sealed class NewsScreenUIEvent : Event {
    object OnFetchingNews : NewsScreenUIEvent()
}

sealed class NewsScreenDataEvent : Event {
    object OnLoadingData : NewsScreenDataEvent()
    data class SuccessfulNewsRequest(val articles: List<Article>) : NewsScreenDataEvent()
    data class UnsuccessfulNewsRequest(val errorMessage: String) : NewsScreenDataEvent()
}