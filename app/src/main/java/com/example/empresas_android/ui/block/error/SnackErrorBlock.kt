package com.example.empresas_android.ui.block.error

import android.view.ViewGroup
import com.example.empresas_android.ui.utils.snackbar.SnackbarExtensions
import com.google.android.material.snackbar.Snackbar

class SnackErrorBlock(private val rootView: ViewGroup): IErrorBlock {
    override fun showError(message: Int) {
        SnackbarExtensions.makeWrappedSnackbar(rootView, message, Snackbar.LENGTH_LONG).show()
    }
}