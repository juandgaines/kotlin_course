package class_11

/**
 * CLASE 11: WHEN (alternativa a if/else if)
 * 
 * Conceptos:
 * - when - alternativa elegante a if/else if múltiples
 * - when con valores específicos
 * - when con verificación de tipos (is)
 * - Smart casting automático
 */

// ==========================================
// Funciones auxiliares (de clases anteriores)
// ==========================================

fun leerEmail(): String {
    print("Ingresa un email: ")
    return readLine()?.trim() ?: "usuario@ejemplo.com"
}

fun main() {
    // ==========================================
    // 1. Recordando if/else if (Clase 10)
    // ==========================================
    
    val email = "admin@empresa.com"
    
    // Así lo hacíamos con if/else if:
    val tipoUsuarioIf = if (email.contains("admin")) {
        "Administrador"
    } else if (email.contains("support")) {
        "Soporte"
    } else {
        "Usuario normal"
    }
    
    // Con when (más elegante):
    val tipoUsuarioWhen = when {
        email.contains("admin") -> "Administrador"
        email.contains("support") -> "Soporte"
        else -> "Usuario normal"
    }
    
    println("Con if/else if: $tipoUsuarioIf")
    println("Con when: $tipoUsuarioWhen")
    
    // ==========================================
    // 2. when con valores específicos
    // ==========================================
    
    val proveedor = "gmail"
    
    val descripcionProveedor = when (proveedor) {
        "gmail" -> "📧 Google Mail"
        "yahoo" -> "📧 Yahoo Mail"
        "outlook" -> "📧 Microsoft Outlook"
        else -> "📧 Otro proveedor"
    }
    
    println("Proveedor: $descripcionProveedor")
    
    // ==========================================
    // 3. when con verificación de tipos (Smart Casting)
    // ==========================================
    
    // Any = puede ser cualquier tipo de dato
    fun procesarDatoEmail(dato: Any): String {
        return when (dato) {
            is String -> "Texto: ${dato.length} caracteres"    // Smart cast a String
            is Int -> "Número: $dato"                          // Smart cast a Int
            is Boolean -> if (dato) "Verdadero" else "Falso"   // Smart cast a Boolean
            else -> "Tipo desconocido"
        }
    }
    
    // Probando con diferentes tipos
    println("\n=== VERIFICACIÓN DE TIPOS ===")
    println(procesarDatoEmail("usuario@email.com"))    // String
    println(procesarDatoEmail(25))                     // Int
    println(procesarDatoEmail(true))                   // Boolean
    println(procesarDatoEmail(3.14))                   // Otro tipo
    
    // ==========================================
    // 4. Función con when para clasificar
    // ==========================================
    
    fun clasificarEmail(email: String): String {
        return when {
            email.contains("admin") -> "👑 Administrador"
            email.contains("support") -> "🛠️ Soporte"
            email.contains("test") -> "⚠️ Prueba"
            else -> "👤 Usuario normal"
        }
    }
    
    // ==========================================
    // 5. Ejemplo interactivo
    // ==========================================
    
    println("\n=== CLASIFICADOR DE EMAILS ===")
    print("Ingresa un email: ")
    val emailUsuario = readLine()?.trim() ?: "usuario@ejemplo.com"
    
    val clasificacion = clasificarEmail(emailUsuario)
    println("Clasificación: $clasificacion")
    
    // Validar con when
    val estadoEmail = when {
        !emailUsuario.contains("@") -> "❌ Formato inválido"
        emailUsuario.length < 5 -> "❌ Muy corto"
        else -> "✅ Email válido"
    }
    
    println("Estado: $estadoEmail")
    
    // ==========================================
    // EJERCICIO
    // ==========================================
    
    println("\n=== EJERCICIO ===")
    println("Crea una función 'evaluarPassword' que use when para:")
    println("1. Si longitud >= 8: 'Fuerte'")
    println("2. Si longitud >= 6: 'Media'")
    println("3. Si no: 'Débil'")
    
    // Solución:
    /*
    fun evaluarPassword(password: String): String {
        return when {
            password.length >= 8 -> "Fuerte"
            password.length >= 6 -> "Media"
            else -> "Débil"
        }
    }
    
    println(evaluarPassword("123"))        // Débil
    println(evaluarPassword("123456"))     // Media
    println(evaluarPassword("12345678"))   // Fuerte
    */
}

/**
 * RESUMEN:
 * - when { } - alternativa elegante a if/else if múltiples
 * - when (variable) { valor -> resultado } - comparar valores específicos
 * - is Tipo -> verificar tipo de dato (smart casting automático)
 * - else -> valor por defecto
 */

