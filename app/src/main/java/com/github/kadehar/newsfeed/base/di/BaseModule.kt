package com.github.kadehar.newsfeed.base.di

import com.github.kadehar.newsfeed.base.consts.Constants.NEWS_API_BASE_URL
import com.github.kadehar.newsfeed.base.consts.Constants.NEWS_API_TOKEN
import com.github.kadehar.newsfeed.base.interceptors.AuthInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val baseModule = module {
    single<OkHttpClient> {
        val auth = AuthInterceptor(NEWS_API_TOKEN)
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor(auth)
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(NEWS_API_BASE_URL)
            .client(get<OkHttpClient>())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}