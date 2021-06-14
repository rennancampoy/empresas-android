package com.example.empresas_android.data.enterprise

import com.example.empresas_android.data.model.Enterprise

interface IEnterpriseService {
    suspend fun getEnterprises(searchText: String?): List<Enterprise>?
    suspend fun getEnterpriseDetails(id: Int): Enterprise?
}