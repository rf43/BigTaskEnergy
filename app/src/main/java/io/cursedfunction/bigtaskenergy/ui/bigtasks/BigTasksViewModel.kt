package io.cursedfunction.bigtaskenergy.ui.bigtasks

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.cursedfunction.bigtaskenergy.data.BigTaskEnergyRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class BigTasksViewModel @Inject constructor(
    private val repository: BigTaskEnergyRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState: MutableStateFlow<BigTasksUiState> =
        MutableStateFlow(BigTasksUiState.Loading)
    val uiState: StateFlow<BigTasksUiState> = _uiState.asStateFlow()


}

sealed interface BigTasksUiState {
    data object Loading : BigTasksUiState
    data class Success(val temp: String) : BigTasksUiState
    data class Error(val throwable: Throwable) : BigTasksUiState
}
