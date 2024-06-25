package com.alvarado.backpack.domain

import com.alvarado.backpack.data.remote.Repository
import com.alvarado.backpack.domain.model.PostModel
import javax.inject.Inject

class GetPostsBySubjectUseCase @Inject constructor (
    private val repository : Repository
) {
    suspend operator fun invoke(token : String, subjectId : String) : MutableList<PostModel> =
        repository.getPostsBySubject(token, subjectId)
}