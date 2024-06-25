package com.alvarado.backpack.domain

import com.alvarado.backpack.data.remote.Repository
import com.alvarado.backpack.domain.model.PostModel
import javax.inject.Inject

class FavoritePostUseCase @Inject constructor(
    private val repository : Repository
) {
    suspend operator fun invoke(token : String, postId : String) : String =
        repository.favoritePost(token, postId)
}