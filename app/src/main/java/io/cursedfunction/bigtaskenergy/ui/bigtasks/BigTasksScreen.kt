package io.cursedfunction.bigtaskenergy.ui.bigtasks

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
