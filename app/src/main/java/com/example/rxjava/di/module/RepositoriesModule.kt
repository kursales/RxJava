package com.example.rxjava.di.module

import com.example.data.api.HeroApi
import com.example.data.api.IconApi
import com.example.data.database.dao.HeroDao
import com.example.data.dbrepository.HeroDbRepositoryImpl
import com.example.data.repository.HeroRepositoryImpl
import com.example.domain.repository.HeroDbRepository
import com.example.domain.repository.HeroRepository
import dagger.Module
import dagger.Provides
@Module
object RepositoriesModule {
    @Provides
    fun provideHeroRepository(
        api: HeroApi,
        iconApi: IconApi
    ): HeroRepository = HeroRepositoryImpl(api, iconApi)

    @Provides
    fun provideHeroDbRepository(
        heroDao: HeroDao
    ): HeroDbRepository = HeroDbRepositoryImpl(heroDao)
}