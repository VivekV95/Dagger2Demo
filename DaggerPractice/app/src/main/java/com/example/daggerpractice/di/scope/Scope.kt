package com.example.daggerpractice.di.scope

import javax.inject.Scope

@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class AuthScope

@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class MainScope

@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class ProfileScope

@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class PostsScope
