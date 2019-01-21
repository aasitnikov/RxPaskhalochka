package com.example.alexander.rxview.mvp

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

class MvpContract {
    interface Presenter {
        fun onAddClicked()
    }
}

interface MvpContractView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showCount(count: Int)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showMessage(count: Int)
}

