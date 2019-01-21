package com.example.alexander.rxview.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.alexander.rxview.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_base.*

abstract class BaseFragment : Fragment() {

    val counter: TextView get() = textView_counter
    val button: TextView get() = button_add

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_base, container, false)
    }

    fun showSnackbar(count: Int) {
        Snackbar.make(view!!, "Congrats, you clicked $count times", Snackbar.LENGTH_SHORT).show()
    }
}
