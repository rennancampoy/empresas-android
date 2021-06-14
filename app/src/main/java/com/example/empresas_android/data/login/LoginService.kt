package com.example.empresas_android.data.login

import com.example.empresas_android.data.Result
import com.example.empresas_android.data.coroutines.withContextIO
import com.example.empresas_android.data.model.LoggedInUser

class LoginService: ILoginService {

    override suspend fun login(username: String, password: String) = withContextIO {
        Result.Success(LoggedInUser("1", "Rennan"))
    }

    override fun logout() {
        // rcampoy: we'll do nothing for now
    }
}

