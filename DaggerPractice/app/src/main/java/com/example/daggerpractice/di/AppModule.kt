package com.example.daggerpractice.di

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.daggerpractice.R
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule {

    @Module
    companion object {

        @Singleton
        @Provides @JvmStatic
        fun provideRequestOptions(): RequestOptions {
            return RequestOptions.placeholderOf(R.drawable.white_background)
                .error(R.drawable.white_background)
        }

        @Singleton
        @Provides @JvmStatic
        fun provideGlideInstance(
            application: Application,
            requestOptions: RequestOptions
        ): RequestManager {
            return Glide
                .with(application)
                .setDefaultRequestOptions(requestOptions)
        }

        @Singleton
        @Provides @JvmStatic
        fun provideAppDrawable(application: Application): Drawable? {
            return ContextCompat.getDrawable(application, R.drawable.logo)
        }



    }

}