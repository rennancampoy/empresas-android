package com.example.empresas_android.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.empresas_android.R
import com.example.empresas_android.data.dependencyInjection.DataKodein
import com.example.empresas_android.data.dependencyInjection.ViewModelFactory
import com.example.empresas_android.ui.block.error.SnackErrorBlock
import com.example.empresas_android.ui.block.loading.LoadingBlock
import com.example.empresas_android.ui.block.login.LoginViewBinder
import com.example.empresas_android.ui.holder.LoginHolder
import com.example.empresas_android.ui.utils.DrawableClickListener
import com.example.empresas_android.ui.viewmodel.login.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.view.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        DataKodein.setup(applicationContext)

        initHolder()
    }

    private fun initHolder() {
        val rootView: ViewGroup = findViewById(android.R.id.content)
        rootView.password.changeDrawableColor(
            R.color.text_color,
            DrawableClickListener.DrawablePosition.RIGHT
        )
        val holder = LoginHolder(
            this,
            this,
            ViewModelProvider(
                this,
                ViewModelFactory
            ).get(LoginViewModel::class.java),
            LoginViewBinder(rootView),
            LoadingBlock(this),
            SnackErrorBlock(rootView)
        )
        this.lifecycle.addObserver(holder)
    }
}

