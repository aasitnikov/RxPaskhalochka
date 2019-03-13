package com.example.alexander.rxview.mvp

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.alexander.rxview.async.NumberService
import com.example.alexander.rxview.async.myBindProgress
import io.reactivex.android.schedulers.AndroidSchedulers

@InjectViewState
class MvpPresenter2 : MvpPresenter<MvpContractView>(), MvpContract.Presenter {

    private var count: Int = 0

    override fun onFirstViewAttach() {
        viewState.showCount(count)
    }

    override fun onAddClicked() {
        val newCount = ++count
        viewState.showCount(newCount)
        if (newCount % 10 == 0) {
            viewState.showMessage(newCount)
        }
    }

    override fun onFetch() {
        NumberService.downloadNumber()
            .observeOn(AndroidSchedulers.mainThread())
            .myBindProgress { isProgress -> viewState.enableButton(!isProgress) }
            .subscribe { number: Int ->
                count = number
                viewState.showCount(number)
            } //TODO: handle Disposable
    }
}