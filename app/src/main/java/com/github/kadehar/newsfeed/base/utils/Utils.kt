package com.github.kadehar.newsfeed.base.utils

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

inline fun <reified T> attempt(func: () -> T): Either<Throwable, T> = try {
    Either.Right(func.invoke())
} catch (e: Throwable) {
    Either.Left(e)
}

fun openUrl(context: Context, url: String) {
    val builder = CustomTabsIntent.Builder()
    builder.setShowTitle(true)
    val customTabsIntent = builder.build()
    customTabsIntent.launchUrl(context, Uri.parse(url))
}

fun formatDate(date: String): String {
    val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ROOT)
    val formatter = SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.ROOT)
    return try {
        formatter.format(parser.parse(date) ?: "")
    } catch (e: ParseException) {
        date
    }
}

/*
fun mapToList(
    oldList: List<NewsDomainModel>,
    newList: List<NewsDomainModel>
): List<NewsDomainModel> {
    return oldList.map { article ->
        article.copy(isBookmarked = newList.map { it.url }.contains(article.url))
    }
}*/
