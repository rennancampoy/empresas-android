package com.example.empresas_android.data.enterprise

interface IEnterpriseRepository {
    fun getEnterprises(searchText: String?)
    fun getEnterpriseDetails(id: Int)
}