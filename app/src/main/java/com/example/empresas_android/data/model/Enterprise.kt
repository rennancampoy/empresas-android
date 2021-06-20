package com.example.empresas_android.data.model


import com.google.gson.annotations.SerializedName

data class EnterpriseList(
    @SerializedName("enterprises")
    val enterprises: List<Enterprise>
)

data class Enterprise(
    @SerializedName("country")
    val country: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("enterprise_name")
    val enterpriseName: String,
    @SerializedName("enterprise_type")
    val enterpriseType: EnterpriseType,
    @SerializedName("id")
    val id: Int,
    @SerializedName("photo")
    val photo: String
)