package com.alvarado.backpack.data.remote.model

import com.alvarado.backpack.di.ApiConstants
import com.google.gson.annotations.SerializedName

data class PostListResponse(
    @SerializedName(value = ApiConstants.POST_LIST_PARAM)
    val posts: ArrayList<PostResponse>
)
