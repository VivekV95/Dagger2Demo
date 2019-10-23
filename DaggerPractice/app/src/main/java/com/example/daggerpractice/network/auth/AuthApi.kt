package com.example.daggerpractice.network.auth

import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface AuthApi {
    fun getFakeStuff(): Call<ResponseBody>
}