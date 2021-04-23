package com.example.domain.interactors

import com.example.domain.model.dto.Hero
import com.example.domain.usecase.UserUseCase
import io.reactivex.Single
import javax.inject.Inject

class HeroInteractor @Inject constructor(
    private val useCase: UserUseCase
) {
    fun getHeroes(): Single<List<Hero>> = useCase.getHeroes()
}