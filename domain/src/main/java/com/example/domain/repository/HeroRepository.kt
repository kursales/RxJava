package com.example.domain.repository

import com.example.domain.model.dto.Hero
import com.example.domain.model.result.Result
import io.reactivex.Observable
import io.reactivex.Single

interface HeroRepository {

    fun getUsers():Single<List<Hero>>
}