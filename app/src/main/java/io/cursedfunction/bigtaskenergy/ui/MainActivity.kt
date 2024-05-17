package io.cursedfunction.bigtaskenergy.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import io.cursedfunction.bigtaskenergy.ui.navigation.BigTaskEnergyNavHost
import io.cursedfunction.bigtaskenergy.ui.theme.BigTaskEnergyTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BigTaskEnergyTheme {
                Surface {
                    BigTaskEnergyNavHost(
                        navController = rememberNavController(),
                        activity = this
                    )
                }
            }
        }
    }
}
