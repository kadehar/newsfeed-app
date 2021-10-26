package com.github.kadehar.newsfeed.features.news_screen.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.github.kadehar.newsfeed.features.news_screen.domain.model.Article

class ArticlesDiffCallback(
    private val oldArticles: List<Article>,
    private val newArticles: List<Article>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldArticles.size

    override fun getNewListSize(): Int = newArticles.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldArticles[oldItemPosition] == newArticles[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldArticles[oldItemPosition] == newArticles[newItemPosition]
}