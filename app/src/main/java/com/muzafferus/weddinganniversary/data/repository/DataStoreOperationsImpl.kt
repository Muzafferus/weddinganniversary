package com.muzafferus.weddinganniversary.data.repository

import android.content.Context
import com.muzafferus.weddinganniversary.domain.model.CoupleData
import com.muzafferus.weddinganniversary.domain.repository.DataStoreOperations
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DataStoreOperationsImpl() : DataStoreOperations {

    override fun getCoupleDataState(): Flow<ArrayList<CoupleData>> {
        return flow {
            emit(arrayListOf(
                CoupleData("OldCouple", "123", "2017-02-01 18:00:25"),
                CoupleData("NewCouple", "654", "2022-07-10 18:00:25"),
                CoupleData("BestCouple", "789", "2019-03-02 18:00:25"),
                CoupleData("LastCouple", "1594", "2010-02-20 18:00:25"),
                CoupleData("FirstCouple", "9547", "2021-07-10 18:00:25"),
            ))
        }
    }
}