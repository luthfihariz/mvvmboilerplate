package com.luthfihariz.indigo.di

import com.luthfihariz.indigo.common.rx.BaseSchedulerProvider
import com.luthfihariz.indigo.common.rx.SchedulerProvider
import org.koin.dsl.module.applicationContext

val appModule = applicationContext {

    bean { SchedulerProvider() as BaseSchedulerProvider } // rx testing purpose


}