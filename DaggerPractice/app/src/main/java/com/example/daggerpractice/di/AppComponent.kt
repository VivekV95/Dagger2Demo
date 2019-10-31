package com.example.daggerpractice.di

import android.app.Application
import com.example.daggerpractice.di.auth.AuthComponent
import com.example.daggerpractice.di.auth.AuthModule
import com.example.daggerpractice.di.auth.AuthViewModelModule
import com.example.daggerpractice.di.main.MainComponent
import com.example.daggerpractice.di.main.MainModule
import com.example.daggerpractice.di.main.MainViewModelModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bindApplication(application: Application): Builder

        fun build(): AppComponent
    }

    fun authComponent(
        authModule: AuthModule,
        authViewModelModule: AuthViewModelModule
    ): AuthComponent

    fun mainComponent(
        mainModule: MainModule,
        mainViewModelModule: MainViewModelModule
    ): MainComponent
}