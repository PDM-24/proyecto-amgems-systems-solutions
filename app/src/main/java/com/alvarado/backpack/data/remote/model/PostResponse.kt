package com.alvarado.backpack.data.remote.model

import com.alvarado.backpack.di.ApiConstants
import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName(value = ApiConstants.POST_ID_PARAM)
    var id : String,
    @SerializedName(value = ApiConstants.POST_TITLE_PARAM)
    var title : String,
    @SerializedName(value = ApiConstants.POST_URL_PARAM)
    var url : String,
    @SerializedName(value = ApiConstants.POST_CATEGORY_PARAM)
    var category : String,
    @SerializedName(value = ApiConstants.POST_SUBJECT_PARAM)
    var subject : SubjectResponse,
    @SerializedName(value = ApiConstants.POST_PUBLICATION_YEAR_PARAM)
    var publicationYear : Int,
    @SerializedName(value = ApiConstants.POST_PUBLICATION_CYCLE_PARAM)
    var publicationCycle : String,
    @SerializedName(value = ApiConstants.POST_HIDDEN_PARAM)
    var hidden : Boolean,
    @SerializedName(value = ApiConstants.POST_TOPICS_PARAM)
    var topics : ArrayList<String>,
    @SerializedName(value = ApiConstants.POST_AUTHOR_PARAM)
    var author : UserResponse
)
