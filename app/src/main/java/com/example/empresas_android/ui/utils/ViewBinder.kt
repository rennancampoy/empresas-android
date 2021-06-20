package com.example.empresas_android.ui.utils

import android.content.Context
import android.view.ViewGroup

abstract class ViewBinder(rootView: ViewGroup) {
    val context: Context = rootView.context
}