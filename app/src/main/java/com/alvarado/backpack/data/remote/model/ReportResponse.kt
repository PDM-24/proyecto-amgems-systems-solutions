package com.alvarado.backpack.data.remote.model

import com.alvarado.backpack.di.ApiConstants
import com.google.gson.annotations.SerializedName

data class ReportResponse (
    @SerializedName(value = ApiConstants.REPORT_RESPONSE_MESSAGE)
    val message : String
)