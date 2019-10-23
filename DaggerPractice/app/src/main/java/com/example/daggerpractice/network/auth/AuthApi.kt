package com.example.daggerpractice.network.auth

import io.reactivex.Flowable
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface AuthApi {
    fun getFakeStuff(): Flowable<ResponseBody>
}