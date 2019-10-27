package com.example.daggerpractice.network.main

import com.bumptech.glide.load.engine.Resource
import com.example.daggerpractice.model.Post
import com.example.daggerpractice.model.User
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface MainApi {

    @GET("posts")
    fun getPostsFromUser(@Query("userId") id: Int): Flowable<List<Post>>

}