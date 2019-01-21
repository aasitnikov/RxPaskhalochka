package com.example.alexander.rxview.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alexander.rxview.Event

class MvvmViewModel : ViewModel(), MvvmContract.ViewModel {

    override val count = MutableLiveData(0)
    override val showMessage = MutableLiveData<Event<Int>>()

    override fun onAddClicked() {
        val newValue = count.value!! + 1

        count.value = newValue
        if (newValue % 10 == 0) {
            showMessage.value = Event(newValue)
        }
    }
}
