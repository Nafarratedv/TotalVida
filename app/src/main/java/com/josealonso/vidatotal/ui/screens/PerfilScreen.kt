package com.josealonso.vidatotal.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun PerfilScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Perfil", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(12.dp))
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Jose Alonso Contreras Nafarrate", fontWeight = FontWeight.Bold)
                Text("Ingeniería en Sistemas Computacionales (UVEG)")
                Text("Santiago de Querétaro, Qro.")
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Sincronización", fontWeight = FontWeight.Bold)
                Text("Firebase: no configurado (agrega google-services.json)")
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Widget de Home", fontWeight = FontWeight.Bold)
                Text("Configuración de widget minimalista: próximamente")
            }
        }
    }
}
