package com.example.empresas_android.data.coroutines

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope

abstract class BaseCoroutineViewModel : CoroutineViewModel(), IBaseViewModel {
    override val error = MutableLiveData<ErrorInfo>()
    override val loading = MutableLiveData<LoadingInfo>()

    protected suspend fun runSafe(
        errorTag: Any? = null,
        loadingTag: Any? = null,
        finally: (() -> Unit)? = null,
        action: suspend () -> Unit
    ) {
        try {
            loading.value = LoadingInfo(true, loadingTag)
            action()
        } catch (t: Throwable) {
            error.value = ErrorInfo(t, errorTag)
        } finally {
            loading.value = LoadingInfo(false, loadingTag)
            finally?.invoke()
        }
    }

    protected suspend fun runSafe(
        loadingTag: Any, finally: (() -> Unit)? = null, action: suspend () -> Unit
    ): Throwable? {
        try {
            loading.value = LoadingInfo(true, loadingTag)
            action()
        } catch (t: Throwable) {
            return t
        } finally {
            loading.value = LoadingInfo(false, loadingTag)
            finally?.invoke()
        }

        return null
    }

    protected fun launchSafe(tag: Any, finally: (() -> Unit)? = null, action: suspend () -> Unit) {
        launch {
            runSafe(tag, tag, finally, action)
        }
    }

    protected suspend fun awaitAll(vararg jobs: suspend () -> Unit) {
        supervisorScope {
            jobs.map { async { it() } }
                .forEach { it.await() }
        }
    }
}