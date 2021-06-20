package com.example.empresas_android.data.login

import androidx.lifecycle.MutableLiveData
import com.example.empresas_android.data.dataPersistence.IPairDataPersistence
import com.example.empresas_android.data.model.LoggedInUser
import com.example.empresas_android.data.model.LoggedUser

class LoginRepository(
    private val service: ILoginService,
    private val dataPersistence: IPairDataPersistence
): ILoginRepository {

    override val user =  MutableLiveData<LoggedInUser?>()

    override val isLoggedIn: Boolean
        get() = user.value != null

    override fun logout() {
        user.value = null
        service.logout()
    }

    override suspend fun login(username: String, password: String): LoggedUser {
        val response = service.login(username, password)

        dataPersistence.putString("access-token", response.headers().get("access-token")!!)
        dataPersistence.putString("client", response.headers().get("client")!!)
        dataPersistence.putString("uid", response.headers().get("uid")!!)

        return response.body()!!
    }
}
