package com.alvarado.backpack.data.remote

import com.alvarado.backpack.data.remote.api.ApiService
import com.alvarado.backpack.data.remote.model.LoginData
import com.alvarado.backpack.data.remote.model.RegisterData
import com.alvarado.backpack.domain.model.LoginModel
import com.alvarado.backpack.domain.model.RegisterModel
import com.alvarado.backpack.domain.model.UserModel
import javax.inject.Inject

class Repository @Inject constructor(
    private val api : ApiService
) {
    suspend fun login(data : LoginModel) : String {
        val loginData = LoginData(data.login, data.password)
        return api.login(loginData).token
    }

    suspend fun register(data : RegisterModel) : String {
        val registerData = RegisterData(
            data.carnet,
            data.name,
            data.lastname,
            data.email,
            data.degree,
            data.password
        )
        return api.register(registerData).message
    }

    suspend fun whoami(token : String) : UserModel {
        val whoAmIResponse = api.whoami(token)
        val userModel = UserModel(
            id = whoAmIResponse.id,
            carnet = whoAmIResponse.id,
            name = whoAmIResponse.name,
            lastname = whoAmIResponse.lastname,
            email = whoAmIResponse.email,
            degree = whoAmIResponse.degree
        )
        return userModel
    }
}