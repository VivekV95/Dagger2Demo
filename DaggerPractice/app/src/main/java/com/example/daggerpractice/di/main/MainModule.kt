package com.example.daggerpractice.di.main

import com.example.daggerpractice.network.main.MainApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class MainModule {

    @Provides
    fun provideMainApi(retrofit: Retrofit) = retrofit.create(MainApi::class.java)
}