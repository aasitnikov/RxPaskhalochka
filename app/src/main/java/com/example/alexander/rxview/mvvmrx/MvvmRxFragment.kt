package com.example.alexander.rxview.mvvmrx

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.alexander.rxview.base.BaseFragment
import com.jakewharton.rxbinding2.view.clicks
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer

class MvvmRxFragment : BaseFragment() {

    private lateinit var viewModel: MvvmRxContract.ViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MvvmRxViewModel::class.java)
        bindViewModel()
    }

    private fun bindViewModel() {
        viewModel.count bindTo { count -> counter.text = count.toString() }
        viewModel.showMessage bindTo { it.getContentIfNotHandled()?.let(this::showSnackbar) }

        button.clicks() bindTo viewModel.onAddAction
    }

    private infix fun <T> Observable<T>.bindTo(function: (T) -> Unit) {
        this.subscribe(function).also { compositeDisposable.add(it) }
    }

    private infix fun <T> Observable<T>.bindTo(function: Consumer<T>) {
        this.subscribe(function).also { compositeDisposable.add(it) }
    }

    private val compositeDisposable = CompositeDisposable()

    override fun onDestroyView() {
        super.onDestroyView()
        compositeDisposable.dispose()
    }

    companion object {
        @JvmStatic
        fun newInstance() = MvvmRxFragment()
    }
}


