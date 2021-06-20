package com.example.empresas_android.data.model


import com.google.gson.annotations.SerializedName

data class Investor(
    @SerializedName("balance")
    val balance: Double,
    @SerializedName("city")
    val city: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("first_access")
    val firstAccess: Boolean,
    @SerializedName("id")
    val id: Int,
    @SerializedName("investor_name")
    val investorName: String,
    @SerializedName("photo")
    val photo: Any,
    @SerializedName("portfolio")
    val portfolio: Portfolio,
    @SerializedName("portfolio_value")
    val portfolioValue: Double,
    @SerializedName("super_angel")
    val superAngel: Boolean
)