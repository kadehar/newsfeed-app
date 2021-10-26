package com.github.kadehar.newsfeed.features.news_screen.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.kadehar.newsfeed.base.utils.drawImageTo
import com.github.kadehar.newsfeed.base.utils.formatDate
import com.github.kadehar.newsfeed.databinding.ArticleItemBinding
import com.github.kadehar.newsfeed.features.news_screen.domain.model.Article

class ArticlesAdapter(private var articles: List<Article>) :
    RecyclerView.Adapter<ArticlesAdapter.ArticlesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        val binding = ArticleItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ArticlesViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        val article = articles[position]
        holder.bind(article = article)
    }

    override fun getItemCount(): Int = articles.size

    inner class ArticlesViewHolder(private val binding: ArticleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.apply {
                drawImageTo(
                    parent = itemView,
                    imageUrl = article.urlToImage,
                    toView = articlePhoto
                )

                articleTitle.text = article.title
                articleDescription.text = article.description ?: ""
                articlePublishedAt.text = formatDate(article.publishedAt)
            }
        }
    }

    fun updateList(newArticles: List<Article>) {
        val diffCallback = ArticlesDiffCallback(
            oldArticles = articles,
            newArticles = newArticles
        )
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        diffResult.dispatchUpdatesTo(this)

        articles = newArticles
    }
}