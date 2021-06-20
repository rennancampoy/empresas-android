package com.example.empresas_android.ui.utils

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.StringRes
import com.example.empresas_android.R

class LoadingManager(private val context: Context) {

    private val loadingDialog: Dialog
    private val layoutTexts: LinearLayout
    private val txtTitle: TextView
    private val txtMessage: TextView

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.important_dialog_loading, null)

        txtTitle = view.findViewById(R.id.txt_title)
        txtMessage = view.findViewById(R.id.txt_message)
        layoutTexts = view.findViewById(R.id.layout_texts)

        loadingDialog = AlertDialog.Builder(context, R.style.ImportantLoadingDialog)
            .setView(view)
            .setCancelable(false)
            .create()
    }

    private fun configureView(title: String?, message: String?) {
        val isTitleNullOrEmpty = title.isNullOrEmpty()
        val isMessageNullOrEmpty = message.isNullOrEmpty()

        txtTitle.visibility = if(isTitleNullOrEmpty) { View.GONE } else { View.VISIBLE }
        txtTitle.text = title

        txtMessage.visibility = if(isMessageNullOrEmpty) { View.GONE } else { View.VISIBLE }
        txtMessage.text = message

        layoutTexts.visibility = if(isTitleNullOrEmpty && isMessageNullOrEmpty) { View.GONE } else { View.VISIBLE }
    }

    fun show() {
        configureView(null, null)
        loadingDialog.show()
    }

    fun show(title: String? = null, message: String? = loadingDialog.context.getString(R.string.loading_wait)) {
        configureView(title, message)
        loadingDialog.show()
    }

    fun show(@StringRes titleResId: Int, @StringRes messageResId: Int? = R.string.loading_wait) {
        val message = messageResId?.let { context.getString(messageResId) }
        configureView(context.getString(titleResId), message)
        loadingDialog.show()
    }

    fun dismiss() {
        loadingDialog.dismiss()
    }

    fun cancel() {
        loadingDialog.cancel()
    }

}