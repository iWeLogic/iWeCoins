package com.iwelogic.coins_presentation.ui.details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.iwelogic.coins_presentation.databinding.FragmentCoinDetailsBinding
import com.iwelogic.coins_presentation.models.Coin
import com.iwelogic.core.VALUE
import com.iwelogic.core.base.mvvm.BaseFragment
import com.iwelogic.core.utils.parcelable

const val COIN_DETAILS_FRAGMENT_ROUTE = "coinDetailsFragment"

class CoinDetailsFragment : BaseFragment<CoinsDetailsViewModel>() {

    private lateinit var binding: FragmentCoinDetailsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentCoinDetailsBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[CoinsDetailsViewModel::class.java]
        val coin = requireArguments().parcelable<Coin>(VALUE)
        Log.w("myLog", "onCreateView: " + coin?.name)
        return binding.root
    }
}
