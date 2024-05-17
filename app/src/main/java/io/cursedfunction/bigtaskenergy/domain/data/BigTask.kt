package io.cursedfunction.bigtaskenergy.domain.data

data class BigTask(
    val id: String,
    val title: String = "",
    val description: String = "",
    val isCompleted: Boolean = false
)
