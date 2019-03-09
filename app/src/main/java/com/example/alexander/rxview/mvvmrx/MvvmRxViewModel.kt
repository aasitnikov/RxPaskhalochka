package com.example.alexander.rxview.mvvmrx

import androidx.lifecycle.ViewModel
import com.example.alexander.rxview.Event
import com.example.alexander.rxview.rxmp.withLatestFrom
import com.jakewharton.rxrelay2.BehaviorRelay
import com.jakewharton.rxrelay2.PublishRelay
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class MvvmRxViewModel : ViewModel(), MvvmRxContract.ViewModel {

    override val count = BehaviorRelay.createDefault(0).toSerialized()
    override val showMessage = BehaviorRelay.create<Event<Int>>().toSerialized()

    override val onAddAction = PublishRelay.create<Unit>()

    init {
/**/        onAddAction.withLastFrom(count)
            .map { it + 1 }
            .doAfterNext { newCount ->
                if (newCount % 10 == 0) {
                    showMessage.accept(Event(newCount))
                }
            }
            .subscribe(count)
            .untilDestroy()
    }

    private val compositeDisposable = CompositeDisposable()

    private fun Disposable.untilDestroy() = compositeDisposable.add(this)

    private fun <T> Observable<*>.withLastFrom(from: Observable<T>): Observable<T> {
        return withLatestFrom(from) { _, c -> c }
    }
}