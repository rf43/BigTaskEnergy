package io.cursedfunction.bigtaskenergy.data.local.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.cursedfunction.bigtaskenergy.data.local.database.AppDatabase
import io.cursedfunction.bigtaskenergy.data.local.database.BigTaskEnergyDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideBigTaskEnergyDao(appDatabase: AppDatabase): BigTaskEnergyDao {
        return appDatabase.bigTaskEnergyDao()
    }

    @Provides
    @Singleton
    fun provideBigTaskEnergyRepository(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "BigTaskEnergy"
        ).build()
    }
}
