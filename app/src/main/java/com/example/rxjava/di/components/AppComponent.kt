package com.example.rxjava.di.components

import android.app.Application
import com.example.rxjava.di.module.*
import com.example.rxjava.ui.MainViewModel
import com.example.rxjava.ui.herolist.AllHeroesViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class, RepositoriesModule::class, HttpModule::class, AppModule::class, DBModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory{
        fun create(@BindsInstance app: Application): AppComponent
    }


    val mainViewModel: MainViewModel

    /* User flow */

    val allHeroesViewModel: AllHeroesViewModel
}