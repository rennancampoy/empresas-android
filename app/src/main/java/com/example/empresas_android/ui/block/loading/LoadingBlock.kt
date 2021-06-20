package com.example.empresas_android.ui.block.loading

import android.content.Context
import androidx.lifecycle.LifecycleObserver
import com.example.empresas_android.ui.utils.LoadingManager

class LoadingBlock(context: Context): ILoadingBlock, LifecycleObserver {
    private val loadingManager =
        LoadingManager(context)

    override fun setVisibility(visible: Boolean, message: String?) {
        if(visible) {
            show(message)
        } else {
            hide()
        }
    }

    override fun show(message: String?) {
        if(!message.isNullOrEmpty()) {
            loadingManager.show(message)
        } else {
            loadingManager.show()
        }
    }

    override fun hide() {
        loadingManager.dismiss()
    }
}