package com.example.empresas_android.data.enterprise

import com.example.empresas_android.data.api.IApiClient
import com.example.empresas_android.data.coroutines.withContextIO
import com.example.empresas_android.data.model.Enterprise
import com.example.empresas_android.data.model.EnterpriseList
import com.example.empresas_android.data.model.EnterpriseType
import retrofit2.await

class EnterpriseService(private val apiClient: IApiClient): IEnterpriseService {

    override suspend fun getEnterprises(searchText: String?): EnterpriseList = withContextIO {
        val teste = apiClient.getRoutes().getEnterprises().await()
        if (teste.enterprises.isEmpty()) {
            EnterpriseList(listOf(Enterprise("sada", "dasda", "asdada", EnterpriseType("asdadsa", 1), 2, "123131sad")))
        } else teste
    }

    override suspend fun getEnterpriseDetails(id: Int): Enterprise? = withContextIO {
        Enterprise("sada", "dasda", "asdada", EnterpriseType("asdadsa", 1), 2, "123131sad")
    }
}