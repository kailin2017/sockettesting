package com.kailin.sockettesting.connect

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper private constructor(){

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.yshyqxx.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpHelper.instance.httpClient)
        .build()

    fun <T> createService(clazz: Class<T>): T = retrofit.create(clazz)

    companion object {

        val instance: RetrofitHelper by lazy { RetrofitHelper() }
    }
}