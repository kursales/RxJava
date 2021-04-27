package com.example.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.domain.model.dto.Hero
import io.reactivex.Observable

@Dao
interface HeroDao {

    @Insert
    fun insert(hero: Hero)

    @Query("SELECT*FROM Hero")
    fun getAllHeroes():Observable<List<Hero>>

    @Update
    fun update(hero: Hero)
}