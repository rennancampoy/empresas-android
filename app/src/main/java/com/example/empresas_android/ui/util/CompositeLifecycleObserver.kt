package com.example.empresas_android.ui.util

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import java.lang.ref.WeakReference

open class CompositeLifecycleObserver<in T: LifecycleObserver>(private val lifecycleOwner: LifecycleOwner) {
    private val observers = mutableListOf<WeakReference<T>>()

    fun add(lifecycleObserver: T) {
        synchronized(this) {
            lifecycleOwner.lifecycle.addObserver(lifecycleObserver)
            observers.add(WeakReference(lifecycleObserver))
        }
    }

    fun dispose() {
        synchronized(this) {
            observers.forEach {
                it.get()?.let { lifecycleObserver ->
                    lifecycleOwner.lifecycle.removeObserver(lifecycleObserver)
                    onObserverDisposed(lifecycleObserver)
                }
            }

            observers.clear()
        }
    }

    open fun onObserverDisposed(observer: T) {}
}

fun <T : LifecycleObserver> T.addTo(compositeLifecycleObserver: CompositeLifecycleObserver<T>) = apply {
    compositeLifecycleObserver.add(this)
}