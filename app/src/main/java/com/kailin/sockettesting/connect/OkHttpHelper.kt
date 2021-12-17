package com.kailin.sockettesting.connect

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class OkHttpHelper private constructor() {

    val httpClient = OkHttpClient.Builder()
        .addNetworkInterceptor(HttpLoggingInterceptor())
        .build()

    companion object {

        val instance: OkHttpHelper by lazy { OkHttpHelper() }
    }
}