package com.luthfihariz.indigo.di

import android.util.Log
import com.luthfihariz.indigo.data.remote.ApiService
import com.google.gson.GsonBuilder
import com.luthfihariz.indigo.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single("logging") {
        HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message ->
            Log.d("ApiLog", message)
        }).setLevel(HttpLoggingInterceptor.Level.BODY) as Interceptor
    }

    single {
        OkHttpClient.Builder()
                .addInterceptor(get("logging"))
                .readTimeout(120, TimeUnit.SECONDS)
                .connectTimeout(120, TimeUnit.SECONDS)
                .build()
    }

    single {
        val gson = GsonBuilder().setLenient().create()


        Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(get() as OkHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService::class.java)
    }
}