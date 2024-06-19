package com.alvarado.backpack.data.remote.model

import com.alvarado.backpack.di.ApiConstants
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName(value = ApiConstants.LOGIN_RESPONSE_TOKEN)
    var token : String
)