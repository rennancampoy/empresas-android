package com.example.empresas_android.ui.block

interface ILoadingBlock {
    fun show(message: String? = null)
    fun hide()
    fun setVisibility(visible: Boolean, message: String? = null)
}