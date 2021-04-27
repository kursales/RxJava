package com.example.data.api

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Streaming
import retrofit2.http.Url

interface IconApi {
    @Streaming
    @GET
    fun downloadImage(@Url path: String): Call<ResponseBody>
}