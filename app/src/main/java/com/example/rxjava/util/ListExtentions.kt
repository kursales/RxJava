package com.example.rxjava.util

import androidx.lifecycle.ViewModel

fun <T> Collection<T>.toArrayList(): ArrayList<T> {
    return if (this is ArrayList) {
        this
    } else {
        ArrayList(this)
    }
}