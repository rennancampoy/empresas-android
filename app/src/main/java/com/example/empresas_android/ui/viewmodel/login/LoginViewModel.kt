package com.example.empresas_android.ui.viewmodel.login

import androidx.lifecycle.MutableLiveData
import android.util.Patterns
import com.example.empresas_android.data.Result

import com.example.empresas_android.R
import com.example.empresas_android.data.coroutines.BaseCoroutineViewModel
import com.example.empresas_android.data.login.ILoginRepository
import com.example.empresas_android.ui.login.LoggedInUserView
import com.example.empresas_android.ui.login.LoginFormState
import com.example.empresas_android.ui.login.LoginResult
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.lazy

class LoginViewModel(kodein: Kodein) : BaseCoroutineViewModel(),
    ILoginViewModel {

    override val loginFormState = MutableLiveData<LoginFormState>()
    override val loginResult = MutableLiveData<LoginResult>()

    private val loginRepository: ILoginRepository by kodein.lazy.instance()

    override fun login(username: String, password: String) {
        launchSafe(ILoginViewModel.Tag.LOGIN) {
            val result = loginRepository.login(username, password)

            if (result is Result.Success) {
                loginResult.value =
                    LoginResult(
                        success = LoggedInUserView(
                            displayName = result.data.displayName
                        )
                    )
            } else {
                loginResult.value =
                    LoginResult(error = R.string.login_failed)
            }
        }
    }

    override fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            loginFormState.value =
                LoginFormState(
                    usernameError = R.string.login_invalid_username
                )
        } else if (!isPasswordValid(password)) {
            loginFormState.value =
                LoginFormState(
                    passwordError = R.string.login_invalid_password
                )
        } else {
            loginFormState.value =
                LoginFormState(isDataValid = true)
        }
    }

    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }
}
