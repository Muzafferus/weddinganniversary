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
            emit(arrayListOf(
                CoupleData("OldCouple", "123", "123456789"),
                CoupleData("NewCouple", "654", "15648979"),
                CoupleData("BestCouple", "789", "12156156"),
                CoupleData("LastCouple", "1594", "11194815"),
                CoupleData("FirstCouple", "9547", "1598454"),
            ))
        }
    }
}