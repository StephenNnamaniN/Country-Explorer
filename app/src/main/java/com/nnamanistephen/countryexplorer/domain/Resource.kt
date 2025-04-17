package com.nnamanistephen.countryexplorer.domain

sealed class Resource<T> {
    class Loading<T>: Resource<T>()
    data class Success<T>(val data: T): Resource<T>()
    data class Error<T>(val message: String?, val data: T? = null): Resource<T>()
}