package com.alvarado.backpack.data.remote.api

import com.alvarado.backpack.data.remote.model.LoginData
import com.alvarado.backpack.data.remote.model.LoginResponse
import com.alvarado.backpack.data.remote.model.MessgeOk
import com.alvarado.backpack.data.remote.model.PostListResponse
import com.alvarado.backpack.data.remote.model.PostResponse
import com.alvarado.backpack.data.remote.model.RegisterData
import com.alvarado.backpack.data.remote.model.RegisterResponse
import com.alvarado.backpack.data.remote.model.ReportData
import com.alvarado.backpack.data.remote.model.ReportResponse
import com.alvarado.backpack.data.remote.model.SubjectListResponse
import com.alvarado.backpack.data.remote.model.SubjectResponse
import com.alvarado.backpack.data.remote.model.UserResponse
import com.alvarado.backpack.di.ApiConstants
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

interface ApiClient {
    @Headers(value = ["Content-Type: application/json"])
    @POST(value = ApiConstants.API_PATH + ApiConstants.LOGIN_PATH)
    suspend fun login(
        @Body data : LoginData
    ) : LoginResponse

    @Headers(value = ["Content-Type: application/json"])
    @POST(value = ApiConstants.API_PATH + ApiConstants.REGISTER_PATH)
    suspend fun register(
        @Body data : RegisterData
    ) : RegisterResponse

    @Headers(value = ["Content-Type: application/json"])
    @GET(value = ApiConstants.API_PATH + ApiConstants.WHOAMI_PATH)
    suspend fun whoami(
        @Header(value = "authorization") token : String
    ) : UserResponse

    @Headers(value = ["Content-Type: application/json"])
    @GET(value = ApiConstants.API_PATH + ApiConstants.POST_ALL_PATH)
    suspend fun getAllPosts(
        @Header(value = "authorization") token : String
    ) : PostListResponse

    @Headers(value = ["Content-Type: application/json"])
    @GET(value = ApiConstants.API_PATH + ApiConstants.POST_SAVED_PATH)
    suspend fun getSavedPosts(
        @Header(value = "authorization") token : String
    ) : PostListResponse

    @Headers(value = ["Content-Type: application/json"])
    @GET(value = ApiConstants.API_PATH + ApiConstants.POST_OWNER_PATH)
    suspend fun getOwnPosts(
        @Header(value = "authorization") token : String
    ) : PostListResponse

    @Headers(value = ["Content-Type: application/json"])
    @GET(value = ApiConstants.API_PATH + ApiConstants.POST_SUBJECT_PATH + "/{identifier}")
    suspend fun getPostsBySubject(
        @Header(value = "authorization") token : String,
        @Path(value = "identifier") subjectId : String
    ) : PostListResponse

    @Multipart
    @POST(value = ApiConstants.API_PATH + ApiConstants.POST_SAVE_PATH)
    suspend fun savePost(
        @Header(value = "authorization") token : String,
        @Part file : MultipartBody.Part? = null,
        @Part(ApiConstants.POST_TITLE_PARAM) title: RequestBody,
        @Part(ApiConstants.POST_TOPICS_PARAM) topics: RequestBody,
        @Part(ApiConstants.POST_PUBLICATION_YEAR_PARAM) publicationYear: RequestBody,
        @Part(ApiConstants.POST_PUBLICATION_CYCLE_PARAM) publicationCycle: RequestBody,
        @Part(ApiConstants.POST_CATEGORY_PARAM) category: RequestBody,
        @Part(ApiConstants.POST_SUBJECT_PARAM) subject: RequestBody
    ) : MessgeOk

    @PATCH(value = ApiConstants.API_PATH + ApiConstants.POST_FAVORITE_PATH + "/{identifier}")
    suspend fun favoritePost(
        @Header(value = "authorization") token : String,
        @Path(value = "identifier") postId : String
    ) : PostResponse

    @GET(value = ApiConstants.API_PATH + ApiConstants.SUBJECT_DEGREE_PATH)
    suspend fun getSubjectByDegree(
        @Header(value = "authorization") token : String
    ) : SubjectListResponse

    @POST(value = ApiConstants.API_PATH + ApiConstants.REPORT_PATH)
    suspend fun saveReport(
        @Header(value = "authorization") token : String,
        @Body data : ReportData
    ) : ReportResponse
}