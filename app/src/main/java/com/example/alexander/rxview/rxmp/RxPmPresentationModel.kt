package com.example.alexander.rxview.rxmp

import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import me.dmdev.rxpm.PresentationModel

class RxPmPresentationModel : PresentationModel(), RxPmContract.PresentationModel2 {

    override val count: State<Int> = State(0)
    override val showMessage: Command<Int> = Command()

    override val onAddClick: Action<Unit> = Action()

    override fun onCreate() {
//        onAddClick.observable
//            .doOnNext {
//                val newCount = count.value + 1
//                count.consumer.accept(newCount)
//                if (newCount % 10 == 0) {
//                    showMessage.consumer.accept(newCount)
//                }
//            }
//            .subscribe()
//            .untilDestroy()

        //------------

        onAddClick.observable
            .withLatestFrom(count.observable) { _, count -> count }
            .subscribe { count ->
                val newCount = count + 1
                this.count.consumer.accept(newCount)
                if (newCount % 10 == 0) {
                    showMessage.consumer.accept(newCount)
                }
            }
            .untilDestroy()

        //------------

//        onAddClick.observable
//            .map { count.value + 1 }
//            .subscribe { newCount ->
//                count.consumer.accept(newCount)
//                if (newCount % 10 == 0) {
//                    showMessage.consumer.accept(newCount)
//                }
//            }
//            .untilDestroy()

        //------------

//        onAddClick.observable
//            .map { count.value + 1 }
//            .doAfterNext { newCount ->
//                if (newCount % 10 == 0) {
//                    showMessage.consumer.accept(newCount)
//                }
//            }
//            .subscribe(count.consumer)
//            .untilDestroy()

//------------

//        onAddClick.observable
//            .map { count.value + 1 }
//            .subscribe(count.consumer)
//            .untilDestroy()
//
//        count.observable
//            .skip(1)
//            .filter { it % 10 == 0 }
//            .subscribe(showMessage.consumer)
//            .untilDestroy()

        //---------------

//        onAddClick.observable
//            .withLatestFrom(count.observable) { _, count -> count }
//            .map { it + 1 }
//            .subscribe(count.consumer)
//            .untilDestroy()
//
//        count.observable
//            .skip(1)
//            .filter { it % 10 == 0 }
//            .subscribe(showMessage.consumer)
//            .untilDestroy()
    }
}

fun <T, R, U> Observable<T>.withLatestFrom(
    other: Observable<R>,
    combiner: (T, R) -> U
): Observable<U> {
    return this.withLatestFrom(other, BiFunction { t1: T, t2: R -> combiner(t1, t2) })
}