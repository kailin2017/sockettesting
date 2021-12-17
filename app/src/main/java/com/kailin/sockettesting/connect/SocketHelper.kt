package com.kailin.sockettesting.connect

import com.google.gson.Gson
import com.kailin.sockettesting.BuildConfig
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okio.ByteString
import java.util.*
import kotlin.collections.ArrayList

class SocketHelper<T> constructor(
    private val url: String = "",
    private val clazz: Class<T>,
    private val callback: (MutableList<T>) -> Unit,
) {

    private var socket: WebSocket? = null
    private val data: MutableList<T> = ArrayList()

    private val listener = object : WebSocketListener() {

        private val gson = Gson()

        override fun onOpen(webSocket: WebSocket, response: Response) {
            super.onOpen(webSocket, response)
        }

        override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
            super.onFailure(webSocket, t, response)
        }

        override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
            super.onMessage(webSocket, bytes)
        }

        override fun onMessage(webSocket: WebSocket, text: String) {
            super.onMessage(webSocket, text)
            data.add(0, gson.fromJson(text, clazz))
            if (data.size > BuildConfig.RESPONSE_LITMIT) {
                data.removeLast()
            }
        }

        override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
            super.onClosing(webSocket, code, reason)
        }

        override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
            super.onClosed(webSocket, code, reason)
        }
    }

    fun connectSocket() {
        val request = Request.Builder()
            .url(url)
            .build()
        socket = OkHttpHelper.instance.httpClient.newWebSocket(request, listener)

        Timer().schedule(object : TimerTask() {
            override fun run() {
                callback(data)
            }
        }, BuildConfig.RESPONSE_UPDATE_SEC)
    }

    fun cancel() {
        socket?.cancel()
    }

    companion object {

        val tag = SocketHelper::class.simpleName
    }
}