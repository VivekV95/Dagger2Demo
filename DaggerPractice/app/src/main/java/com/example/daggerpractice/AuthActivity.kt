package com.example.daggerpractice

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.RequestManager
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_auth.*
import javax.inject.Inject
import javax.inject.Named

class AuthActivity : DaggerAppCompatActivity() {

    @Inject
    @JvmField
    var logo: Drawable? = null

    @Inject
    lateinit var requestManager: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        setLogo()
    }

    fun setLogo() {
        requestManager
            .load(logo)
            .into(login_logo)
    }

}

