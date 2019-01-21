package com.example.alexander.rxview.mvp

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

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
}