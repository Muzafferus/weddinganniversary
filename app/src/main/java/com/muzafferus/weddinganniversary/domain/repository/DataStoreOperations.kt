package com.muzafferus.weddinganniversary.domain.repository

import com.muzafferus.weddinganniversary.domain.model.CoupleData
import kotlinx.coroutines.flow.Flow

interface DataStoreOperations {
    fun getCoupleDataState(): Flow<ArrayList<CoupleData>>
}