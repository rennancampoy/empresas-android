package com.example.empresas_android.data.api

import com.example.empresas_android.data.model.EnterpriseList
import com.example.empresas_android.data.model.LoggedUser
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*


interface ApiRoutes {
    companion object {
        private const val LOGIN_ENDPOINT = "users/auth/sign_in"
        private const val ENTERPRISES_ENDPOINT = "enterprises"
    }

    @GET(ENTERPRISES_ENDPOINT)
    fun getEnterprises(@HeaderMap headers: Map<String, String>): Call<EnterpriseList>

    @POST(LOGIN_ENDPOINT)
    fun login(@Body body: RequestBody): Call<LoggedUser>
}