package com.alvarado.backpack.domain

import com.alvarado.backpack.data.remote.Repository
import com.alvarado.backpack.domain.model.LoginModel
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository : Repository
) {
    suspend operator fun invoke(data : LoginModel) : String =
        repository.login(data)
}