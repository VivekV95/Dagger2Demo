package com.example.daggerpractice.viewmodel

import androidx.lifecycle.ViewModel
import javax.inject.Inject
import androidx.lifecycle.ViewModelProvider
import java.lang.Exception
import java.lang.IllegalArgumentException
import java.lang.RuntimeException
import javax.inject.Provider
import javax.inject.Singleton

@Suppress("UNCHECKED_CAST")
class ViewModelFactory @Inject constructor (
    val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    init {
        val i = 0
    }
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val creator = creators[modelClass] ?: creators.asIterable().firstOrNull {
            modelClass.isAssignableFrom(it.key)
        }?.value ?: throw IllegalArgumentException("unknown model class $modelClass")

        return try {
            creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

}