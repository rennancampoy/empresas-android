package com.example.empresas_android.data.login

import androidx.lifecycle.LiveData
import com.example.empresas_android.data.Result
import com.example.empresas_android.data.model.LoggedInUser

interface ILoginRepository {
    val user: LiveData<LoggedInUser?>
    val isLoggedIn: Boolean

    fun logout()
    fun login(username: String, password: String): Result<LoggedInUser>
}