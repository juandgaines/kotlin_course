package class_14

/**
 * CLASE 14: CLASES Y OBJETOS
 * 
 * Conceptos:
 * - class - crear plantilla/molde
 * - Constructor y propiedades
 * - Métodos
 * - Crear y usar objetos
 */

// ==========================================
// 1. Clase básica
// ==========================================

class Email(
    val asunto: String,
    val remitente: String,
    val mensaje: String
) {
    var leido: Boolean = false
    
    fun marcarComoLeido() {
        leido = true
    }
    
    fun mostrarInfo() {
        println("De: $remitente | Asunto: $asunto | Leído: $leido")
    }
}

// ==========================================
// 2. Clase para gestionar emails
// ==========================================

class BandejaEmail {
    val emails = mutableListOf<Email>()
    
    fun agregarEmail(email: Email) {
        emails.add(email)
    }
    
    fun contarNoLeidos(): Int {
        var contador = 0
        for (email in emails) {
            if (!email.leido) contador++
        }
        return contador
    }
}

fun main() {
    println("=== CLASES Y OBJETOS ===")
    
    // ==========================================
    // 3. Crear y usar objetos
    // ==========================================
    
    // Crear objetos
    val email1 = Email("Reunión", "jefe@empresa.com", "Reunión mañana 10 AM")
    val email2 = Email("Reporte", "admin@empresa.com", "Reporte mensual adjunto")
    
    // Usar métodos
    email1.mostrarInfo()
    email2.mostrarInfo()
    
    email1.marcarComoLeido()
    println("Después de leer:")
    email1.mostrarInfo()
    
    // ==========================================
    // 4. Usar clase BandejaEmail
    // ==========================================
    
    val miBandeja = BandejaEmail()
    miBandeja.agregarEmail(email1)
    miBandeja.agregarEmail(email2)
    
    println("Emails no leídos: ${miBandeja.contarNoLeidos()}")
    println("Total emails: ${miBandeja.emails.size}")
    
    // ==========================================
    // 5. Ejemplo interactivo
    // ==========================================
    
    print("Ingresa asunto: ")
    val asunto = readLine()?.trim() ?: "Sin asunto"
    
    print("Ingresa remitente: ")
    val remitente = readLine()?.trim() ?: "usuario@email.com"
    
    val emailUsuario = Email(asunto, remitente, "Mensaje del usuario")
    emailUsuario.mostrarInfo()
    
    // ==========================================
    // EJERCICIO
    // ==========================================
    
    println("\n=== EJERCICIO ===")
    println("Crea una clase 'Contacto' con:")
    println("- Propiedades: nombre, email")
    println("- Método: mostrarContacto()")
    
    // Solución:
    /*
    class Contacto(val nombre: String, val email: String) {
        fun mostrarContacto() {
            println("$nombre - $email")
        }
    }
    
    val contacto = Contacto("María", "maria@email.com")
    contacto.mostrarContacto()
    */
}

/**
 * RESUMEN:
 * - class Nombre(parametros) { } - crear clase
 * - val objeto = Clase(valores) - crear objeto
 * - objeto.propiedad, objeto.metodo() - usar objeto
 */
