package com.example.daggerpractice.di

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.daggerpractice.R
import com.example.daggerpractice.SessionManager
import com.example.daggerpractice.network.auth.AuthApi
import com.example.daggerpractice.util.BASE_URL
import com.example.daggerpractice.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Provider
import javax.inject.Singleton

@Module
abstract class AppModule {

    @Module
    companion object {

        @Singleton
        @Provides
        @JvmStatic
        fun provideRequestOptions() = RequestOptions.placeholderOf(R.drawable.white_background)
            .error(R.drawable.white_background)

        @Singleton
        @Provides
        @JvmStatic
        fun provideGlideInstance(
            application: Application,
            requestOptions: RequestOptions
        ) =
            Glide
                .with(application)
                .setDefaultRequestOptions(requestOptions)


        @Singleton
        @Provides
        @JvmStatic
        fun provideAppDrawable(application: Application) =
            ContextCompat.getDrawable(application, R.drawable.logo)


        @Singleton
        @Provides
        @JvmStatic
        fun provideRetrofitInstance(): Retrofit =
            Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

}
