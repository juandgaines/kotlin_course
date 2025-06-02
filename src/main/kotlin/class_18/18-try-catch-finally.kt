package class_18

/**
 * CLASE 18: TRY-CATCH-FINALLY
 * 
 * Conceptos:
 * - try-catch-finally - manejo de excepciones
 * - IndexOutOfBoundsException - error de índice
 * - Excepciones personalizadas
 */

// ==========================================
// 1. Excepción personalizada
// ==========================================

class EmailInvalidException(message: String) : Exception(message)

fun main() {
    println("=== MANEJO DE EXCEPCIONES ===")
    
    // ==========================================
    // 2. IndexOutOfBoundsException
    // ==========================================
    
    println("\n=== INDEX OUT OF BOUNDS ===")
    
    val emails = listOf("juan@test.com", "maria@test.com", "pedro@test.com")
    
    // Ejemplo CON manejo de excepción
    try {
        println("Email 1: ${emails[1]}")     // OK
        println("Email 10: ${emails[10]}")   // Error
    } catch (e: IndexOutOfBoundsException) {
        println("❌ Error: Índice no válido")
    } finally {
        println("✅ Operación completada")
    }
    
    // ==========================================
    // 3. Función segura
    // ==========================================
    
    fun getEmailSafe(emails: List<String>, index: Int): String? {
        return try {
            emails[index]
        } catch (e: IndexOutOfBoundsException) {
            println("Índice $index no existe")
            null
        }
    }
    
    println("\nAcceso seguro:")
    println("Email 0: ${getEmailSafe(emails, 0)}")
    println("Email 5: ${getEmailSafe(emails, 5)}")
    
    // ==========================================
    // 4. Excepción personalizada
    // ==========================================
    
    println("\n=== EXCEPCIÓN PERSONALIZADA ===")
    

    
    // Probar diferentes emails
    val testEmails = listOf("juan@test.com", "invalido", "a@b")
    
    for (email in testEmails) {
        try {
            validateEmail(email)
        } catch (e: EmailInvalidException) {
            println("❌ '$email': ${e.message}")
        } finally {
            println("Validación de '$email' terminada")
        }
    }
    
    // ==========================================
    // 5. Ejemplo práctico
    // ==========================================
    
    println("\n=== EJEMPLO PRÁCTICO ===")
    

    
    val manager = EmailManager()
    
    // Agregar emails
    manager.addEmail("usuario@email.com")
    manager.addEmail("invalido")
    manager.addEmail("test@test.com")
    
    println("\nEmails guardados:")
    manager.showEmails()
    
    println("\nAcceso por índice:")
    println("Email 0: ${manager.getEmail(0)}")
    println("Email 5: ${manager.getEmail(5)}")
    
    // ==========================================
    // EJERCICIO
    // ==========================================
    
    println("\n=== EJERCICIO ===")
    println("Crea función 'dividir(a, b)' que maneje división por cero")
    
    // Solución:
    /*
    fun dividir(a: Int, b: Int): Double? {
        return try {
            (a.toDouble() / b).also { println("$a ÷ $b = $it") }
        } catch (e: ArithmeticException) {
            println("Error: División por cero")
            null
        } finally {
            println("División completada")
        }
    }
    
    dividir(10, 2)
    dividir(10, 0)
    */
}
fun validateEmail(email: String) {
    if (!email.contains("@")) {
        throw EmailInvalidException("Debe contener @")
    }
    if (email.length < 5) {
        throw EmailInvalidException("Muy corto")
    }
    println("✅ Email válido: $email")
}

class EmailManager {
    private val emails = mutableListOf<String>()

    fun addEmail(email: String): Boolean {
        return try {
            validateEmail(email)
            emails.add(email)
            println("Agregado: $email")
            true
        } catch (e: EmailInvalidException) {
            println("Error: ${e.message}")
            false
        }
    }

    fun getEmail(index: Int): String? {
        return try {
            emails[index]
        } catch (e: IndexOutOfBoundsException) {
            println("Índice $index no válido")
            null
        }
    }

    fun showEmails() {
        emails.forEachIndexed { index, email ->
            println("[$index] $email")
        }
    }
}
/**
 * RESUMEN:
 * - try-catch-finally - manejo de errores
 * - IndexOutOfBoundsException - índice inválido
 * - Excepciones personalizadas: class MiException(message) : Exception(message)
 * - finally - siempre se ejecuta
 */

