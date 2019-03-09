package com.example.alexander.rxview.mvvmrx

import com.example.alexander.rxview.Event
import io.reactivex.Observable
import io.reactivex.functions.Consumer

interface MvvmRxContract {
    interface View

    interface ViewModel {
        val count: Observable<Int>
        val showMessage: Observable<Event<Int>>

        val onAddAction: Consumer<Unit>
    }
}