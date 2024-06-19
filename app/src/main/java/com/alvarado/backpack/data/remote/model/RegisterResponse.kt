package com.alvarado.backpack.data.remote.model

import com.alvarado.backpack.di.ApiConstants
import com.google.gson.annotations.SerializedName

data class RegisterResponse (
    @SerializedName(value = ApiConstants.REGISTER_RESPONSE_MESSAGE)
    var message: String
)