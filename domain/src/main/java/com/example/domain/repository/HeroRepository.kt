package com.example.domain.repository

import android.content.Context
import android.telecom.Call
import com.example.domain.model.dto.Hero
import com.example.domain.model.result.Result
import io.reactivex.Observable
import io.reactivex.Single

interface HeroRepository {

    fun getUsers():Single<List<Hero>>

    fun downloadImage(path: String, diskPath: String): Boolean
}