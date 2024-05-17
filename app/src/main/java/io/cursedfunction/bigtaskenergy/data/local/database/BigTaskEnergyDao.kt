package io.cursedfunction.bigtaskenergy.data.local.database

import androidx.room.Dao
import io.cursedfunction.bigtaskenergy.data.BigTaskDto

@Dao
interface BigTaskEnergyDao {
    suspend fun fetchAll(): List<BigTaskDto>
}
