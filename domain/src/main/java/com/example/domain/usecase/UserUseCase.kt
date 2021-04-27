package com.example.domain.usecase

import android.content.Context
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
    fun downloadImage(path: String, diskPath: String) = repository.downloadImage(path, diskPath)
}