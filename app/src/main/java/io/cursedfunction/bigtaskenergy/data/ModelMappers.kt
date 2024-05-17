package io.cursedfunction.bigtaskenergy.data

import io.cursedfunction.bigtaskenergy.domain.data.BigTask

fun BigTaskDto.toDomainModel(): BigTask {
    return BigTask(
        id = this.id,
        title = this.title,
        description = this.description,
        isCompleted = this.isCompleted
    )
}

fun List<BigTaskDto>.toModelList(): List<BigTask> {
    return this.map { it.toDomainModel() }
}
