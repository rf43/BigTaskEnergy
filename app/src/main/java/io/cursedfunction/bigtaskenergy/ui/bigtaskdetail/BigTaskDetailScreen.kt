package io.cursedfunction.bigtaskenergy.ui.bigtaskdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.cursedfunction.bigtaskenergy.ui.bigtaskdetail.BigTaskDetailEvent.NavigateBack
import kotlinx.serialization.Serializable

@Serializable
object BigTaskDetailScreenRoute

@Composable
fun BigTaskDetailScreen(
    state: BigTaskDetailUiState,
    modifier: Modifier = Modifier,
    onEvent: (BigTaskDetailEvent) -> Unit
) {
    Scaffold(modifier = modifier) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Text(text = "Big Task Energy Detail Screen")
            Button(onClick = { onEvent(NavigateBack) }) {
                Text(text = "Go Back To BigTasks Screen")
            }
        }
    }
}
