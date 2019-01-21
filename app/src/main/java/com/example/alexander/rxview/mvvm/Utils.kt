package com.example.alexander.rxview.mvvm

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T> LifecycleOwner.bind(count: LiveData<T>, function: (T) -> Unit) {
    count.observe(this, Observer {
        it?.let(function)
    })
}