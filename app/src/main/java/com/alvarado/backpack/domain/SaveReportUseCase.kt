package com.alvarado.backpack.domain

import com.alvarado.backpack.data.remote.Repository
import com.alvarado.backpack.domain.model.ReportModel
import javax.inject.Inject

class SaveReportUseCase @Inject constructor(
    private val repository : Repository
) {
    suspend operator fun invoke(token : String, data : ReportModel)
        = repository.saveReport(token, data)
}