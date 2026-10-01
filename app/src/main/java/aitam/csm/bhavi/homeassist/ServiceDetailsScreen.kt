package aitam.csm.bhavi.homeassist

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServiceDetailsScreen(
    name: String,
    description: String,
    image: Int,
    price: String,
    onBack: () -> Unit
) {

    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Service Details") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = image),
                contentDescription = name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(name, style = MaterialTheme.typography.titleLarge)

            Spacer(modifier = Modifier.height(8.dp))

            Text(description)

            Spacer(modifier = Modifier.height(8.dp))

            Text("Price: ₹$price")

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {

                    Toast.makeText(
                        context,
                        "Service booked successfully",
                        Toast.LENGTH_SHORT
                    ).show()

                    navController.navigate("payment/$name/$price")
                }
            ) {
                Text("Book Now")
            }
        }
    }
}