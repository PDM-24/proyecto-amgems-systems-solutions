package com.alvarado.backpack.data.remote.model

import com.alvarado.backpack.di.ApiConstants
import com.google.gson.annotations.SerializedName

data class LoginData(
    @SerializedName(value = ApiConstants.LOGIN_IDENTIFIER_PARAM)
    var identifier : String,

    @SerializedName(value = ApiConstants.LOGIN_PASSWORD_PARAM)
    var password : String
)
