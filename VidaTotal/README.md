# VidaTotal — App de Gestión Total

Proyecto Android (Kotlin + Jetpack Compose + Room) generado a partir del perfil de
Jose Alonso Contreras Nafarrate. Incluye el sitemap completo y las 5 entidades de
base de datos descritas en el diseño original.

## ⚠️ Sobre el .apk

Este entorno de generación **no tiene Android SDK ni Gradle instalado**, por lo que
no puede compilar el `.apk` directamente. El proyecto está 100% listo para compilar,
tienes dos caminos:

### Opción A — Compilar en tu máquina (Android Studio)
1. Descarga y descomprime este proyecto.
2. Ábrelo con **Android Studio** (Hedgehog o superior).
3. Deja que sincronice Gradle (usa el wrapper incluido, no necesitas instalar nada más).
4. Ve a **Build > Build Bundle(s) / APK(s) > Build APK(s)**.
5. El APK queda en `app/build/outputs/apk/debug/app-debug.apk`.

### Opción B — Compilar en la nube con GitHub Actions (sin instalar nada)
1. Sube esta carpeta a un repositorio nuevo en tu cuenta de GitHub.
2. El workflow ya incluido en `.github/workflows/build-apk.yml` se ejecuta automáticamente
   en cada `push` a `main` (o puedes lanzarlo manualmente desde la pestaña **Actions > Build APK > Run workflow**).
3. Cuando termine (2-4 min), baja el artefacto **VidaTotal-debug-apk** desde esa misma ejecución.
4. Instala el `.apk` en tu Galaxy S22 (activa "Instalar apps desconocidas" en Ajustes).

## Estructura

```
app/src/main/java/com/josealonso/vidatotal/
├── MainActivity.kt
├── data/
│   ├── AppDatabase.kt          # Room DB (5 entidades)
│   ├── entity/                 # Usuario, CuentaFinanciera, Transaccion, Actividad, Dispositivo
│   └── dao/                    # DAOs con queries (incl. MSI por vencer, ahorro por rango)
└── ui/
    ├── VidaTotalNavGraph.kt    # Navegación (bottom bar + sub-rutas)
    ├── NavRoutes.kt            # Sitemap como rutas
    ├── theme/
    └── screens/                # Dashboard, Finanzas, Estilo de Vida, Tech Hub, Perfil
```

## Pendientes para producción
- Conectar Firebase: agrega tu propio `google-services.json` en `app/` y descomenta
  el plugin `com.google.gms.google-services` en `app/build.gradle.kts`.
- Conectar los DAOs a ViewModels con datos reales (actualmente las pantallas muestran
  placeholders "$—" / "sin datos" para que compile de inmediato).
- Implementar el widget Glance para el home (dependencia ya incluida).
- Notificaciones de MSI: usar WorkManager (dependencia ya incluida) + la query
  `obtenerMsiActivos()` de `TransaccionDao`.
