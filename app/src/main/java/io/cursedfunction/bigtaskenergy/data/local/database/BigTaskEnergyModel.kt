package io.cursedfunction.bigtaskenergy.data.local.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BigTaskEnergyModel(
    val name: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
