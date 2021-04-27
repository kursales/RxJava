package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.database.dao.HeroDao
import com.example.domain.model.dto.Hero

@Database(entities = [Hero::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
abstract fun getHeroDao(): HeroDao
}