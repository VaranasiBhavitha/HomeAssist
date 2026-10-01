package aitam.csm.bhavi.homeassist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            Surface(color = MaterialTheme.colorScheme.background) {
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        ServiceScreen(navController)
                    }
                    composable("details/{serviceName}/{serviceDesc}/{serviceImage}") { backStackEntry ->
                        val serviceName = backStackEntry.arguments?.getString("serviceName") ?: ""
                        val serviceDesc = backStackEntry.arguments?.getString("serviceDesc") ?: ""
                        val serviceImage =
                            backStackEntry.arguments?.getString("serviceImage")?.toInt() ?: 0
                        val servicePrice = backStackEntry.arguments?.getString("servicePrice") ?: ""


                        ServiceDetailsScreen(
                            name = serviceName,
                            description = serviceDesc,
                            image = serviceImage,
                            price = servicePrice,
                            onBack = { navController.popBackStack() }
                        )
                    }
                }
            }
        }
    }
}
