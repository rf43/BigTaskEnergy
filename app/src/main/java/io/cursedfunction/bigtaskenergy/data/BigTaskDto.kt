package io.cursedfunction.bigtaskenergy.data

data class BigTaskDto(
    val id: String,
    val title: String = "",
    val description: String = "",
    val isCompleted: Boolean = false
)
