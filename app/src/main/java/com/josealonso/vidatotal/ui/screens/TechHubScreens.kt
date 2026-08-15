package com.josealonso.vidatotal.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.josealonso.vidatotal.ui.NavRoutes

@Composable
fun TechHubScreen(navController: NavHostController) {
    val opciones = listOf(
        Triple("Inventario", Icons.Filled.Devices, NavRoutes.Inventario.route),
        Triple("Mantenimiento", Icons.Filled.Build, NavRoutes.Mantenimiento.route),
        Triple("Cannondale Killer V (Hobby)", Icons.Filled.PedalBike, NavRoutes.Hobby.route)
    )
    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        item { Text("Tech Hub", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold) }
        items(opciones) { (titulo, icono, ruta) ->
            Card(modifier = Modifier.fillMaxWidth(), onClick = { navController.navigate(ruta) }) {
                Row(modifier = Modifier.fillMaxWidth().padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                    Icon(icono, contentDescription = null)
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(titulo)
                }
            }
        }
    }
}

@Composable
fun InventarioScreen() {
    val dispositivos = listOf(
        "Samsung Galaxy S22 (USA, liberado)",
        "Lenovo ThinkPad P14s Gen 1",
        "eGPU / adaptador WWAN",
        "PS4 (reparaciones)"
    )
    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        item { Text("Inventario", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold) }
        items(dispositivos) { d ->
            Card(modifier = Modifier.fillMaxWidth()) {
                Text(d, modifier = Modifier.padding(16.dp))
            }
        }
    }
}

@Composable
fun MantenimientoScreen() {
    val tareas = listOf(
        "Optimización de batería — Galaxy S22",
        "Flasheo de ROM — Galaxy S22",
        "Estabilidad Totalplay para streaming/gaming"
    )
    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        item { Text("Mantenimiento", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold) }
        items(tareas) { t ->
            Card(modifier = Modifier.fillMaxWidth()) {
                Text(t, modifier = Modifier.padding(16.dp))
            }
        }
    }
}

@Composable
fun HobbyBiciScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Cannondale Killer V (R26)", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(12.dp))
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Estado: en restauración", fontWeight = FontWeight.Bold)
                Text("Bitácora de progreso: sin registros aún")
            }
        }
    }
}
