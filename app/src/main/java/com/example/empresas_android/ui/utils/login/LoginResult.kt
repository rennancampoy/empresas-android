package com.example.empresas_android.ui.utils.login

import com.example.empresas_android.ui.utils.login.LoggedInUserView

/**
 * Authentication result : success (user details) or error message.
 */
data class LoginResult(
    val success: LoggedInUserView? = null,
    val error: Int? = null
)
