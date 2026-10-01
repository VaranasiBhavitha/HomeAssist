package aitam.csm.bhavi.homeassist

import android.widget.Toast
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServiceScreen(navController: NavController) {

    val context = LocalContext.current

    val servicesList = listOf(
        Service(
            "Electrician",
            "We provide fan, light, wiring, and switchboard repairs. Certified electricians ensure safety at your home.",
            R.drawable.electrician,
            "500"
        ),
        Service(
            "Plumber",
            "Fix leaking taps, clogged drains, pipe replacements, and bathroom plumbing issues. Quick and reliable service.",
            R.drawable.plumber,
            "400"
        ),
        Service(
            "AC Repair",
            "Full air conditioner servicing including cooling performance check, gas refill, and maintenance for all AC types.",
            R.drawable.ac,
            "1200"
        ),
        Service(
            "Home Cleaning",
            "Deep cleaning for bedrooms, kitchens, bathrooms, and living areas. Includes dusting, mopping, and sanitizing surfaces.",
            R.drawable.cleaning,
            "500"

        ),
        Service(
            "Carpenter",
            "Furniture assembly, repair, and custom woodwork. Quality craftsmanship for cupboards, doors, tables, and chairs.",
            R.drawable.carpenter,
            "1500"

        ),
        Service(
            "Painting",
            "Interior and exterior painting services with eco-friendly paints. Professional finish for your home or office walls.",
            R.drawable.painting,
            "2000"
        ),
        Service(
            "Pest Control",
            "Safe and effective pest removal including termites, mosquitoes, cockroaches, and rodents. Keep your home healthy.",
            R.drawable.pestcontrol,
            "500"
        ),
        Service(
            "Appliance Repair",
            "Repair of home appliances such as refrigerators, washing machines, microwaves, and geysers by skilled technicians.",
            R.drawable.appliance,
            "500"
        ),
        Service(
            "Gardening",
            "Lawn mowing, plant care, landscaping, and garden maintenance to keep your outdoor spaces beautiful and neat.",
            R.drawable.gardening,
            "450"

        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Homeassist") },
                navigationIcon = {
                    IconButton(onClick = {
                        Toast.makeText(context, "menu clicked", Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(Icons.Default.Menu, contentDescription = "menu")
                    }
                },
                actions = {
                    IconButton(onClick = {
                        Toast.makeText(
                            context,
                            "Homeassist - Trusted home services",
                            Toast.LENGTH_SHORT
                        ).show()
                    }) {
                        Icon(Icons.Default.Info, contentDescription = "info")
                    }
                }
            )
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(12.dp)
        ) {
            items(servicesList) { service ->

                    ServiceItem(service) {

                        // Navigate to details screen


                        val encodedName = URLEncoder.encode(service.name, StandardCharsets.UTF_8.toString())
                        val encodedDesc = URLEncoder.encode(service.description, StandardCharsets.UTF_8.toString())
                        val encodedPrice = URLEncoder.encode(service.price, StandardCharsets.UTF_8.toString())
                        navController.navigate(
                            "details/$encodedName/$encodedDesc/${service.image}/$encodedPrice"
                        )
                    }

            }
        }
    }
}

@Composable
fun ServiceItem(
    service: Service,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick() }
            .animateContentSize(),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = service.image),
                contentDescription = service.name,
                modifier = Modifier.size(64.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = service.name,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = service.description,
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = service.price,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

/* -------- PREVIEW -------- */

@Preview(showBackground = true)
@Composable
fun ServiceScreenPreview() {
    ServiceItem(
        service = Service(
            name = "Electrician",
            description = "Fan & light repairs",
            image = R.drawable.electrician,
            "500"
        ),
        onClick = {}
    )
}
