package com.example.empresas_android.data.login

import com.example.empresas_android.data.Result
import com.example.empresas_android.data.model.LoggedInUser

interface ILoginService {
    fun logout()
    suspend fun login(username: String, password: String): Result<LoggedInUser>
}