package com.example.empresas_android.data.login

import com.example.empresas_android.data.model.LoggedUser
import retrofit2.Response

interface ILoginService {
    fun logout()
    suspend fun login(username: String, password: String): Response<LoggedUser>
}