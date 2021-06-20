package com.example.empresas_android.ui.utils.snackbar

import android.view.View
import android.widget.TextView
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar

class SnackbarExtensions {
    companion object {
        @JvmStatic
        fun makeWrappedSnackbar(view: View, @StringRes resId: Int, duration: Int): Snackbar {
            val snackbar = Snackbar.make(view, resId, duration)
            removeLimit(snackbar)
            return snackbar
        }

        @JvmStatic
        fun removeLimit(snackbar: Snackbar) {
            val textView = findTextView(snackbar)
            textView.setSingleLine(false)
        }

        @JvmStatic
        fun findTextView(snackbar: Snackbar): TextView {
            val textView = snackbar.view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            return textView
        }
    }
}