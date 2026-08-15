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

data class BalanceItem(val titulo: String, val valor: String, val icono: androidx.compose.ui.graphics.vector.ImageVector)

@Composable
fun DashboardScreen() {
    val balance = listOf(
        BalanceItem("Ahorro del mes (tuppers)", "$—", Icons.Filled.Savings),
        BalanceItem("Horas de estudio", "—h", Icons.Filled.School),
        BalanceItem("Consistencia gym/agua", "—%", Icons.Filled.FitnessCenter)
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text(
                "Hola, Jose Alonso 👋",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
            Text(
                "Balance de Vida",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(top = 4.dp, bottom = 8.dp)
            )
        }

        items(balance) { item ->
            Card(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(item.icono, contentDescription = null)
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(item.titulo)
                    }
                    Text(item.valor, fontWeight = FontWeight.Bold)
                }
            }
        }

        item {
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Próximos MSI a vencer", fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Sin datos aún — agrega tus compras a MSI en el módulo de Finanzas.")
                }
            }
        }
    }
}
