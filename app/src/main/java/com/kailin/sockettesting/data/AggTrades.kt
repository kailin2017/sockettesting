package com.kailin.sockettesting.data

import com.google.gson.annotations.SerializedName

/*
RESTful Data
[
{
"a": 26129,         // 归集成交ID
"p": "0.01633102",  // 成交价
"q": "4.70443515",  // 成交量
"f": 27781,         // 被归集的首个成交ID
"l": 27781,         // 被归集的末个成交ID
"T": 1498793709153, // 成交时间
"m": true,          // 是否为主动卖出单
"M": true           // 是否为最优撮合单(可忽略，目前总为最优撮合)
}]

Socket Data
{
  "e": "aggTrade",  // 事件类型
  "E": 123456789,   // 事件时间
  "s": "BNBBTC",    // 交易对
  "a": 12345,       // 归集交易ID
  "p": "0.001",     // 成交价格
  "q": "100",       // 成交数量
  "f": 100,         // 被归集的首个交易ID
  "l": 105,         // 被归集的末次交易ID
  "T": 123456785,   // 成交时间
  "m": true,        // 买方是否是做市方。如true，则此次成交是一个主动卖出单，否则是一个主动买入单。
  "M": true         // 请忽略该字段
}

 */
data class AggTrades(
    @SerializedName("e") val e: String,
    @SerializedName("E") val eTime: Long,
    @SerializedName("s") val s: String,
    @SerializedName("a") val a: Long,
    @SerializedName("p") val p: String,
    @SerializedName("q") val q: String,
    @SerializedName("f") val f: Long,
    @SerializedName("l") val l: Long,
    @SerializedName("T") val T: Long,
    @SerializedName("m") val m: Boolean,
    @SerializedName("M") val MM: Boolean
)