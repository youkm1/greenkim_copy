package com.example.greenkim.api.auth.DTO.Login

import com.google.gson.annotations.SerializedName

data class LoginRequestDto(
    @SerializedName("email")val email:String,
    @SerializedName("password")val password:String,
)
