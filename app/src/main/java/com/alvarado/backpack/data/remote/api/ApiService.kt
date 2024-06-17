package com.alvarado.backpack.data.remote.api

import com.alvarado.backpack.data.remote.model.LoginData
import com.alvarado.backpack.data.remote.model.LoginResponse
import com.alvarado.backpack.data.remote.model.RegisterData
import com.alvarado.backpack.data.remote.model.RegisterResponse
import com.alvarado.backpack.data.remote.model.WhoamiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
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

    suspend fun whoami(token : String) : WhoamiResponse {
        return withContext(Dispatchers.IO) {
            api.whoami(token)
        }
    }
}