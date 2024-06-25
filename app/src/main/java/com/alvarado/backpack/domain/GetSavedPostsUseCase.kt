package com.alvarado.backpack.domain

import com.alvarado.backpack.data.remote.Repository
import com.alvarado.backpack.domain.model.PostModel
import javax.inject.Inject

class GetSavedPostsUseCase @Inject constructor(
    private val repository : Repository
) {
    suspend operator fun invoke(token : String) : MutableList<PostModel> =
        repository.getSavedPosts(token)
}