package com.example.data.api

import com.example.data.model.HeroResponse
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface HeroApi {
    @GET("heroStats")
    fun getUsers(): Single<List<HeroResponse>>


}