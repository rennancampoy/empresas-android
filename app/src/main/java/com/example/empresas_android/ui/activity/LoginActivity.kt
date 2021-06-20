package com.example.empresas_android.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.empresas_android.R
import com.example.empresas_android.data.dependencyInjection.DataKodein
import com.example.empresas_android.data.dependencyInjection.ViewModelFactory
import com.example.empresas_android.ui.block.loading.LoadingBlock
import com.example.empresas_android.ui.block.login.LoginViewBinder
import com.example.empresas_android.ui.holder.LoginHolder
import com.example.empresas_android.ui.viewmodel.login.LoginViewModel

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        DataKodein.setup()

        initHolder()
    }

    private fun initHolder() {
        val rootView: ViewGroup = findViewById(android.R.id.content)
        val holder = LoginHolder(
            this,
            this,
            ViewModelProvider(
                this,
                ViewModelFactory
            ).get(LoginViewModel::class.java),
            LoginViewBinder(rootView),
            LoadingBlock(this)
        )
        this.lifecycle.addObserver(holder)
    }
}


