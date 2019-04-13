package com.luthfihariz.indigo.common.extension

import com.luthfihariz.indigo.common.rx.BaseSchedulerProvider
import io.reactivex.Observable
import io.reactivex.Single

fun <T> Single<T>.executeIo(scheduler: BaseSchedulerProvider) : Single<T>{
    return subscribeOn(scheduler.io()).observeOn(scheduler.ui())
}

fun <T> Observable<T>.executeIo(scheduler: BaseSchedulerProvider) : Observable<T>{
    return subscribeOn(scheduler.io()).observeOn(scheduler.ui())
}