package com.josealonso.vidatotal.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.josealonso.vidatotal.ui.screens.*

private fun iconFor(route: NavRoutes) = when (route) {
    NavRoutes.Dashboard -> Icons.Filled.Home
    NavRoutes.Finanzas -> Icons.Filled.AttachMoney
    NavRoutes.EstiloVida -> Icons.Filled.FitnessCenter
    NavRoutes.TechHub -> Icons.Filled.Build
    NavRoutes.Perfil -> Icons.Filled.Person
    else -> Icons.Filled.Home
}

@Composable
fun VidaTotalApp() {
    val navController: NavHostController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                bottomNavItems.forEach { item ->
                    NavigationBarItem(
                        icon = { Icon(iconFor(item), contentDescription = item.label) },
                        label = { Text(item.label) },
                        selected = currentRoute == item.route,
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NavRoutes.Dashboard.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(NavRoutes.Dashboard.route) { DashboardScreen() }
            composable(NavRoutes.Finanzas.route) { FinanzasScreen(navController) }
            composable(NavRoutes.EstiloVida.route) { EstiloVidaScreen(navController) }
            composable(NavRoutes.TechHub.route) { TechHubScreen(navController) }
            composable(NavRoutes.Perfil.route) { PerfilScreen() }

            composable(NavRoutes.FinanzasTarjetas.route) { TarjetasScreen() }
            composable(NavRoutes.FinanzasCompras.route) { ComprasMsiScreen() }
            composable(NavRoutes.FinanzasPrecios.route) { MonitorPreciosScreen() }

            composable(NavRoutes.Gym.route) { GymScreen() }
            composable(NavRoutes.Hidratacion.route) { HidratacionScreen() }
            composable(NavRoutes.Transporte.route) { TransporteScreen() }
            composable(NavRoutes.Entretenimiento.route) { EntretenimientoScreen() }

            composable(NavRoutes.Inventario.route) { InventarioScreen() }
            composable(NavRoutes.Mantenimiento.route) { MantenimientoScreen() }
            composable(NavRoutes.Hobby.route) { HobbyBiciScreen() }
        }
    }
}
