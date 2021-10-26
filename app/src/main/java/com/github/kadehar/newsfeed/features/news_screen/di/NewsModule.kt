package com.github.kadehar.newsfeed.features.news_screen.di

import com.github.kadehar.newsfeed.features.news_screen.data.api.NewsApi
import com.github.kadehar.newsfeed.features.news_screen.data.api.NewsRemoteSource
import com.github.kadehar.newsfeed.features.news_screen.data.api.NewsRepository
import com.github.kadehar.newsfeed.features.news_screen.data.api.NewsRepositoryImpl
import com.github.kadehar.newsfeed.features.news_screen.domain.NewsScreenInteractor
import com.github.kadehar.newsfeed.features.news_screen.ui.NewsScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val newsModule = module {
    single<NewsApi> {
        get<Retrofit>().create(NewsApi::class.java)
    }

    single<NewsRemoteSource> {
        NewsRemoteSource(get<NewsApi>())
    }

    single<NewsRepository> {
        NewsRepositoryImpl(get<NewsRemoteSource>())
    }

    single<NewsScreenInteractor> {
        NewsScreenInteractor(get<NewsRepository>())
    }

    viewModel<NewsScreenViewModel> {
        NewsScreenViewModel(get<NewsScreenInteractor>())
    }
}