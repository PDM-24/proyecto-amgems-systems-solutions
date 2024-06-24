package com.alvarado.backpack.domain.model

data class UserModel(
    var id : String,
    var carnet : String,
    var name : String,
    var lastname : String,
    var email : String,
    var degree : String,
    var savedPosts : List<String>
) {
    constructor() : this("", "", "", "", "", "", listOf())
}
