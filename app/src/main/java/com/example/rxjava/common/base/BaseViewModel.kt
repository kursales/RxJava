package com.example.rxjava.common.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.error.ApplicationError
import com.example.rxjava.util.livedata.Event
import io.reactivex.disposables.CompositeDisposable
import kotlin.coroutines.CoroutineContext

open class BaseViewModel : ViewModel() {

protected val subscriptions = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        subscriptions.dispose()
    }
}