package com.alvarado.backpack.domain

import com.alvarado.backpack.data.remote.Repository
import com.alvarado.backpack.domain.model.PostDataModel
import okhttp3.MultipartBody
import java.io.File
import javax.inject.Inject

class SavePostUseCase @Inject constructor(
    private val repository : Repository
) {
    suspend operator fun invoke(token : String, data : PostDataModel, file : MultipartBody.Part? = null) : String =
        repository.savePost(token, data, file)
}