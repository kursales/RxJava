package com.example.rxjava.di.module

import com.example.data.api.HeroApi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit

@Module
object ApiModule {
@Reusable
@Provides
fun provideUserApiService(retrofit: Retrofit): HeroApi =
        retrofit.create(HeroApi::class.java)
}