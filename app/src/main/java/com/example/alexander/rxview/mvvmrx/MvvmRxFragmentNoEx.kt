package com.example.alexander.rxview.mvvmrx

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.alexander.rxview.base.BaseFragment
import com.jakewharton.rxbinding2.view.clicks
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class MvvmRxFragmentNoEx : BaseFragment() {

    private lateinit var viewModel: MvvmRxContract.ViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MvvmRxViewModel::class.java)
        bindViewModel()
    }

    private fun bindViewModel() {
        viewModel.count
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { count -> counter.text = count.toString() }
            .untilDestroy()

        viewModel.showMessage
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { it.getContentIfNotHandled()?.let(this::showSnackbar) }
            .untilDestroy()

        button.clicks()
            .subscribe(viewModel.onAddAction)
            .untilDestroy()
    }

    private val compositeDisposable = CompositeDisposable()

    override fun onDestroyView() {
        super.onDestroyView()
        compositeDisposable.dispose()
    }

    private fun Disposable.untilDestroy() = compositeDisposable.add(this)

    companion object {
        @JvmStatic
        fun newInstance() = MvvmRxFragmentNoEx()
    }
}


