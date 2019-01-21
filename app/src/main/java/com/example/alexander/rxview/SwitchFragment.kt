package com.example.alexander.rxview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_switch.*

class SwitchFragment : Fragment() {

    private var navigation: Navigation? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_switch, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        navigation = activity as Navigation
    }

    override fun onDetach() {
        super.onDetach()
        navigation = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goto_mvp.setOnClickListener {
            navigation?.gotoMvp()
        }
        goto_mvvm.setOnClickListener {
            navigation?.gotoMvvm()
        }
        goto_rxpm.setOnClickListener {
            navigation?.gotoRx()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SwitchFragment()
    }
}