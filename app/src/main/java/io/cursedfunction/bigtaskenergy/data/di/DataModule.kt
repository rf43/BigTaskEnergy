package io.cursedfunction.bigtaskenergy.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.cursedfunction.bigtaskenergy.data.BigTaskEnergyRepository
import io.cursedfunction.bigtaskenergy.data.DefaultBigTaskEnergyRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Singleton
    @Binds
    fun bindsBigTaskRepository(
        bigTaskRepository: DefaultBigTaskEnergyRepository
    ): BigTaskEnergyRepository
}
