package com.example.empresas_android.ui.login

interface ILoginViewModel {
    fun login(username: String, password: String)
    fun loginDataChanged(username: String, password: String)
}