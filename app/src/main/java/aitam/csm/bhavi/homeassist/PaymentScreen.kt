package aitam.csm.bhavi.homeassist

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun PaymentScreen(
    serviceName: String,
    price: String,
    navController: NavController
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text("Payment Screen", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(20.dp))

        Text("Service: $serviceName")
        Text("Amount: ₹$price")

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                navController.navigate("success")
            }
        ) {
            Text("Pay Now")
        }
    }
}