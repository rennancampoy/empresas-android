package com.example.empresas_android.ui.viewmodel.enterprise

import androidx.lifecycle.LiveData
import com.example.empresas_android.data.model.Enterprise

interface IEnterpriseViewModel {
    val enterprises: LiveData<List<Enterprise>>
    val selectedEnterprise: LiveData<Enterprise>

    fun getEnterprises()
    fun getEnterpriseDetail(id: Int)
}