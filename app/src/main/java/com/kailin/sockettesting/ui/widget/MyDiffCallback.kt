package com.kailin.sockettesting.ui.widget

import androidx.recyclerview.widget.DiffUtil
import java.util.*

class MyDiffCallback<T>(private val oldData: List<T>, private val newData: List<T>) :
    DiffUtil.Callback() {

    override fun getOldListSize() = oldData.size

    override fun getNewListSize() = newData.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return areContentsTheSame(oldItemPosition, newItemPosition)
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldT = oldData[oldItemPosition]
        val newT = newData[newItemPosition]
        return Objects.equals(oldT, newT)
    }
}