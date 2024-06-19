package com.alvarado.backpack.domain.model

data class RegisterModel(
    var carnet : String,
    var name : String,
    var lastname : String,
    var email : String,
    var degree : String,
    var password : String
) {
    constructor() : this("", "", "", "", "", "")
}
