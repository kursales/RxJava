package com.example.domain.usecase

import com.example.domain.model.dto.Hero
import com.example.domain.repository.HeroDbRepository
import com.example.domain.repository.HeroRepository
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class HeroDbUseCase @Inject constructor(private val repository: HeroDbRepository) {

    fun insertHero(hero: Hero) {
      repository.insertHero(hero)
    }

    fun insertAllHeroes(heroList: List<Hero>) {
        repository.insertAllHeroes(heroList)
    }

    fun getHeroes(): Observable<List<Hero>> {
        return repository.getHeroes()
    }

    fun update(hero: Hero) {
        repository.update(hero)
    }

}