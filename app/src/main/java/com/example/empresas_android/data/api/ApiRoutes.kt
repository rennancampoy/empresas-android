package com.example.empresas_android.data.api

import com.example.empresas_android.data.model.EnterpriseList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiRoutes {
    companion object {
        private const val SIGN_IN_ENDPOINT = "users/auth/sign_in"
        private const val ENTERPRISES_ENDPOINT = "enterprises"
    }

    @GET(ENTERPRISES_ENDPOINT)
    @Headers(
        "access-token: Ti_ouuIOw3EreYkkEskOqg",
        "client: hmXI9eyy9jW2uaHbQTKAAQ",
        "uid: testeapple@ioasys.com.br"
    )
    fun getEnterprises(): Call<EnterpriseList>
}