package io.cursedfunction.bigtaskenergy.data.local.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "bigtasks"
)
data class BigTaskModel(
    var title: String,
    var description: String,
    var isCompleted: Boolean
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
