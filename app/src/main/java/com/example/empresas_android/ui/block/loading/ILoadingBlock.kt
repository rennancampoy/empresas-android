package com.example.empresas_android.ui.block.loading

interface ILoadingBlock {
    fun show(message: String? = null)
    fun hide()
    fun setVisibility(visible: Boolean, message: String? = null)
}