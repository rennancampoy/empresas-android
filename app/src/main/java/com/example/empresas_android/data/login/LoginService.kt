package com.example.empresas_android.data.login

import com.example.empresas_android.data.api.IApiClient
import com.example.empresas_android.data.coroutines.withContextIO
import com.example.empresas_android.data.model.LoggedUser
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.*

class LoginService(private val apiClient: IApiClient): ILoginService {

    override suspend fun login(username: String, password: String): Response<LoggedUser> = withContextIO {
        apiClient.getRoutes().login(
            RequestBody.create(
                okhttp3.MediaType.parse("application/json; charset=utf-8"),
                JSONObject(mapOf(
                    "email" to username, "password" to password
                )).toString())
        ).awaitResponse()
    }

    override fun logout() {
        // rcampoy: we'll do nothing for now
    }
}



