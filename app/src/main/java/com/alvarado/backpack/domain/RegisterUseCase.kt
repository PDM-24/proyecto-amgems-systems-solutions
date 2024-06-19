package com.alvarado.backpack.domain

import com.alvarado.backpack.data.remote.Repository
import com.alvarado.backpack.domain.model.RegisterModel
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val repository : Repository
) {
    suspend operator fun invoke(data : RegisterModel) : String =
        repository.register(data)
}