package io.cursedfunction.bigtaskenergy.ui.bigtasks

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.cursedfunction.bigtaskenergy.data.BigTaskEnergyRepository
import io.cursedfunction.bigtaskenergy.domain.data.BigTask
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BigTasksViewModel @Inject constructor(
    private val repository: BigTaskEnergyRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState: MutableStateFlow<BigTasksUiState> =
        MutableStateFlow(BigTasksUiState.Loading)
    val uiState: StateFlow<BigTasksUiState> = _uiState.asStateFlow()

    init {
        loadTasks()
    }

    private fun loadTasks() {
        _uiState.update { BigTasksUiState.Loading }

        viewModelScope.launch {
            _uiState.update {
                BigTasksUiState.Success(
                    tasks = repository.getAllTasks()
                )
            }
        }
    }

    fun createTask(title: String, description: String, isCompleted: Boolean = false) {
        viewModelScope.launch {
            repository.createTask(
                title = title,
                description = description,
                isCompleted = isCompleted
            ).let {
                _uiState.update {
                    BigTasksUiState.Success(
                        repository.getAllTasks()
                    )
                }
            }
        }
    }
}

sealed interface BigTasksUiState {
    data object Loading : BigTasksUiState
    data class Success(val tasks: List<BigTask>) : BigTasksUiState
    data class Error(val throwable: Throwable) : BigTasksUiState
}
