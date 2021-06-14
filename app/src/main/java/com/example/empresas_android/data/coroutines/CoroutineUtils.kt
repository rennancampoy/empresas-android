package com.example.empresas_android.data.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun <T> withContextIO(block: suspend CoroutineScope.() -> T) = withContext(Dispatchers.IO) {
    block()
}