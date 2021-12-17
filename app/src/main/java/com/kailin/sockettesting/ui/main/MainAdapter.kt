package com.kailin.sockettesting.ui.main

import android.graphics.Color
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kailin.sockettesting.BuildConfig
import com.kailin.sockettesting.data.AggTrades
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private val data: MutableList<AggTrades> = ArrayList()
    private val dateFormat = SimpleDateFormat("HH:mm:ss.sss")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(MainItemView(parent.context))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder.itemView !is MainItemView) {
            return
        }
        val aggTrades = data[position]
        holder.itemView.setTimeString(dateFormat.format(Date(aggTrades.T)))
        holder.itemView.setPriceText(aggTrades.p)
        holder.itemView.setPriceTextColor(
            if (aggTrades.m) {
                Color.RED
            } else {
                Color.GREEN
            }
        )
        holder.itemView.setCountText(aggTrades.q)
    }

    override fun getItemCount() = data.size.coerceAtMost(BuildConfig.RESPONSE_LITMIT)

    fun updateData(newData: MutableList<AggTrades>) {
//        val result = DiffUtil.calculateDiff(MyDiffCallback(data, newData))
        if (newData.size >= BuildConfig.RESPONSE_LITMIT) {
            data.clear()
        }
        data.addAll(newData)
        notifyDataSetChanged()
//        result.dispatchUpdatesTo(this)
    }

    class ViewHolder(view: MainItemView) : RecyclerView.ViewHolder(view) {
    }
}