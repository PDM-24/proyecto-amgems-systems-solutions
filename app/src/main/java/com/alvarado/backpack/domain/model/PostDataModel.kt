package com.alvarado.backpack.domain.model

data class PostDataModel(
    val title : String,
    val category : String,
    val subject : String,
    val publicationYear : Int,
    val publicationCycle : Int,
    val topics : String
)
