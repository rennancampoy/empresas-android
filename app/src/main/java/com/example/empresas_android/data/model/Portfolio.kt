package com.example.empresas_android.data.model


import com.google.gson.annotations.SerializedName

data class Portfolio(
    @SerializedName("enterprises")
    val enterprises: List<Any>,
    @SerializedName("enterprises_number")
    val enterprisesNumber: Int
)