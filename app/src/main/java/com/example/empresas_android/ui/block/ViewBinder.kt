package com.example.empresas_android.ui.block

import android.content.Context
import android.view.ViewGroup

abstract class ViewBinder(val rootView: ViewGroup) {
    val context: Context = rootView.context
}