package com.example.alexander.rxview.rxmp

import com.example.alexander.rxview.base.BaseRxPmFragment
import com.jakewharton.rxbinding3.view.clicks

class RxPmFragment : BaseRxPmFragment<RxPmPresentationModel>() {

    override fun providePresentationModel() = RxPmPresentationModel()

    override fun onBindPresentationModel(pm: RxPmPresentationModel) {
        pm.count bindTo { counter.text = it.toString() }
        pm.buttonDisabled bindTo { button.isEnabled = !it }
        pm.showMessage bindTo this::showSnackbar

        button.clicks() bindTo pm.onAddClick
        fetch.clicks() bindTo pm.onFetchClick
    }

    companion object {
        @JvmStatic
        fun newInstance() = RxPmFragment()
    }
}