package class_10

/**
 * CLASE 10: CONDICIONALES (if/else)
 * 
 * Conceptos:
 * - if - ejecutar código si condición es true
 * - else - ejecutar código si condición es false
 * - else if - múltiples condiciones
 * - if como expresión (devuelve valor)
 * - Combinando con funciones y readLine()
 */

// ==========================================
// Funciones auxiliares (usando conceptos previos)
// ==========================================

fun leerEmail(): String {
    print("Ingresa un email: ")
    return readLine()?.trim() ?: "sin-email@ejemplo.com"
}

fun leerPassword(): String {
    print("Ingresa una contraseña: ")
    return readLine()?.trim() ?: "1234"
}

fun main() {
    // ==========================================
    // 1. if básico (sin else)
    // ==========================================
    
    val email = "usuario@email.com"
    
    // if = "si la condición es true, ejecuta este código"
    if (email.contains("@")) {
        println("✅ El email tiene formato válido")
    }
    
    // ==========================================
    // 2. if/else (dos opciones)
    // ==========================================
    
    val password = "123"
    
    // if/else = "si es true haz esto, si no haz esto otro"
    if (password.length >= 6) {
        println("✅ Contraseña segura")
    } else {
        println("❌ Contraseña muy corta")
    }
    
    // ==========================================
    // 3. if/else if (múltiples condiciones)
    // ==========================================
    
    val longitudPassword = password.length
    
    if (longitudPassword >= 8) {
        println("🔒 Contraseña fuerte")
    } else if (longitudPassword >= 6) {
        println("🔐 Contraseña media")
    } else {
        println("🔓 Contraseña débil")
    }
    
    // ==========================================
    // 4. if como expresión (devuelve valor)
    // ==========================================
    
    // if puede devolver un valor y guardarlo en variable
    val estadoEmail = if (email.contains("@")) "Válido" else "Inválido"
    println("Estado del email: $estadoEmail")
    
    val nivelSeguridad = if (password.length >= 8) {
        "Alto"
    } else if (password.length >= 6) {
        "Medio"
    } else {
        "Bajo"
    }
    println("Nivel de seguridad: $nivelSeguridad")
    
    // ==========================================
    // 5. Función con condicionales
    // ==========================================
    
    fun validarCredenciales(email: String, password: String): String {
        if (email.contains("@")) {
            if (password.length >= 4) {
                return "✅ Credenciales válidas"
            } else {
                return "❌ Contraseña muy corta"
            }
        } else {
            return "❌ Email inválido"
        }
    }
    
    // ==========================================
    // 6. Ejemplo interactivo
    // ==========================================
    
    println("\n=== VALIDADOR DE CREDENCIALES ===")
    
    val emailUsuario = leerEmail()
    val passwordUsuario = leerPassword()
    
    val resultado = validarCredenciales(emailUsuario, passwordUsuario)
    println(resultado)
    
    // Verificar tipo de email
    if (emailUsuario.contains("gmail")) {
        println("📧 Email de Gmail detectado")
    } else if (emailUsuario.contains("yahoo")) {
        println("📧 Email de Yahoo detectado")
    } else {
        println("📧 Otro proveedor de email")
    }
    
    // ==========================================
    // EJERCICIO
    // ==========================================
    
    println("\n=== EJERCICIO ===")
    println("Crea una función llamada 'clasificarEmail' que:")
    println("1. Reciba un email como parámetro")
    println("2. Use if/else if para clasificar:")
    println("   - Si contiene 'admin': 'Administrador'")
    println("   - Si contiene 'support': 'Soporte'")
    println("   - Si no: 'Usuario normal'")
    println("3. Devuelva la clasificación")
    
    // Solución:
    /*
    fun clasificarEmail(email: String): String {
        if (email.contains("admin")) {
            return "Administrador"
        } else if (email.contains("support")) {
            return "Soporte"
        } else {
            return "Usuario normal"
        }
    }
    
    // Pruebas:
    println(clasificarEmail("admin@empresa.com"))      // Administrador
    println(clasificarEmail("support@empresa.com"))    // Soporte
    println(clasificarEmail("juan@empresa.com"))       // Usuario normal
    */
}

/**
 * RESUMEN:
 * - if (condicion) { codigo } - ejecuta si es true
 * - if/else - dos opciones
 * - if/else if/else - múltiples opciones
 * - val resultado = if (condicion) "valor1" else "valor2"
 */


