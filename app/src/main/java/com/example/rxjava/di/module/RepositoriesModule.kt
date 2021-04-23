package com.example.rxjava.di.module

import com.example.data.api.HeroApi
import com.example.data.repository.HeroRepositoryImpl
import com.example.domain.repository.HeroRepository
import dagger.Module
import dagger.Provides
@Module
object RepositoriesModule {
    @Provides
    fun provideHeroRepository(
        api: HeroApi
    ): HeroRepository = HeroRepositoryImpl(api)
}