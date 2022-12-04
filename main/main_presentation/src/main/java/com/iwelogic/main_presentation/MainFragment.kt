package com.iwelogic.main_presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.iwelogic.core.base.mvvm.BaseFragment
import com.iwelogic.main_presentation.databinding.FragmentMainBinding

class MainFragment : BaseFragment<MainViewModel>() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = (childFragmentManager.findFragmentById(R.id.bottomNavigationContainer) as NavHostFragment).navController
        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController)
    }
}
