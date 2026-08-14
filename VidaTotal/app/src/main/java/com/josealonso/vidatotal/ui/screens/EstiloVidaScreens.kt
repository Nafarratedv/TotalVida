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
fun EstiloVidaScreen(navController: NavHostController) {
    val opciones = listOf(
        Triple("Gym", Icons.Filled.FitnessCenter, NavRoutes.Gym.route),
        Triple("Hidratación", Icons.Filled.WaterDrop, NavRoutes.Hidratacion.route),
        Triple("Transporte (Qrobus / DiDi)", Icons.Filled.DirectionsBus, NavRoutes.Transporte.route),
        Triple("Entretenimiento", Icons.Filled.Movie, NavRoutes.Entretenimiento.route)
    )
    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        item { Text("Estilo de Vida", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold) }
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
fun GymScreen() {
    val ejercicios = listOf("Tríceps", "Pull over")
    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        item { Text("Gym", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold) }
        items(ejercicios) { ej ->
            Card(modifier = Modifier.fillMaxWidth()) {
                Text(ej, modifier = Modifier.padding(16.dp))
            }
        }
    }
}

@Composable
fun HidratacionScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Hidratación", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(12.dp))
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Botellas de 2L registradas hoy: 0")
                Text("Meta diaria sugerida: 2 botellas (4L)")
            }
        }
    }
}

@Composable
fun TransporteScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Transporte", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(12.dp))
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Tarjeta Qrobus", fontWeight = FontWeight.Bold)
                Text("Saldo: $— · Últimas recargas: sin datos")
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("DiDi", fontWeight = FontWeight.Bold)
                Text("Historial de viajes: sin datos")
            }
        }
    }
}

@Composable
fun EntretenimientoScreen() {
    val secciones = listOf("Cartelera Cinépolis (4DX / VIP)", "Series (sin temas oscuros/ocultismo)", "Biblioteca Steam")
    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        item { Text("Entretenimiento", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold) }
        items(secciones) { sec ->
            Card(modifier = Modifier.fillMaxWidth()) {
                Text(sec, modifier = Modifier.padding(16.dp))
            }
        }
    }
}
