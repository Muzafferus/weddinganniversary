package com.muzafferus.weddinganniversary.di

import android.content.Context
import com.muzafferus.weddinganniversary.data.repository.DataStoreOperationsImpl
import com.muzafferus.weddinganniversary.data.repository.Repository
import com.muzafferus.weddinganniversary.domain.repository.DataStoreOperations
import com.muzafferus.weddinganniversary.domain.use_cases.GetCoupleDataUseCase
import com.muzafferus.weddinganniversary.domain.use_cases.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreOperations(): DataStoreOperations {
        return DataStoreOperationsImpl()
    }

    @Provides
    @Singleton
    fun provideUseCases(
        repository: Repository
    ): UseCases {
        return UseCases(
            getCoupleDataUseCase = GetCoupleDataUseCase(repository)
        )
    }

}