package com.example.daggerpractice.network.main

import com.example.daggerpractice.model.Post
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface MainApi {

    @GET("posts")
    fun getPostsFromUser(@Query("userId") id: Int): Flowable<List<Post>>

}