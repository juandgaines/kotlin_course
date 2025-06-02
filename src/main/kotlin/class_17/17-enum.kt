package class_17

/**
 * CLASE 17: ENUMS
 * 
 * Conceptos:
 * - enum class - conjunto fijo de constantes
 * - ordinal - posición del enum (0, 1, 2...)
 * - values() - obtener todos los valores
 * - Convertir int a enum
 */

// ==========================================
// 1. Enum básico
// ==========================================

enum class EmailFolder {
    INBOX, SENT, DRAFT, ARCHIVE, SPAM
}

// ==========================================
// 2. Enum con propiedades
// ==========================================

enum class EmailPriority(val level: Int, val color: String) {
    LOW(1, "gray"),
    NORMAL(2, "blue"),
    HIGH(3, "orange"),
    URGENT(4, "red")
}

fun main() {
    println("=== ENUMS EN KOTLIN ===")
    
    // ==========================================
    // 3. Usando enum básico
    // ==========================================
    
    val folder = EmailFolder.INBOX
    println("Carpeta: $folder")
    println("Posición (ordinal): ${folder.ordinal}")
    
    // ==========================================
    // 4. CONVERTIR INT A ENUM
    // ==========================================
    
    println("\n=== CONVERTIR INT A ENUM ===")
    
    // Función para convertir índice a enum
    fun intToFolder(index: Int): EmailFolder? {
        return if (index in 0 until EmailFolder.values().size) {
            EmailFolder.values()[index]
        } else null
    }
    
    println("Índice 0: ${intToFolder(0)}")  // INBOX
    println("Índice 2: ${intToFolder(2)}")  // DRAFT
    println("Índice 10: ${intToFolder(10)}") // null
    
    // ==========================================
    // 5. ITERAR CON ÍNDICES
    // ==========================================
    
    println("\n=== ITERAR CON ÍNDICES ===")
    
    // Mostrar todas las carpetas con su índice
    EmailFolder.values().forEachIndexed { index, folder ->
        println("[$index] $folder")
    }
    
    // ==========================================
    // 6. Ejemplo práctico: Menú
    // ==========================================
    
    println("\n=== MENÚ DE CARPETAS ===")
    
    // Mostrar menú
    println("Selecciona carpeta:")
    EmailFolder.values().forEachIndexed { index, folder ->
        println("$index. $folder")
    }
    
    // Simular selección
    val opcion = 1
    val carpetaSeleccionada = intToFolder(opcion)
    println("Seleccionaste: $carpetaSeleccionada")
    
    // ==========================================
    // 7. Enum con propiedades
    // ==========================================
    
    println("\n=== ENUM CON PROPIEDADES ===")
    
    val priority = EmailPriority.HIGH
    println("Prioridad: $priority")
    println("Nivel: ${priority.level}")
    println("Color: ${priority.color}")
    
    // Buscar por nivel
    val prioridadNivel3 = EmailPriority.values().find { it.level == 3 }
    println("Prioridad nivel 3: $prioridadNivel3")
    
    // ==========================================
    // EJERCICIO
    // ==========================================
    
    println("\n=== EJERCICIO ===")
    println("Crea enum 'EstadoEmail' con: NUEVO, LEIDO, RESPONDIDO")
    println("1. Agrega propiedad 'icono' a cada estado")
    println("2. Crea función para convertir int a EstadoEmail")
    println("3. Muestra todos con índice e icono")
    
    // Solución:
    /*
    enum class EstadoEmail(val icono: String) {
        NUEVO("📧"),
        LEIDO("👁️"),
        RESPONDIDO("↩️")
    }
    
    fun intToEstado(index: Int): EstadoEmail? {
        return if (index in 0 until EstadoEmail.values().size) {
            EstadoEmail.values()[index]
        } else null
    }
    
    EstadoEmail.values().forEachIndexed { index, estado ->
        println("[$index] $estado ${estado.icono}")
    }
    */
}

/**
 * RESUMEN:
 * - enum class - constantes fijas
 * - ordinal - posición automática (0, 1, 2...)
 * - values() - array con todos los valores
 * - values()[index] - convertir int a enum
 * - forEachIndexed() - iterar con índice
 */

