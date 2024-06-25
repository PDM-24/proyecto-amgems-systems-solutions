package com.alvarado.backpack.data.remote.api

import com.alvarado.backpack.data.remote.model.LoginData
import com.alvarado.backpack.data.remote.model.LoginResponse
import com.alvarado.backpack.data.remote.model.MessgeOk
import com.alvarado.backpack.data.remote.model.PostData
import com.alvarado.backpack.data.remote.model.PostListResponse
import com.alvarado.backpack.data.remote.model.PostResponse
import com.alvarado.backpack.data.remote.model.RegisterData
import com.alvarado.backpack.data.remote.model.RegisterResponse
import com.alvarado.backpack.data.remote.model.ReportData
import com.alvarado.backpack.data.remote.model.ReportResponse
import com.alvarado.backpack.data.remote.model.SubjectListResponse
import com.alvarado.backpack.data.remote.model.UserResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
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
    suspend fun favoritePost(token : String, postId : String) : PostResponse {
        return withContext(Dispatchers.IO) {
            api.favoritePost(token, postId)
        }
    }
    suspend fun getSubjectsByDegree(token : String) : SubjectListResponse {
        return withContext(Dispatchers.IO) {
            api.getSubjectByDegree(token)
        }
    }
    suspend fun saveReport(token : String, data : ReportData) : ReportResponse {
        return withContext(Dispatchers.IO) {
            api.saveReport(token, data)
        }
    }
    suspend fun savePost(token : String, data : PostData, file : MultipartBody.Part? = null) : MessgeOk {
        return withContext(Dispatchers.IO) {
            val titlePart = data.title.toRequestBody("text/plain".toMediaTypeOrNull())
            val topicsPart = data.topics.toRequestBody("text/plain".toMediaTypeOrNull())
            val publicationYearPart = data.publicationYear.toString().toRequestBody("text/plain".toMediaTypeOrNull())
            val publicationCyclePart = data.publicationCycle.toString().toRequestBody("text/plain".toMediaTypeOrNull())
            val categoryPart = data.category.toRequestBody("text/plain".toMediaTypeOrNull())
            val subjectPart = data.subject.toRequestBody("text/plain".toMediaTypeOrNull())

            api.savePost(
                token,
                file,
                titlePart,
                topicsPart,
                publicationYearPart,
                publicationCyclePart,
                categoryPart,
                subjectPart
            )
        }
    }
}