package com.github.kadehar.newsfeed.features.news_screen.ui

import com.github.kadehar.newsfeed.base.events.Event
import com.github.kadehar.newsfeed.base.vm.BaseViewModel
import com.github.kadehar.newsfeed.features.news_screen.domain.NewsScreenInteractor

class NewsScreenViewModel(private val newsInteractor: NewsScreenInteractor) :
    BaseViewModel<NewsViewState>() {

    init {
        processUiEvent(NewsScreenUIEvent.OnFetchingNews)
    }

    override fun initialViewState(): NewsViewState =
        NewsViewState(
            articles = emptyList(),
            isLoading = false,
            errorMessage = null
        )

    override suspend fun reduce(event: Event, previousState: NewsViewState): NewsViewState? {
        when (event) {
            is NewsScreenUIEvent.OnFetchingNews -> {
                processDataEvent(NewsScreenDataEvent.OnLoadingData)
                newsInteractor.topHeadlinesNews().fold(
                    onError = { error ->
                        processDataEvent(
                            NewsScreenDataEvent.UnsuccessfulNewsRequest(
                                error.localizedMessage ?: ""
                            )
                        )
                    },
                    onSuccess = { articles ->
                        processDataEvent(NewsScreenDataEvent.SuccessfulNewsRequest(articles))
                    }
                )
            }
            is NewsScreenDataEvent.OnLoadingData -> {
                return previousState.copy(isLoading = true)
            }
            is NewsScreenDataEvent.SuccessfulNewsRequest -> {
                return previousState.copy(
                    articles = event.articles,
                    isLoading = false,
                    errorMessage = null
                )
            }
            is NewsScreenDataEvent.UnsuccessfulNewsRequest -> {
                return previousState.copy(
                    isLoading = false,
                    errorMessage = event.errorMessage
                )
            }
        }
        return null
    }
}