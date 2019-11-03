package com.example.daggerpractice.di

import android.app.Application
import com.example.daggerpractice.di.auth.AuthComponent
import com.example.daggerpractice.di.main.MainComponent
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

    fun authComponent(): AuthComponent

    fun mainComponent(): MainComponent
}