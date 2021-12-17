package com.kailin.sockettesting.connect

import com.kailin.sockettesting.data.AggTrades
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AggTradesService {

    @GET("api/v1/aggTrades")
    suspend fun getTreades(
        @Query("symbol") symbol: String = "",
        @Query("limit") limit: Int = 1
    ): Response<MutableList<AggTrades>>

}