package com.example.empresas_android.ui.holder

import android.app.Activity
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.lifecycle.*
import com.example.empresas_android.R
import com.example.empresas_android.ui.block.error.IErrorBlock
import com.example.empresas_android.ui.block.loading.ILoadingBlock
import com.example.empresas_android.ui.block.login.LoginViewBinder
import com.example.empresas_android.ui.utils.DrawableClickListener
import com.example.empresas_android.ui.utils.DrawableClickListener.DrawablePosition
import com.example.empresas_android.ui.viewmodel.login.ILoginViewModel
import kotlinx.android.synthetic.main.activity_login.view.*


class LoginHolder(
    private val activity: Activity,
    private val lifecycleOwner: LifecycleOwner,
    private val loginViewModel: ILoginViewModel,
    private val viewBinder: LoginViewBinder,
    private val loadingBlock: ILoadingBlock,
    private val errorBlock: IErrorBlock
): LifecycleObserver {
    private var isPasswordVisible = false

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        init()
    }

    private fun init() {
        with(viewBinder) {
            passwordEditText.setDrawableClickListener(object : DrawableClickListener {
                override fun onClick(target: DrawablePosition?) {
                    when (target) {
                        DrawablePosition.RIGHT -> {
                            isPasswordVisible = !isPasswordVisible

                            passwordEditText.inputType = if(isPasswordVisible) {
                                InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                            } else
                                (InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
                            passwordEditText.setSelection(passwordEditText.length())
                        }
                        else -> {}
                    }
                }
            })

            with(loginViewModel) {
                error.observe(lifecycleOwner, Observer {
                    when (it.tag) {
                        ILoginViewModel.Tag.LOGIN -> errorBlock.showError(R.string.login_failed)
                    }
                })

                loading.observe(lifecycleOwner, Observer {
                    loadingBlock.setVisibility(it.isLoading)
                })

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

                loginResult.observe(lifecycleOwner, Observer {
                    if (it.success != null) {
                        //TODO: abrir lista de empresas
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