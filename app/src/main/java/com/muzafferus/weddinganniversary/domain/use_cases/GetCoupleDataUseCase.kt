package com.muzafferus.weddinganniversary.domain.use_cases

import com.muzafferus.weddinganniversary.data.repository.Repository
import com.muzafferus.weddinganniversary.domain.model.CoupleData
import kotlinx.coroutines.flow.Flow

class GetCoupleDataUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<ArrayList<CoupleData>> {
        return repository.getCoupleDataState()
    }
}