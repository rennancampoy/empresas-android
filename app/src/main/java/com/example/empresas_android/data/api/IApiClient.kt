package com.example.empresas_android.data.api

interface IApiClient {
    val BASE_URL: String
    fun getRoutes(): ApiRoutes
}