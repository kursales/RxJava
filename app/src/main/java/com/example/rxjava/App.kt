package com.example.rxjava

import android.app.Application
import com.example.rxjava.di.components.AppComponent
import com.example.rxjava.di.components.DaggerAppComponent

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.factory().create(this)

    }
    companion object{
        lateinit var component: AppComponent
        private set
    }
}