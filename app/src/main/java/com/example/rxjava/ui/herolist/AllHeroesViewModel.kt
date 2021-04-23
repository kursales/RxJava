package com.example.rxjava.ui.herolist

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.example.domain.interactors.HeroInteractor
import com.example.domain.model.dto.Hero
import com.example.rxjava.common.base.BaseViewModel
import com.example.rxjava.util.RxJava.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AllHeroesViewModel @Inject constructor(
    private val interactor: HeroInteractor
) : BaseViewModel() {
    val heroList = MutableLiveData<List<Hero>>()


    fun downloadHeroes() {
        interactor.getHeroes()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe({
                heroList.value = it
            }, {
                it.printStackTrace()
            }).addTo(subscriptions)
    }
}