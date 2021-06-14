package com.example.empresas_android.data.enterprise

class EnterpriseRepository(private val service: IEnterpriseService): IEnterpriseRepository {
    override suspend fun getEnterprises(searchText: String?) = service.getEnterprises(searchText)

    override suspend fun getEnterpriseDetails(id: Int) = service.getEnterpriseDetails(id)
}