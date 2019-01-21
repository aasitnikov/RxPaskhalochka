package com.example.alexander.rxview.rxmp

import com.example.alexander.rxview.base.BaseRxPmFragment
import com.jakewharton.rxbinding3.view.clicks

class RxPmFragment : BaseRxPmFragment<RxPmPresentationModel>() {

    override fun providePresentationModel() = RxPmPresentationModel()

    override fun onBindPresentationModel(pm: RxPmPresentationModel) {
        pm.count bindTo { counter.text = it.toString() }
        pm.showMessage bindTo this::showSnackbar

        button.clicks() bindTo pm.onAddClick
    }

    companion object {
        @JvmStatic
        fun newInstance() = RxPmFragment()
    }
}