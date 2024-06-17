package com.alvarado.backpack.domain

import com.alvarado.backpack.data.remote.Repository
import com.alvarado.backpack.domain.model.UserModel
import javax.inject.Inject

class WhoamiUseCase @Inject constructor(
    private val repository : Repository
) {
    suspend operator fun invoke(token : String) : UserModel =
        repository.whoami(token)
}
