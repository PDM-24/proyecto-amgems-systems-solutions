package com.alvarado.backpack.data.remote.api

import com.alvarado.backpack.data.remote.model.LoginData
import com.alvarado.backpack.data.remote.model.LoginResponse
import com.alvarado.backpack.data.remote.model.RegisterData
import com.alvarado.backpack.data.remote.model.RegisterResponse
import com.alvarado.backpack.data.remote.model.WhoamiResponse
import com.alvarado.backpack.di.ApiConstants
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiClient {
    @Headers(value = ["Content-Type: application/json"])
    @POST(value = ApiConstants.API_PATH + ApiConstants.LOGIN_PATH)
    suspend fun login(@Body data : LoginData) : LoginResponse

    @Headers(value = ["Content-Type: application/json"])
    @POST(value = ApiConstants.API_PATH + ApiConstants.REGISTER_PATH)
    suspend fun register(@Body data : RegisterData) : RegisterResponse

    @Headers(value = ["Content-Type: application/json"])
    @GET(value = ApiConstants.API_PATH + ApiConstants.WHOAMI_PATH)
    suspend fun whoami(@Header(value = "Authorization") token : String) : WhoamiResponse
}