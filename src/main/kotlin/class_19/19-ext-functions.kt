package class_19

/**
 * CLASE 19: EXTENSION FUNCTIONS
 * 
 * Conceptos:
 * - Extension functions - agregar funciones a clases existentes
 * - Extension properties - agregar propiedades
 * - Sintaxis: fun TipoExistente.nuevaFuncion()
 */

// ==========================================
// 1. Extension functions para String
// ==========================================

fun String.isValidEmail(): Boolean {
    return this.contains("@") && this.contains(".")
}

fun String.addSignature(name: String): String {
    return "$this\n\n--\n$name"
}

// ==========================================
// 2. Extension property
// ==========================================

val String.emailDomain: String
    get() = this.substringAfter("@")

// ==========================================
// 3. Data class para ejemplos
// ==========================================

data class Email(
    val subject: String,
    val sender: String,
    val body: String,
    var isRead: Boolean = false
)

// ==========================================
// 4. Extension functions para Email
// ==========================================

fun Email.markAsRead() {
    this.isRead = true
    println("Email '${this.subject}' marcado como leído")
}

fun Email.getSummary(): String {
    return "De: ${this.sender} | Asunto: ${this.subject}"
}

// ==========================================
// 5. Extension functions para List
// ==========================================

fun List<Email>.getUnreadCount(): Int {
    return this.count { !it.isRead }
}

fun List<Email>.filterBySender(sender: String): List<Email> {
    return this.filter { it.sender == sender }
}

fun main() {
    println("=== EXTENSION FUNCTIONS ===")
    
    // ==========================================
    // 6. Usando extensions de String
    // ==========================================
    
    println("\n=== STRING EXTENSIONS ===")
    
    val email = "juan@test.com"
    println("¿Es email válido? ${email.isValidEmail()}")
    println("Dominio: ${email.emailDomain}")
    
    val mensaje = "Hola, ¿cómo estás?"
    val mensajeConFirma = mensaje.addSignature("Juan Pérez")
    println("\nMensaje con firma:\n$mensajeConFirma")
    
    // ==========================================
    // 7. Usando extensions de Email
    // ==========================================
    
    println("\n=== EMAIL EXTENSIONS ===")
    
    val email1 = Email("Reunión", "jefe@empresa.com", "Reunión mañana")
    val email2 = Email("Reporte", "admin@empresa.com", "Reporte mensual")
    
    println("Resumen: ${email1.getSummary()}")
    email1.markAsRead()
    println("¿Está leído? ${email1.isRead}")
    
    // ==========================================
    // 8. Usando extensions de List
    // ==========================================
    
    println("\n=== LIST EXTENSIONS ===")
    
    val emails = listOf(
        Email("Reunión", "jefe@empresa.com", "Reunión", false),
        Email("Reporte", "admin@empresa.com", "Reporte", true),
        Email("Saludo", "jefe@empresa.com", "Hola", false)
    )
    
    println("Emails no leídos: ${emails.getUnreadCount()}")
    
    val emailsDelJefe = emails.filterBySender("jefe@empresa.com")
    println("Emails del jefe: ${emailsDelJefe.size}")
    

    
    // ==========================================
    // EJERCICIO
    // ==========================================
    
    println("\n=== EJERCICIO ===")
    println("Crea extension functions para String:")
    println("1. capitalize() - primera letra mayúscula")
    println("2. wordCount() - contar palabras")
    
    // Solución:
    /*
    fun String.capitalize(): String {
        return if (this.isNotEmpty()) {
            this.first().uppercase() + this.drop(1)
        } else this
    }
    
    fun String.wordCount(): Int {
        return this.split(" ").filter { it.isNotBlank() }.size
    }
    
    val texto = "hola mundo kotlin"
    println("Capitalizado: ${texto.capitalize()}")
    println("Palabras: ${texto.wordCount()}")
    */
}

/**
 * RESUMEN:
 * - Extension functions: fun Tipo.nuevaFuncion() = ...
 * - Extension properties: val Tipo.propiedad get() = ...
 * - No modifican la clase original
 * - Se pueden usar como métodos normales
 */

