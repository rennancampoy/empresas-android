package com.example.empresas_android.data.coroutines

data class ErrorInfo(
    val error: Throwable,
    val tag: Any? = null,
    val payload: Any? = null
)