package com.muzafferus.weddinganniversary.data.repository

import android.content.Context
import com.muzafferus.weddinganniversary.domain.model.CoupleData
import com.muzafferus.weddinganniversary.domain.repository.DataStoreOperations
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DataStoreOperationsImpl(context: Context) : DataStoreOperations {

    override fun getCoupleDataState(): Flow<ArrayList<CoupleData>> {
        val flowValue: Flow<ArrayList<CoupleData>>
        return flow {
            emit(arrayListOf(CoupleData("CoupleName", "CoupleId", "123456789")))
        }
    }
}