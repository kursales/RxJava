package com.example.domain.usecase

import com.example.domain.model.dto.Hero
import com.example.domain.repository.HeroRepository
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class UserUseCase @Inject constructor(
    private val repository
    : HeroRepository
) {
    fun getHeroes(): Single<List<Hero>> = repository.getUsers()
}