package com.alvarado.backpack.domain

import com.alvarado.backpack.data.remote.Repository
import com.alvarado.backpack.domain.model.SubjectModel
import javax.inject.Inject

class GetSubjectByDegreeUseCase @Inject constructor(
    private val repository : Repository
) {
    suspend operator fun invoke(token : String) : MutableList<SubjectModel> =
        repository.getSubjectByDegree(token)

}