package com.iwelogic.coins_presentation.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.iwelogic.coins_presentation.databinding.FragmentCoinsBinding
import com.iwelogic.coins_presentation.ui.details.COIN_DETAILS_FRAGMENT_ROUTE
import com.iwelogic.core.VALUE
import com.iwelogic.core.base.mvvm.BaseFragment
import com.iwelogic.core.utils.navigate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoinsFragment : BaseFragment<CoinsViewModel>() {

    private lateinit var binding: FragmentCoinsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentCoinsBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[CoinsViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
        lifecycleScope.launchWhenCreated {
            viewModel.coins.collect {
                (binding.list.adapter as CoinAdapter).submitList(it)
            }
        }

        lifecycleScope.launchWhenCreated {
            viewModel.openDetails.collect { item ->
                parentFragment?.parentFragment?.findNavController()?.navigate(
                    route = COIN_DETAILS_FRAGMENT_ROUTE,
                    args = bundleOf(VALUE to item)
                )
            }
        }
    }

    private fun initUi() {
        binding.list.adapter = CoinAdapter {
            viewModel.onClickCoin(it)
        }

        binding.swipeRefresh.setOnRefreshListener {
            viewModel.onReload()
        }
    }
}
