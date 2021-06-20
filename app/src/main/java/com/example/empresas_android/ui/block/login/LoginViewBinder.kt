package com.example.empresas_android.ui.block.login

import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.empresas_android.R
import com.example.empresas_android.ui.utils.ViewBinder

class LoginViewBinder(rootView: ViewGroup): ViewBinder(rootView) {
    val usernameEditText: EditText = rootView.findViewById(R.id.username)
    val passwordEditText: EditText = rootView.findViewById(R.id.password)
    val loginButton: Button = rootView.findViewById(R.id.login)
}