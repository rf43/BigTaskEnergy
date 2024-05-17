package io.cursedfunction.bigtaskenergy.data

import io.cursedfunction.bigtaskenergy.data.local.database.BigTaskModel
import io.cursedfunction.bigtaskenergy.domain.data.BigTask

fun BigTaskModel.toDomainModel(): BigTask {
    return BigTask(
        id = this.id,
        title = this.title,
        description = this.description,
        isCompleted = this.isCompleted
    )
}

fun List<BigTaskModel>.toModelList(): List<BigTask> {
    return this.map { it.toDomainModel() }
}
