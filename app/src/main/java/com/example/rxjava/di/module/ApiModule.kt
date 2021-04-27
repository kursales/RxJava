package com.example.rxjava.di.module

import com.example.data.api.HeroApi
import com.example.data.api.IconApi
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
object ApiModule {
        @Reusable
        @Provides
        fun provideHeroApiService(retrofit: Retrofit): HeroApi =
                retrofit.create(HeroApi::class.java)

        @Provides
        fun provideIconApiService(): IconApi {
                val retrofit = Retrofit.Builder()
                        .baseUrl("https://api.opendota.com/")
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                return retrofit.create(IconApi::class.java)

        }
}