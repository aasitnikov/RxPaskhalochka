package com.example.alexander.rxview.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alexander.rxview.Event
import com.example.alexander.rxview.async.NumberService
import com.example.alexander.rxview.async.myBindProgress

class MvvmViewModel : ViewModel(), MvvmContract.ViewModel {

    override val count = MutableLiveData(0)
    override val showMessage = MutableLiveData<Event<Int>>()
    override val buttonDisabled = MutableLiveData(false)

    override fun onAddClicked() {
        val newValue = count.value!! + 1

        count.value = newValue
        if (newValue % 10 == 0) {
            showMessage.value = Event(newValue)
        }
    }

    override fun onFetchClicked() {
        NumberService.downloadNumber()
            .myBindProgress(buttonDisabled::postValue)
            .subscribe(count::postValue) //TODO: handle Disposable
    }
}
