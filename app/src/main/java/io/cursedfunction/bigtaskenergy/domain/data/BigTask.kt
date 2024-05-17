package io.cursedfunction.bigtaskenergy.domain.data

data class BigTask(
    val id: Long,
    val title: String = "",
    val description: String = "",
    val isCompleted: Boolean = false
)
