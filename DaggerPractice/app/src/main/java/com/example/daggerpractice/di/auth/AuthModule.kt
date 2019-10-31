package com.example.daggerpractice.di.auth

import com.example.daggerpractice.di.scope.AuthScope
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
        @AuthScope
        fun provideAuthApi(retrofit: Retrofit) = retrofit.create(AuthApi::class.java)
    }
}