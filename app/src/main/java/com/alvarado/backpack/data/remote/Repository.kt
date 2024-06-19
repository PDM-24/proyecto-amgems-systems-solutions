package com.alvarado.backpack.data.remote

import com.alvarado.backpack.data.remote.api.ApiService
import com.alvarado.backpack.data.remote.model.LoginData
import com.alvarado.backpack.data.remote.model.RegisterData
import com.alvarado.backpack.domain.model.LoginModel
import com.alvarado.backpack.domain.model.PostModel
import com.alvarado.backpack.domain.model.RegisterModel
import com.alvarado.backpack.domain.model.UserModel
import com.alvarado.backpack.util.convertToPostModel
import com.alvarado.backpack.util.convertToUserModel
import javax.inject.Inject

class Repository @Inject constructor(
    private val api : ApiService
) {
    suspend fun login(data : LoginModel) : String {
        val loginData = LoginData(
            data.login,
            data.password
        )
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
        val userModel = convertToUserModel(whoAmIResponse)
        return userModel
    }

    suspend fun getAllPosts(token : String) : MutableList<PostModel> {
        val response = api.getAllPosts(token)
        val postModelList = response.posts.map{ convertToPostModel(it) }.toMutableList()
        return postModelList
    }

    suspend fun getSavedPosts(token : String) : MutableList<PostModel> {
        val response = api.getSavedPosts(token)
        val postModelList = response.posts.map{ convertToPostModel(it) }.toMutableList()
        return postModelList
    }

    suspend fun getOwnPosts(token : String) : MutableList<PostModel> {
        val response = api.getOwnPosts(token)
        val postModelList = response.posts.map{ convertToPostModel(it) }.toMutableList()
        return postModelList
    }

    suspend fun getPostsBySubject(token : String, subjectId : String) : MutableList<PostModel> {
        val response = api.getPostsBySubject(token, subjectId)
        val postModelList = response.posts.map{ convertToPostModel(it) }.toMutableList()
        return postModelList
    }
}