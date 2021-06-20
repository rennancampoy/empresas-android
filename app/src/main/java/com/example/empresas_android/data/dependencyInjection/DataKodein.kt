package com.example.empresas_android.data.dependencyInjection

import android.content.Context
import com.example.empresas_android.data.api.IApiClient
import com.example.empresas_android.data.api.RetrofitApiClient
import com.example.empresas_android.data.dataPersistence.IPairDataPersistence
import com.example.empresas_android.data.dataPersistence.PairDataPersistence
import com.example.empresas_android.data.enterprise.EnterpriseRepository
import com.example.empresas_android.data.enterprise.EnterpriseService
import com.example.empresas_android.data.enterprise.IEnterpriseRepository
import com.example.empresas_android.data.enterprise.IEnterpriseService
import com.example.empresas_android.data.login.ILoginRepository
import com.example.empresas_android.data.login.ILoginService
import com.example.empresas_android.data.login.LoginRepository
import com.example.empresas_android.data.login.LoginService
import com.github.salomonbrys.kodein.*
import com.github.salomonbrys.kodein.Kodein

object DataKodein {
    lateinit var kodein: Kodein
    private var setup = false

    fun setup(context: Context) {
        if (setup) {
            throw UnsupportedOperationException("A injeção de dependência já foi inicializada!")
        }

        kodein = Kodein {
            bind<IEnterpriseRepository>() with singleton { EnterpriseRepository(instance()) }
            bind<IEnterpriseService>() with singleton { EnterpriseService(instance()) }
            bind<ILoginRepository>() with singleton { LoginRepository(instance(), instance()) }
            bind<ILoginService>() with singleton { LoginService(instance()) }
            bind<IApiClient>() with singleton { RetrofitApiClient() }
            bind<IPairDataPersistence>() with singleton { PairDataPersistence(context) }
        }

        setup = true
    }
}
