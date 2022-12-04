package com.iwelogic.core.base.mvvm

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.iwelogic.core.R

open class BaseFragment<VM : BaseViewModel> : Fragment() {

    lateinit var viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenCreated {
            viewModel.toast.collect { message ->
                Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
            }
        }

        lifecycleScope.launchWhenCreated {
            viewModel.close.collect {
                findNavController().popBackStack()
            }
        }

        lifecycleScope.launchWhenCreated {
            viewModel.progress.collect { status ->
                view.findViewById<View>(R.id.progress)?.apply {
                    visibility = if (status) View.VISIBLE else View.GONE
                }
            }
        }

        lifecycleScope.launchWhenCreated {
            viewModel.error.collect { errorMessage ->
                view.findViewById<View>(R.id.error)?.apply {
                    visibility = if (errorMessage.isNullOrEmpty()) View.GONE else View.VISIBLE
                }
                view.findViewById<TextView>(R.id.errorTxt)?.text = errorMessage ?: context?.getString(R.string.something_went_wrong)
                view.findViewById<View>(R.id.reloadBtn)?.setOnClickListener {
                    viewModel.onReload()
                }
            }
        }
    }
}