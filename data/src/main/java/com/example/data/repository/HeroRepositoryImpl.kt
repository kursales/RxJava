package com.example.data.repository

import com.example.data.api.HeroApi
import com.example.data.mapper.mapToUser
import com.example.data.mapper.mapToUsersList
import com.example.data.util.safeApiCall
import com.example.domain.model.dto.Hero
import com.example.domain.model.result.Result
import com.example.domain.repository.HeroRepository
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject


class HeroRepositoryImpl @Inject constructor(
    private  val heroApi: HeroApi
): HeroRepository {
    override fun getUsers(): Single<List<Hero>> {
        return heroApi.getUsers().map { it.mapToUsersList() }
    }

}