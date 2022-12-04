package com.iwelogic.coins_presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.iwelogic.coins_presentation.databinding.FragmentCoinsBinding
import com.iwelogic.core.base.mvvm.BaseFragment
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
    }
}
