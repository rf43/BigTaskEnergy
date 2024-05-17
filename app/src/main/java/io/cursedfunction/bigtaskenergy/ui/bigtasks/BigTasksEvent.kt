package io.cursedfunction.bigtaskenergy.ui.bigtasks

sealed interface BigTasksEvent {
    data object NavigateToDetail: BigTasksEvent
}
