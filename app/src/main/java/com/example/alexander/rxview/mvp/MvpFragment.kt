package com.example.alexander.rxview.mvp

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.alexander.rxview.base.BaseMoxyFragment

class MvpFragment : BaseMoxyFragment(), MvpContractView {

    @InjectPresenter
    lateinit var presenter: MvpPresenter2

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindListeners()
    }

    private fun bindListeners() {
        button.setOnClickListener { presenter.onAddClicked() }
        fetch.setOnClickListener { presenter.onFetch() }
    }

    override fun showCount(count: Int) = counter.setText(count.toString())
    override fun showMessage(count: Int) = showSnackbar(count)

    override fun enableButton(isProgress: Boolean) {
        button.isEnabled = isProgress
    }

    companion object {
        @JvmStatic
        fun newInstance() = MvpFragment()
    }
}