package com.example.data.dbrepository

import com.example.data.database.dao.HeroDao
import com.example.domain.model.dto.Hero
import com.example.domain.repository.HeroDbRepository
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject


class HeroDbRepositoryImpl @Inject constructor(
    val heroDao: HeroDao) :
    HeroDbRepository {


    override fun insertHero(hero: Hero) {
        heroDao.insert(hero)
    }

    override fun insertAllHeroes(heroList: List<Hero>){
        heroList.forEach {
            heroDao.insert(it)
        }
    }

    override fun getHeroes(): Observable<List<Hero>> {
        return heroDao.getAllHeroes()
    }

    override fun update(hero: Hero) {
        heroDao.update(hero)
    }

}
