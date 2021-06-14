package com.example.empresas_android.ui.viewmodel.login

import androidx.lifecycle.LiveData
import com.example.empresas_android.data.coroutines.IBaseViewModel
import com.example.empresas_android.ui.login.LoginFormState
import com.example.empresas_android.ui.login.LoginResult

interface ILoginViewModel: IBaseViewModel {
    enum class Tag {
        LOGIN
    }

    val loginFormState: LiveData<LoginFormState>
    val loginResult: LiveData<LoginResult>

    fun login(username: String, password: String)
    fun loginDataChanged(username: String, password: String)
}