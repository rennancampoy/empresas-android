package com.example.empresas_android.data.login

import androidx.lifecycle.LiveData
import com.example.empresas_android.data.model.LoggedInUser
import com.example.empresas_android.data.model.LoggedUser

interface ILoginRepository {
    val user: LiveData<LoggedInUser?>
    val isLoggedIn: Boolean

    fun logout()
    suspend fun login(username: String, password: String): LoggedUser
}