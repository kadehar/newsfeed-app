package com.github.kadehar.newsfeed.features.news_screen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.kadehar.newsfeed.databinding.FragmentNewsScreenBinding
import com.github.kadehar.newsfeed.features.news_screen.ui.adapter.ArticlesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsScreenFragment : Fragment() {
    private var _binding: FragmentNewsScreenBinding? = null
    private val binding get() = _binding!!

    private val newsScreenViewModel by viewModel<NewsScreenViewModel>()
    private val articlesAdapter: ArticlesAdapter by lazy {
        ArticlesAdapter(articles = emptyList())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.newsScreenArticles.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = articlesAdapter
        }

        newsScreenViewModel.viewState.observe(viewLifecycleOwner, ::render)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun render(newsViewState: NewsViewState) {
        binding.newsScreenProgressBar.isGone = !newsViewState.isLoading
        binding.errorTextView.apply {
            isGone = !newsViewState.isInErrorState
            text = newsViewState.errorMessage
        }
        articlesAdapter.updateList(newsViewState.articles)
    }
}