package com.example.empresas_android.data.coroutines

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch


abstract class CoroutineViewModel : CoroutineScope by MainScope(), ViewModel() {

    override fun onCleared() {
        cancel()
        super.onCleared()
    }

    private suspend fun runIgnoringThrows(action: suspend () -> Unit): Throwable? {
        return try {
            action()
            null
        } catch (t: Throwable) {
            t
        }
    }

    protected fun launchIgnoringThrows(action: suspend () -> Unit) {
        launch {
            runIgnoringThrows(action)
        }
    }
}