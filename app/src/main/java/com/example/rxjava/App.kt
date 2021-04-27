package com.example.rxjava

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.rxjava.di.components.AppComponent
import com.example.rxjava.di.components.DaggerAppComponent

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.factory().create(this)
        context = applicationContext


    }


    companion object{
        lateinit var context: Context
        private set
        lateinit var component: AppComponent
        private set
    }
}