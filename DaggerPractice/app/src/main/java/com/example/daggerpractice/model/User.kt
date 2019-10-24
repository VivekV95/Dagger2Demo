package com.example.daggerpractice.model

data class User(
    val id: Int,
    val username: String? = null,
    val email: String? = null,
    val website: String? = null
)