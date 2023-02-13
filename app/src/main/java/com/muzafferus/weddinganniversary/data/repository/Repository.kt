package com.muzafferus.weddinganniversary.data.repository

import com.muzafferus.weddinganniversary.domain.model.CoupleData
import com.muzafferus.weddinganniversary.domain.repository.DataStoreOperations
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val dataStore: DataStoreOperations
) {

    fun getCoupleDataState(): Flow<ArrayList<CoupleData>> {
        return dataStore.getCoupleDataState()
    }

}