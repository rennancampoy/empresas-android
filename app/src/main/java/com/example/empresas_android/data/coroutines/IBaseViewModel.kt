package com.example.empresas_android.data.coroutines

import androidx.lifecycle.LiveData

interface IBaseViewModel {
    val error: LiveData<ErrorInfo>
    val loading: LiveData<LoadingInfo>
}
