package com.github.kadehar.newsfeed.base.utils

import android.view.View
import com.github.kadehar.newsfeed.base.consts.Constants.DEFAULT_THROTTLE_DELAY

fun View.setThrottledClickListener(
    delay: Long = DEFAULT_THROTTLE_DELAY,
    onClick: (View) -> Unit
) {
    setOnClickListener {
        throttle(delay) {
            onClick(it)
        }
    }
}

private var lastClickTimestamp = 0L
fun View.throttle(
    delay: Long = DEFAULT_THROTTLE_DELAY,
    action: () -> Unit
): Boolean {
    val currentTimestamp = System.currentTimeMillis()
    val delta = currentTimestamp - lastClickTimestamp
    if (delta !in 0L..delay) {
        lastClickTimestamp = currentTimestamp
        action()
        return true
    }
    return false
}