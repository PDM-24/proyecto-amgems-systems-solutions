package com.alvarado.backpack.data.remote.model

import com.alvarado.backpack.di.ApiConstants
import com.google.gson.annotations.SerializedName

data class ReportData(
    @SerializedName(value = ApiConstants.REPORT_REASON_PARAM)
    val reason : ArrayList<String>,
    @SerializedName(value = ApiConstants.REPORT_POST_PARAM)
    val post : String
)
