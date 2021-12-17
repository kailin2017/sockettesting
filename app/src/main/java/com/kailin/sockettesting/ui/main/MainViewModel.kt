package com.kailin.sockettesting.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kailin.sockettesting.BuildConfig
import com.kailin.sockettesting.connect.AggTradesService
import com.kailin.sockettesting.connect.RetrofitHelper
import com.kailin.sockettesting.connect.SocketHelper
import com.kailin.sockettesting.data.AggTrades
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val aggTradesLiveData = MutableLiveData<MutableList<AggTrades>>()
    val socketHelper =
        SocketHelper("wss://stream.yshyqxx.com/ws/btcusdt@aggTrade", AggTrades::class.java) {
            aggTradesLiveData.postValue(it)
        }

    fun loadData() {
        GlobalScope.launch {
            val service = RetrofitHelper.instance.createService(AggTradesService::class.java)
            val response = service.getTreades("BTCUSDT", BuildConfig.RESPONSE_LITMIT)
            val data = response.body()
            data?.let {
                it.sortByDescending { itt -> itt.T }
                aggTradesLiveData.postValue(it)
            }
            socketHelper.connectSocket()
        }
    }

    fun stop() {
        socketHelper.cancel()
    }

}