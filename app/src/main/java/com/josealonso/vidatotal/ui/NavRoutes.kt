package com.josealonso.vidatotal.ui

sealed class NavRoutes(val route: String, val label: String) {
    data object Dashboard : NavRoutes("dashboard", "Inicio")
    data object Finanzas : NavRoutes("finanzas", "Finanzas")
    data object EstiloVida : NavRoutes("estilo_vida", "Vida")
    data object TechHub : NavRoutes("tech_hub", "Tech")
    data object Perfil : NavRoutes("perfil", "Perfil")

    // Sub-rutas de Finanzas
    data object FinanzasTarjetas : NavRoutes("finanzas/tarjetas", "Tarjetas")
    data object FinanzasCompras : NavRoutes("finanzas/compras", "Compras y MSI")
    data object FinanzasPrecios : NavRoutes("finanzas/precios", "Monitor de Precios")

    // Sub-rutas de Estilo de Vida
    data object Gym : NavRoutes("estilo_vida/gym", "Gym")
    data object Hidratacion : NavRoutes("estilo_vida/hidratacion", "Hidratación")
    data object Transporte : NavRoutes("estilo_vida/transporte", "Transporte")
    data object Entretenimiento : NavRoutes("estilo_vida/entretenimiento", "Entretenimiento")

    // Sub-rutas de Tech Hub
    data object Inventario : NavRoutes("tech_hub/inventario", "Inventario")
    data object Mantenimiento : NavRoutes("tech_hub/mantenimiento", "Mantenimiento")
    data object Hobby : NavRoutes("tech_hub/hobby", "Cannondale Killer V")
}

val bottomNavItems = listOf(
    NavRoutes.Dashboard,
    NavRoutes.Finanzas,
    NavRoutes.EstiloVida,
    NavRoutes.TechHub,
    NavRoutes.Perfil
)
