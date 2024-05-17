package io.cursedfunction.bigtaskenergy.ui.bigtaskdetail

sealed interface BigTaskDetailEvent {
    data object NavigateBack: BigTaskDetailEvent
}
