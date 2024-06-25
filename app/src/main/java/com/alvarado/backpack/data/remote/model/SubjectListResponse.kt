package com.alvarado.backpack.data.remote.model

import com.google.gson.annotations.SerializedName

data class SubjectListResponse(
    @SerializedName("subjects")
    val subjects : ArrayList<SubjectResponse>
)
