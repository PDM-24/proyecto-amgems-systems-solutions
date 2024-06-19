package com.alvarado.backpack.data.remote.model

import com.alvarado.backpack.di.ApiConstants
import com.google.gson.annotations.SerializedName
import java.io.File

data class PostData(
    var title : String,
    var category : String,
    var subject : SubjectResponse,
    var publicationYear : Int,
    var publicationCycle : String,
    var topics : ArrayList<String>
)
