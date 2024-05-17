package io.cursedfunction.bigtaskenergy.ui.bigtaskdetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.cursedfunction.bigtaskenergy.data.BigTaskEnergyRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class BigTaskDetailViewModel @Inject constructor(
    private val repository: BigTaskEnergyRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState: MutableStateFlow<BigTaskDetailUiState> =
        MutableStateFlow(BigTaskDetailUiState.Loading)
    val uiState: StateFlow<BigTaskDetailUiState> = _uiState.asStateFlow()

}

sealed interface BigTaskDetailUiState {
    data object Loading : BigTaskDetailUiState
    data class Success(val temp: String) : BigTaskDetailUiState
    data class Error(val throwable: Throwable) : BigTaskDetailUiState
}
