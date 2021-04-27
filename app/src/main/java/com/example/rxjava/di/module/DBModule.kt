package com.example.rxjava.di.module

import android.content.Context
import androidx.room.Room
import com.example.data.database.AppDatabase
import com.example.data.database.dao.HeroDao
import dagger.Module
import dagger.Provides

@Module
object DBModule {

    @Provides
    fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "database").build()
    }

    @Provides
    fun provideHeroDao(database: AppDatabase): HeroDao{
        return database.getHeroDao()
    }
}