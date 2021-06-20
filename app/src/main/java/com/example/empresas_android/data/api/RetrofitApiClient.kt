package com.example.empresas_android.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApiClient: IApiClient {
    override val BASE_URL = "https://empresas.ioasys.com.br/api/v1/"

    override fun getRoutes(): ApiRoutes = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiRoutes::class.java)
}