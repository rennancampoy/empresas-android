package com.example.empresas_android.data.enterprise

import com.example.empresas_android.data.model.Enterprise
import com.example.empresas_android.data.model.EnterpriseList

interface IEnterpriseService {
    suspend fun getEnterprises(searchText: String?): EnterpriseList
    suspend fun getEnterpriseDetails(id: Int): Enterprise?
}