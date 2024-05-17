package io.cursedfunction.bigtaskenergy.ui.navigation

import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import io.cursedfunction.bigtaskenergy.ui.bigtaskdetail.BigTaskDetailEvent
import io.cursedfunction.bigtaskenergy.ui.bigtaskdetail.BigTaskDetailScreen
import io.cursedfunction.bigtaskenergy.ui.bigtaskdetail.BigTaskDetailScreenRoute
import io.cursedfunction.bigtaskenergy.ui.bigtaskdetail.BigTaskDetailViewModel
import io.cursedfunction.bigtaskenergy.ui.bigtasks.BigTasksEvent
import io.cursedfunction.bigtaskenergy.ui.bigtasks.BigTasksScreen
import io.cursedfunction.bigtaskenergy.ui.bigtasks.BigTasksScreenRoute
import io.cursedfunction.bigtaskenergy.ui.bigtasks.BigTasksViewModel

@Composable
fun BigTaskEnergyNavHost(
    navController: NavHostController,
    activity: ComponentActivity
) {
    with(activity) {
        NavHost(
            navController = navController,
            startDestination = BigTasksScreenRoute
        ) {
            composable<BigTasksScreenRoute> {
                val viewmodel: BigTasksViewModel by viewModels()

                BigTasksScreen(
                    state = viewmodel.uiState.collectAsState().value,
                    modifier = Modifier.fillMaxSize(),
                    onEvent = { event ->
                        when(event) {
                            BigTasksEvent.NavigateToDetail -> {
                                navController.navigate(BigTaskDetailScreenRoute)
                            }
                        }
                    }
                )
            }

            composable<BigTaskDetailScreenRoute> {
                val viewModel: BigTaskDetailViewModel by viewModels()

                BigTaskDetailScreen(
                    state = viewModel.uiState.collectAsState().value,
                    modifier = Modifier.fillMaxSize(),
                    onEvent = { event ->
                        when(event) {
                            BigTaskDetailEvent.NavigateBack -> {
                                navController.navigate(BigTasksScreenRoute)
                            }
                        }
                    }
                )
            }
        }
    }
}
