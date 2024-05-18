package io.cursedfunction.bigtaskenergy.ui.bigtasks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.cursedfunction.bigtaskenergy.ui.bigtasks.BigTasksEvent.NavigateToDetail
import io.cursedfunction.bigtaskenergy.ui.theme.BigTaskEnergyTheme
import kotlinx.serialization.Serializable

@Serializable
object BigTasksScreenRoute

@Composable
fun BigTasksScreen(
    state: BigTasksUiState,
    modifier: Modifier = Modifier,
    onEvent: (BigTasksEvent) -> Unit
) {
    Scaffold(modifier = modifier) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Greeting(
                name = "Android"
            )
            Button(onClick = { onEvent(NavigateToDetail) }) {
                Text(text = "Click Me!")
            }
            Button(
                onClick = {
                    onEvent(
                        BigTasksEvent.AddBigTask(
                            title = "Item",
                            description = "A description of a big task that has big task energy"
                        )
                    )
                }
            ) {
                Text(text = "Add New Task")
            }
            Spacer(modifier = Modifier.height(8.dp))
            if (state is BigTasksUiState.Success) {
                LazyColumn(
                    state = rememberLazyListState()
                ){
                    items(state.tasks.size) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 12.dp)
                                .background(Color(0xFFB9B9B9))
                                .padding(
                                    vertical = 16.dp,
                                    horizontal = 18.dp
                                )
                        ) {
                            Text(
                                style = MaterialTheme.typography.titleLarge,
                                text = state.tasks[it].title
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                style = MaterialTheme.typography.bodyMedium,
                                text = state.tasks[it].description
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
private fun GreetingPreview() {
    BigTaskEnergyTheme {
        Greeting("Android")
    }
}
