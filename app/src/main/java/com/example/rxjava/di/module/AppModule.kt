package com.example.rxjava.di.module

import android.content.Context
import android.content.SharedPreferences
import com.example.rxjava.App
import dagger.Module
import dagger.Provides

@Module
object AppModule {

    @Provides
    fun provideContext() = App.context

    @Provides
    fun providePreferences(context: Context): SharedPreferences = context.getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
}