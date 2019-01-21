package com.example.alexander.rxview.mvvm

import androidx.lifecycle.LiveData
import com.example.alexander.rxview.Event

interface MvvmContract {
    interface View

    interface ViewModel {
        val count: LiveData<Int>
        val showMessage: LiveData<Event<Int>>

        fun onAddClicked()
    }
}