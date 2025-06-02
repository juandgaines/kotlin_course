package class_15

/**
 * CLASE 15: GETTERS Y SETTERS
 * 
 * Conceptos:
 * - get() - controlar cómo se lee una propiedad
 * - set() - controlar cómo se modifica una propiedad
 * - Propiedades calculadas
 * - Validación automática
 */

// ==========================================
// 1. Clase Email con getters y setters
// ==========================================

class Email(remitente: String, mensaje: String) {
    // Setter con validación
    var asunto: String = ""
        set(value) {
            field = if (value.trim().isNotEmpty()) value.trim() else "Sin asunto"
        }
    
    // Getter con formato
    var remitente: String = remitente
        get() = field.lowercase()
    
    var mensaje: String = mensaje
    var leido: Boolean = false
    
    // Propiedad calculada
    val esImportante: Boolean
        get() = asunto.contains("urgente", ignoreCase = true)
    
    fun mostrarInfo() {
        println("De: $remitente | Asunto: $asunto | Importante: $esImportante")
    }
}

// ==========================================
// 2. Clase con validación de rango
// ==========================================

class ConfiguracionEmail {
    var maxEmails: Int = 10
        set(value) {
            field = if (value in 1..100) value else 10
        }
    
    var emailsEnviados: Int = 0
    
    val emailsRestantes: Int
        get() = maxEmails - emailsEnviados
}

fun main() {
    println("=== GETTERS Y SETTERS ===")
    
    // ==========================================
    // 3. Probando getters y setters
    // ==========================================
    
    val email = Email("ADMIN@EMPRESA.COM", "Mensaje del sistema")
    
    // Probar setter con validación
    email.asunto = "   "  // Vacío → "Sin asunto"
    println("Asunto vacío: '${email.asunto}'")
    
    email.asunto = "  REUNIÓN URGENTE  "  // Con espacios
    println("Asunto limpio: '${email.asunto}'")
    
    // Probar getter con formato
    println("Remitente: ${email.remitente}")  // Siempre minúsculas
    
    // Probar propiedad calculada
    email.mostrarInfo()
    
    // ==========================================
    // 4. Validación de rango
    // ==========================================
    
    val config = ConfiguracionEmail()
    
    config.maxEmails = 50   // Válido
    println("Max emails: ${config.maxEmails}")
    
    config.maxEmails = 150  // Inválido → 10
    println("Max emails después de 150: ${config.maxEmails}")
    
    config.emailsEnviados = 5
    println("Emails restantes: ${config.emailsRestantes}")
    
    // ==========================================
    // 5. Ejemplo interactivo
    // ==========================================
    
    print("Ingresa asunto: ")
    val asuntoInput = readLine()?.trim() ?: ""
    
    val emailUsuario = Email("usuario@email.com", "Mensaje")
    emailUsuario.asunto = asuntoInput  // Usará validación automática
    emailUsuario.mostrarInfo()
    
    // ==========================================
    // EJERCICIO
    // ==========================================
    
    println("\n=== EJERCICIO ===")
    println("Crea clase 'Contacto' con:")
    println("- Setter para email: validar que contenga '@'")
    println("- Propiedad calculada 'esValido'")
    
    // Solución:
    /*
    class Contacto(val nombre: String) {
        var email: String = ""
            set(value) {
                field = if (value.contains("@")) value else "invalido@email.com"
            }
        
        val esValido: Boolean
            get() = email.contains("@") && email != "invalido@email.com"
    }
    
    val contacto = Contacto("Juan")
    contacto.email = "juan@email.com"
    println("Email: ${contacto.email}, Válido: ${contacto.esValido}")
    */
}

/**
 * RESUMEN:
 * - set(value) { field = ... } - validar al escribir
 * - get() = field.formato - formatear al leer
 * - val propiedad get() = calculo - propiedades calculadas
 * - field - valor interno de la propiedad
 */

