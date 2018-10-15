package com.luthfihariz.indigo.di

import com.luthfihariz.indigo.common.rx.BaseSchedulerProvider
import com.luthfihariz.indigo.common.rx.SchedulerProvider
import org.koin.dsl.module.module

val appModule = module {

    single { SchedulerProvider() as BaseSchedulerProvider } // rx testing purpose


}