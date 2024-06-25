package com.alvarado.backpack.data.remote.model

import com.alvarado.backpack.di.ApiConstants
import com.google.gson.annotations.SerializedName

data class SubjectResponse(
    @SerializedName(value = ApiConstants.SUBJECT_ID_PARAM)
    var id : String,
    @SerializedName(value = ApiConstants.SUBJECT_CODE_PARAM)
    var code : String,
    @SerializedName(value = ApiConstants.SUBJECT_NAME_PARAM)
    var name : String,
    @SerializedName(value = ApiConstants.SUBJECT_IMAGE_PARAM)
    val image : String
)
