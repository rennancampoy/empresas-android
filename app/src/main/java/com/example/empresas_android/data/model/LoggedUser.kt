package com.example.empresas_android.data.model


import com.google.gson.annotations.SerializedName

data class LoggedUser(
    @SerializedName("enterprise")
    val enterprise: Any,
    @SerializedName("investor")
    val investor: Investor,
    @SerializedName("success")
    val success: Boolean
)