package com.example.daggerpractice.network.main

import retrofit2.http.GET
import retrofit2.http.Query

interface MainApi {

    @GET("posts")
    fun getPostsFromUser(@Query("userId")id: Int)
}