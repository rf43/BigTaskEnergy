package io.cursedfunction.bigtaskenergy.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import io.cursedfunction.bigtaskenergy.ui.bigtask.BigTaskScreen
import io.cursedfunction.bigtaskenergy.ui.bigtask.BigTaskViewModel
import io.cursedfunction.bigtaskenergy.ui.theme.BigTaskEnergyTheme
import kotlinx.serialization.Serializable

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BigTaskEnergyTheme {
                val navController = rememberNavController()

                Surface {
                    NavHost(
                        navController = navController,
                        startDestination = BigTaskScreenRoute
                    ) {
                        composable<BigTaskScreenRoute> {
                            val viewmodel: BigTaskViewModel by viewModels()

                            BigTaskScreen(

                            )
                        }
                    }
                }
            }
        }
    }
}

@Serializable
object BigTaskScreenRoute
