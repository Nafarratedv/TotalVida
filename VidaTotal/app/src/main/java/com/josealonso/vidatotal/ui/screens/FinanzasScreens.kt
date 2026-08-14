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
fun FinanzasScreen(navController: NavHostController) {
    val opciones = listOf(
        Triple("Tarjetas (BBVA / Nu / Invex)", Icons.Filled.CreditCard, NavRoutes.FinanzasTarjetas.route),
        Triple("Compras y MSI", Icons.Filled.ShoppingBag, NavRoutes.FinanzasCompras.route),
        Triple("Monitor de Precios", Icons.Filled.TrendingDown, NavRoutes.FinanzasPrecios.route)
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text("Finanzas", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
            Card(modifier = Modifier.fillMaxWidth().padding(top = 12.dp)) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Ingreso quincenal: $5,000 MXN", fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("Ahorro por tuppers vs. gasto en calle: pendiente de registrar")
                }
            }
        }
        items(opciones) { (titulo, icono, ruta) ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                onClick = { navController.navigate(ruta) }
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(icono, contentDescription = null)
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(titulo)
                }
            }
        }
    }
}

@Composable
fun TarjetasScreen() {
    val tarjetas = listOf("BBVA", "Nu", "Invex")
    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        item { Text("Tarjetas", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold) }
        items(tarjetas) { banco ->
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(banco, fontWeight = FontWeight.Bold)
                    Text("Saldo disponible: $—")
                }
            }
        }
    }
}

@Composable
fun ComprasMsiScreen() {
    val compras = listOf("Combo perfumes Lattafa/Abercrombie", "Calzado Flexi/Adidas")
    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        item { Text("Compras y MSI", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold) }
        items(compras) { compra ->
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(compra, fontWeight = FontWeight.Bold)
                    Text("Detalle de MSI: pendiente de captura")
                }
            }
        }
    }
}

@Composable
fun MonitorPreciosScreen() {
    val plataformas = listOf("Amazon", "AliExpress", "Mercado Libre")
    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        item { Text("Monitor de Precios", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold) }
        items(plataformas) { plataforma ->
            Card(modifier = Modifier.fillMaxWidth()) {
                Row(modifier = Modifier.fillMaxWidth().padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(plataforma)
                    Text("Sin productos monitoreados")
                }
            }
        }
    }
}
