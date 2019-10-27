package com.example.daggerpractice.di.auth

import com.example.daggerpractice.network.auth.AuthApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class AuthModule {

    @Module
    companion object {

        @Provides
        @JvmStatic
        fun provideAuthApi(retrofit: Retrofit): AuthApi = retrofit.create(AuthApi::class.java)

    }
}