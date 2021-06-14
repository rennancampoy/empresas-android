package com.example.empresas_android.data.enterprise

import com.example.empresas_android.data.coroutines.withContextIO
import com.example.empresas_android.data.model.Enterprise

class EnterpriseService: IEnterpriseService {
    override suspend fun getEnterprises(searchText: String?): List<Enterprise>? = withContextIO {
        listOf(
            Enterprise(1, "Emp 1", "Prog", "BRA"),
            Enterprise(2, "Emp 2", "Prog", "EUA"),
            Enterprise(3, "Emp 3", "Prog", "ITA")
        )
    }

    override suspend fun getEnterpriseDetails(id: Int): Enterprise? = withContextIO {
        Enterprise(3, "Emp 3", "Prog", "ITA")
    }
}