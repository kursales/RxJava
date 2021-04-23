package com.example.data.api

import com.example.data.model.HeroResponse
import io.reactivex.Single
import retrofit2.http.GET

interface HeroApi {
    @GET("/users")
    fun getUsers(): Single<List<HeroResponse>>
}