package com.alvarado.backpack.domain.model

data class PostModel(
    var id : String,
    var title : String,
    var url : String,
    var category : String,
    var subject : SubjectModel,
    var publicationYear : Int,
    var publicationCycle : String,
    var hidden : Boolean,
    var topics : ArrayList<String>,
    var author : UserModel
)
