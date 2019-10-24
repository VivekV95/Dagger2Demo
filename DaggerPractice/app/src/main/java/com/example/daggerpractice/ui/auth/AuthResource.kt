package com.example.daggerpractice.ui.auth

sealed class AuthResource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Authenticated<T>(data: T) : AuthResource<T>(data)

    class Loading<T>(data: T? = null) : AuthResource<T>(data)

    class Error<T>(message: String, data: T? = null) : AuthResource<T>(data, message)

    class NotAuthenticated<T>(message: String, data: T? = null): AuthResource<T>(data, message)
}