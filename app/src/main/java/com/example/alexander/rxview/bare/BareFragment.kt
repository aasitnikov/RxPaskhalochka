package com.example.alexander.rxview.bare

import android.os.Bundle
import android.view.View
import com.example.alexander.rxview.base.BaseFragment

class BareFragment : BaseFragment() {

    private var count: Int = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        showCountText()
        button.setOnClickListener {
            count++
            showCountText()
            if (count % 10 == 0) showSnackbar(count)
        }
    }

    private fun showCountText() {
        counter.text = count.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("count", count)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        count = (savedInstanceState ?: return).getInt("count")
        showCountText()
    }

    companion object {
        fun newInstance() = BareFragment()
    }
}