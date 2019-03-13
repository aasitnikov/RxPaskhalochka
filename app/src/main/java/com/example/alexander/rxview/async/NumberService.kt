package com.example.alexander.rxview.async

import io.reactivex.Single
import java.util.concurrent.TimeUnit

object NumberService {
    fun downloadNumber(): Single<Int> {
        return Single.just((Math.random() * 100).toInt())
            .delay(2000, TimeUnit.MILLISECONDS)
    }
}