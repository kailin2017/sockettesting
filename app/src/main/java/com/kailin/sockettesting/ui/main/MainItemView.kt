package com.kailin.sockettesting.ui.main

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.annotation.ColorInt
import com.kailin.sockettesting.R
import kotlinx.android.synthetic.main.main_item.view.*

class MainItemView : FrameLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        inflate(context, R.layout.main_item, this)
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    fun setTimeString(text: String) {
        timeText.text = text
    }

    fun setPriceText(text: String) {
        priceText.text = text
    }

    fun setPriceTextColor(@ColorInt color: Int) {
        priceText.setTextColor(color)
    }

    fun setCountText(text: String) {
        countText.text = text
    }
}