package com.example.empresas_android.ui.viewmodel.enterprise

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.empresas_android.data.coroutines.BaseCoroutineViewModel
import com.example.empresas_android.data.enterprise.IEnterpriseRepository
import com.example.empresas_android.data.model.Enterprise
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.lazy
import kotlinx.coroutines.launch

class EnterpriseViewModel(kodein: Kodein): BaseCoroutineViewModel(),
    IEnterpriseViewModel {

    private val enterpriseRepository: IEnterpriseRepository by kodein.lazy.instance()

    override val enterprises = MutableLiveData<List<Enterprise>>()
    override val selectedEnterprise = MutableLiveData<Enterprise>()

    override fun getEnterpriseDetail(id: Int) {
        launch {
            selectedEnterprise.value = enterpriseRepository.getEnterpriseDetails(1)
            Log.d("ENTERPRISE", selectedEnterprise.value!!.name)
        }
    }

    override fun getEnterprises() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}