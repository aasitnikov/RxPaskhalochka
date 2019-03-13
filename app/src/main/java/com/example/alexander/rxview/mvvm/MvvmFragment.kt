package com.example.alexander.rxview.mvvm

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.alexander.rxview.base.BaseFragment

class MvvmFragment : BaseFragment() {

    private lateinit var viewModel: MvvmContract.ViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MvvmViewModel::class.java)
        bindViewModel()
    }

    private fun bindViewModel() {
        bind(viewModel.count) { count -> counter.text = count.toString() }
        bind(viewModel.showMessage) { it.getContentIfNotHandled()?.let(this::showSnackbar) }
        bind(viewModel.buttonDisabled) { isDisabled -> button.isEnabled = !isDisabled }

        button.setOnClickListener { viewModel.onAddClicked() }
        fetch.setOnClickListener { viewModel.onFetchClicked() }
    }

    companion object {
        @JvmStatic
        fun newInstance() = MvvmFragment()
    }
}


