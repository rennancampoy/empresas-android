package com.example.empresas_android.data.login

import androidx.lifecycle.MutableLiveData
import com.example.empresas_android.data.Result
import com.example.empresas_android.data.model.LoggedInUser

class LoginRepository(val service: LoginService): ILoginRepository {

    override val user =  MutableLiveData<LoggedInUser?>()

    override val isLoggedIn: Boolean
        get() = user.value != null

    override fun logout() {
        user.value = null
        service.logout()
    }

    override fun login(username: String, password: String): Result<LoggedInUser> {
        val result = service.login(username, password)

        if (result is Result.Success) {
            setLoggedInUser(result.data)
        }

        return result
    }

    private fun setLoggedInUser(loggedInUser: LoggedInUser) {
        this.user.value = loggedInUser
    }
}
