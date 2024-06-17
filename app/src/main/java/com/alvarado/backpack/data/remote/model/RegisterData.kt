package com.alvarado.backpack.data.remote.model

import com.alvarado.backpack.di.ApiConstants
import com.google.gson.annotations.SerializedName

data class RegisterData(
    @SerializedName(value = ApiConstants.REGISTER_CARNET_PARAM)
    var carnet : String,
    @SerializedName(value = ApiConstants.REGISTER_NAME_PARAM)
    var name : String,
    @SerializedName(value = ApiConstants.REGISTER_LASTNAME_PARAM)
    var lastname : String,
    @SerializedName(value = ApiConstants.REGISTER_EMAIL_PARAM)
    var email : String,
    @SerializedName(value = ApiConstants.REGISTER_DEGREE_PARAM)
    var degree : String,
    @SerializedName(value = ApiConstants.REGISTER_PASSWORD_PARAM)
    var password : String
)
