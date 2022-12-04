package com.iwelogic.main_presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
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
        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.itemIconTintList = null
        val navController = (childFragmentManager.findFragmentById(R.id.bottomNavigationContainer) as NavHostFragment).navController
        navController.addOnDestinationChangedListener { _, destination, _ ->
          /*  viewModel.title.postValue(
                when (destination.id) {
                    R.id.appsFragment -> view.context.getString(R.string.apps)
                    R.id.newsFragment -> view.context.getString(R.string.news)
                    R.id.feedbacksFragment -> view.context.getString(R.string.feedbacks)
                    else -> view.context.getString(R.string.info)
                }
            )*/
        }
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }
}
