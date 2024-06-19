package com.alvarado.backpack.data.remote.api

import com.alvarado.backpack.data.remote.model.LoginData
import com.alvarado.backpack.data.remote.model.LoginResponse
import com.alvarado.backpack.data.remote.model.PostData
import com.alvarado.backpack.data.remote.model.PostListResponse
import com.alvarado.backpack.data.remote.model.PostResponse
import com.alvarado.backpack.data.remote.model.RegisterData
import com.alvarado.backpack.data.remote.model.RegisterResponse
import com.alvarado.backpack.data.remote.model.UserResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import javax.inject.Inject

class ApiService @Inject constructor(
    private val api : ApiClient
) {
    suspend fun login(data : LoginData) : LoginResponse {
        return withContext(Dispatchers.IO) {
            api.login(data)
        }
    }
    suspend fun register(data : RegisterData) : RegisterResponse {
        return withContext(Dispatchers.IO) {
            api.register(data)
        }
    }
    suspend fun whoami(token : String) : UserResponse {
        return withContext(Dispatchers.IO) {
            api.whoami(token)
        }
    }
    suspend fun getAllPosts(token : String) : PostListResponse {
        return withContext(Dispatchers.IO) {
            api.getAllPosts(token)
        }
    }
    suspend fun getSavedPosts(token : String) : PostListResponse {
        return withContext(Dispatchers.IO) {
            api.getSavedPosts(token)
        }
    }
    suspend fun getOwnPosts(token : String) : PostListResponse {
        return withContext(Dispatchers.IO) {
            api.getOwnPosts(token)
        }
    }
    suspend fun getPostsBySubject(token : String, subjectId : String) : PostListResponse {
        return withContext(Dispatchers.IO) {
            api.getPostsBySubject(token, subjectId)
        }
    }
}