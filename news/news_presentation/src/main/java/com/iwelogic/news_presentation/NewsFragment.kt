package com.iwelogic.news_presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.iwelogic.core.base.mvvm.BaseFragment
import com.iwelogic.news_presentation.databinding.FragmentNewsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : BaseFragment<NewsViewModel>() {

    private lateinit var binding: FragmentNewsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentNewsBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[NewsViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
        lifecycleScope.launchWhenCreated {
            viewModel.news.collect {
                (binding.list.adapter as NewsAdapter).submitList(it)
            }
        }
    }

    private fun initUi() {
        binding.list.adapter = NewsAdapter {
            viewModel.onClickCoin(it)
        }

        binding.swipeRefresh.setOnRefreshListener {
            viewModel.onReload()
        }
    }
}
