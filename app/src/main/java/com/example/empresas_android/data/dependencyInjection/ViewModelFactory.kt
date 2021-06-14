package com.example.empresas_android.data.dependencyInjection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.salomonbrys.kodein.Kodein

object ViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val kodeinConstructor = modelClass.getConstructor(Kodein::class.java)
        return kodeinConstructor.newInstance(DataKodein.kodein)
    }
}