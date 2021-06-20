package com.example.empresas_android.ui.holder

import android.app.Activity
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.lifecycle.*
import com.example.empresas_android.ui.block.loading.ILoadingBlock
import com.example.empresas_android.ui.block.login.LoginViewBinder
import com.example.empresas_android.ui.viewmodel.login.ILoginViewModel

class LoginHolder(
    private val activity: Activity,
    private val lifecycleOwner: LifecycleOwner,
    private val loginViewModel: ILoginViewModel,
    private val viewBinder: LoginViewBinder,
    private val loadingBlock: ILoadingBlock
): LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        init()
    }

    private fun init() {
        with(viewBinder) {
            with(loginViewModel){
                loginFormState.observe(lifecycleOwner, Observer {
                    val loginState = it ?: return@Observer

                    loginButton.isEnabled = loginState.isDataValid

                    if (loginState.usernameError != null) {
                        usernameEditText.error = activity.getString(loginState.usernameError)
                    }
                    if (loginState.passwordError != null) {
                        passwordEditText.error = activity.getString(loginState.passwordError)
                    }
                })

                loading.observe(lifecycleOwner, Observer {
                    loadingBlock.setVisibility(it.isLoading)
                })


                loginResult.observe(lifecycleOwner, Observer {
                    val loginResult = it ?: return@Observer

                    if (loginResult.error != null) {
                        showLoginFailed(loginResult.error)
                    }
                    if (loginResult.success != null) {
                        //abrir lista de empresas
                    }
                })

                usernameEditText.afterTextChanged {
                    loginDataChanged(
                        usernameEditText.text.toString(),
                        passwordEditText.text.toString()
                    )
                }

                passwordEditText.apply {
                    afterTextChanged {
                        loginDataChanged(
                            usernameEditText.text.toString(),
                            passwordEditText.text.toString()
                        )
                    }

                    setOnEditorActionListener { _, actionId, _ ->
                        when (actionId) {
                            EditorInfo.IME_ACTION_DONE ->
                                login(
                                    usernameEditText.text.toString(),
                                    passwordEditText.text.toString()
                                )
                        }
                        false
                    }
                }

                loginButton.setOnClickListener {
                    login(usernameEditText.text.toString(), passwordEditText.text.toString())
                }
            }
        }
    }

    private fun showLoginFailed(@StringRes errorString: Int) {
        Toast.makeText(activity, errorString, Toast.LENGTH_SHORT).show()
    }
}

/**
 * Extension function to simplify setting an afterTextChanged action to EditText components.
 */
fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
    })
}