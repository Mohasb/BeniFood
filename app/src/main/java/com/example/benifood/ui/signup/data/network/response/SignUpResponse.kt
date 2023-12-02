package com.example.benifood.ui.signup.data.network.response

import com.google.gson.annotations.SerializedName

data class SignUpResponse(
    @SerializedName("id") val id: String,
    @SerializedName("aud") val aud: String,
    @SerializedName("role") val role: String,
    @SerializedName("email") val email: String,
    @SerializedName("phone") val phone: String
) {

}