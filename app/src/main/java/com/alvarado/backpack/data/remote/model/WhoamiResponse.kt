package com.alvarado.backpack.data.remote.model

import com.alvarado.backpack.di.ApiConstants
import com.google.gson.annotations.SerializedName

data class WhoamiResponse(
    @SerializedName(value = ApiConstants.WHOAMI_ID_PARAM)
    var id : String,
    @SerializedName(value = ApiConstants.WHOAMI_CARNET_PARAM)
    var carnet : String,
    @SerializedName(value = ApiConstants.WHOAMI_NAME_PARAM)
    var name : String,
    @SerializedName(value = ApiConstants.WHOAMI_LASTNAME_PARAM)
    var lastname : String,
    @SerializedName(value = ApiConstants.WHOAMI_EMAIL_PARAM)
    var email : String,
    @SerializedName(value = ApiConstants.WHOAMI_DEGREE_PARAM)
    var degree : String
)
