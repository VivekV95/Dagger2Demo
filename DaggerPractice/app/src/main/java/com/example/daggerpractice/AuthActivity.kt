package com.example.daggerpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject
import javax.inject.Named

class AuthActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var someString: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        println()
    }

}

