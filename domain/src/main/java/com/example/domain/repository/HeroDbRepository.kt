package com.example.domain.repository

import com.example.domain.model.dto.Hero
import io.reactivex.Completable
import io.reactivex.Observable

interface HeroDbRepository {

    fun insertHero(hero: Hero)
    fun insertAllHeroes(heroList: List<Hero>)
    fun getHeroes(): Observable<List<Hero>>
    fun update(hero: Hero)

}