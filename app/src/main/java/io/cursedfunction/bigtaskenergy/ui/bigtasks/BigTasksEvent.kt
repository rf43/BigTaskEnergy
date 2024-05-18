package io.cursedfunction.bigtaskenergy.ui.bigtasks

sealed interface BigTasksEvent {
    data object NavigateToDetail: BigTasksEvent
    data class AddBigTask(
        val title: String,
        val description: String,
        val isCompleted: Boolean = false
    ) : BigTasksEvent
}
