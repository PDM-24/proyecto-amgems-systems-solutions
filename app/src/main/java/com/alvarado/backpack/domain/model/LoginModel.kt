package com.alvarado.backpack.domain.model

data class LoginModel(
    var login : String,
    var password : String
) {
    constructor() : this("", "")
}
