package com.example.rxjava.ui.herolist

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.domain.interactors.HeroDbInteractor
import com.example.domain.interactors.HeroInteractor
import com.example.domain.model.dto.Hero
import com.example.rxjava.common.base.BaseViewModel
import com.example.rxjava.common.constants.FIRST_RUN
import com.example.rxjava.util.rxjava.addTo
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.io.File
import javax.inject.Inject

class AllHeroesViewModel @Inject constructor(
    private val interactor: HeroInteractor,
    private val dbInteractor: HeroDbInteractor,
    private val preferences: SharedPreferences,
    private val context: Context
) : BaseViewModel() {
    val heroList = MutableLiveData<List<Hero>>()
    val loading = MutableLiveData<Boolean>(false)


    private fun firstStartCheck(): Boolean = preferences.getBoolean(FIRST_RUN, true)

    fun onStarted() {
        loading.value = true
        if (firstStartCheck()) {
            val edit = preferences.edit()
            edit.putBoolean(FIRST_RUN, false)
            edit.apply()
            downloadHeroes()
        } else {
            getHeroesFromDb()
        }
    }


    private fun downloadHeroes() {
        interactor.getHeroes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                downloadIcon(it)
            }, {
                it.printStackTrace()
            }).addTo(subscriptions)
    }

    fun downloadHeroOnDb(hero: Hero) {
        dbInteractor.insertHero(hero)
            .subscribe({
            }, {
                it.printStackTrace()
            }).addTo(subscriptions)
    }

    private fun changeHeroList(list: List<Hero>) {
        heroList.value = list
        loading.value = false
    }


    private fun getHeroesFromDb() {

        dbInteractor.getHeroes()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                changeHeroList(it)
            }, {
                it.printStackTrace()
            }).addTo(subscriptions)
    }

    private fun downloadIcon(heroList: List<Hero>) {
        Completable.fromAction {
            heroList.forEach { hero ->
                val diskPath =
                    "${context.getExternalFilesDir(null)}${File.separator}${hero.localizedName}"
                if (interactor.downloadIcon(
                        hero.icon,
                        diskPath
                    )
                ) {
                    hero.icon = diskPath
                    downloadHeroOnDb(hero)
                }

            }
        }.andThen(Single.just(changeHeroList(heroList)))
            .subscribeOn(AndroidSchedulers.mainThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                loading.value = false
            }, {}).addTo(subscriptions)
    }

}