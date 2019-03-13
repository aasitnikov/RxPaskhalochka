package com.example.alexander.rxview.async

import io.reactivex.Single

fun <T : Any> Single<T>.myBindProgress(progress: (Boolean) -> Unit): Single<T> {
    return doOnSubscribe { progress(true) }
        .doAfterTerminate { progress(false) }
}