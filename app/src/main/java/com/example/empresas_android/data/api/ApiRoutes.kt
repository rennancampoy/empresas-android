package com.example.empresas_android.data.api

import com.example.empresas_android.data.model.EnterpriseList
import com.example.empresas_android.data.model.LoggedUser
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import kotlin.collections.HashMap


interface ApiRoutes {
    companion object {
        private const val LOGIN_ENDPOINT = "users/auth/sign_in"
        private const val ENTERPRISES_ENDPOINT = "enterprises"
    }

    @GET(ENTERPRISES_ENDPOINT)
    @Headers(
        "access-token: Ti_ouuIOw3EreYkkEskOqg",
        "client: hmXI9eyy9jW2uaHbQTKAAQ",
        "uid: testeapple@ioasys.com.br"
    )
    fun getEnterprises(): Call<EnterpriseList>

    @POST(LOGIN_ENDPOINT)
    fun login(@Body body: RequestBody): Call<LoggedUser>
}