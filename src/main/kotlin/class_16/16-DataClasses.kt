package class_16

/**
 * CLASE 16: DATA CLASSES
 * 
 * Conceptos:
 * - data class - clases optimizadas para datos
 * - toString(), equals(), hashCode(), copy() automáticos
 * - Comparación vs clases normales
 */

// ==========================================
// 1. Clase normal vs Data Class
// ==========================================

class EmailNormal(val asunto: String, val remitente: String)

data class Email(val asunto: String, val remitente: String, var leido: Boolean = false)

fun main() {
    println("=== DATA CLASSES ===")
    
    // ==========================================
    // 2. Creando objetos iguales
    // ==========================================
    
    val emailNormal1 = EmailNormal("Reunión", "jefe@empresa.com")
    val emailNormal2 = EmailNormal("Reunión", "jefe@empresa.com")
    
    val email1 = Email("Reunión", "jefe@empresa.com")
    val email2 = Email("Reunión", "jefe@empresa.com")
    
    // ==========================================
    // 3. toString() automático
    // ==========================================
    
    println("\n1. toString() AUTOMÁTICO:")
    println("Clase normal: $emailNormal1")  // Dirección en memoria
    println("Data class: $email1")          // Contenido legible
    
    // ==========================================
    // 4. equals() automático
    // ==========================================
    
    println("\n2. equals() AUTOMÁTICO:")
    println("Clases normales iguales: ${emailNormal1 == emailNormal2}")  // false
    println("Data classes iguales: ${email1 == email2}")                 // true
    
    // ==========================================
    // 5. copy() automático
    // ==========================================
    
    println("\n3. copy() AUTOMÁTICO:")
    val emailCopia = email1.copy(asunto = "URGENTE: Reunión", leido = true)
    
    println("Original: $email1")
    println("Copia: $emailCopia")
    
    // ==========================================
    // 6. Destructuring
    // ==========================================
    
    println("\n4. DESTRUCTURING:")
    val (asunto1, remitente, leido) = email1
    println("Extraído - Asunto: $asunto1, De: $remitente")
    
    // ==========================================
    // 7. Ejemplo práctico
    // ==========================================
    
    val emails = mutableListOf(
        Email("Reunión", "jefe@empresa.com"),
        Email("Reporte", "admin@empresa.com")
    )
    
    // Buscar funciona automáticamente
    val emailBuscado = Email("Reunión", "jefe@empresa.com")
    println("\nEmail encontrado: ${emails.contains(emailBuscado)}")
    
    // ==========================================
    // 8. Ejemplo interactivo
    // ==========================================
    
    print("\nIngresa asunto: ")
    val asunto = readLine()?.trim() ?: "Sin asunto"
    
    val emailUsuario = Email(asunto, "usuario@email.com")
    println("Creado: $emailUsuario")
    
    val emailLeido = emailUsuario.copy(leido = true)
    println("Después de leer: $emailLeido")
    
    // ==========================================
    // EJERCICIO
    // ==========================================
    
    println("\n=== EJERCICIO ===")
    println("Crea data class 'Contacto' con nombre y email")
    println("Verifica que equals funcione y usa copy()")
    
    // Solución:
    /*
    data class Contacto(val nombre: String, val email: String)
    
    val contacto1 = Contacto("María", "maria@email.com")
    val contacto2 = Contacto("María", "maria@email.com")
    
    println("Iguales: ${contacto1 == contacto2}")  // true
    println("Contacto: $contacto1")  // toString automático
    
    val contactoCopia = contacto1.copy(email = "maria.nueva@email.com")
    println("Copia: $contactoCopia")
    */
}

/**
 * RESUMEN:
 * - data class - genera toString(), equals(), hashCode(), copy()
 * - toString() - representación legible
 * - equals() - compara contenido, no referencias
 * - copy() - crear copias con modificaciones
 */
