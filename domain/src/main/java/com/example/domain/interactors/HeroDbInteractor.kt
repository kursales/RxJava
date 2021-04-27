package com.example.domain.interactors

import com.example.domain.model.dto.Hero
import com.example.domain.usecase.HeroDbUseCase
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HeroDbInteractor @Inject constructor(private val heroDbUseCase: HeroDbUseCase) {
    fun insertHero(hero: Hero): Completable {
       return Completable.fromAction{heroDbUseCase.insertHero(hero)}
           .subscribeOn(Schedulers.io())
    }

    fun insertAllHeroes(heroList: List<Hero>): Completable {
        return Completable.fromAction { heroDbUseCase.insertAllHeroes(heroList) }
            .subscribeOn(Schedulers.io())
    }

    fun getHeroes(): Observable<List<Hero>> {
        return heroDbUseCase.getHeroes()
    }
    fun update(hero: Hero){
        heroDbUseCase.update(hero)
    }
}