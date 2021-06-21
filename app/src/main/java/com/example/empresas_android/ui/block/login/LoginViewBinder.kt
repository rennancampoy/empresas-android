package com.example.empresas_android.ui.block.login

import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.empresas_android.ui.utils.CustomEditText
import com.example.empresas_android.ui.utils.ViewBinder
import kotlinx.android.synthetic.main.activity_login.view.*

class LoginViewBinder(rootView: ViewGroup): ViewBinder(rootView) {
    val usernameEditText: EditText = rootView.username
    val passwordEditText: CustomEditText = rootView.password
    val loginButton: Button = rootView.login
}