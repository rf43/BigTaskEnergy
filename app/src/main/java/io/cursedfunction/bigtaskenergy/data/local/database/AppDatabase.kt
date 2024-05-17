package io.cursedfunction.bigtaskenergy.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BigTaskModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bigTaskEnergyDao(): BigTaskEnergyDao
}
