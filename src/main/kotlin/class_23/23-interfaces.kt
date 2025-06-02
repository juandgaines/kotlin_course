package class_23

import java.time.LocalDateTime

/**
 * CLASE 23: INTERFACES
 * 
 * Conceptos:
 * - Contratos que definen qué métodos debe implementar una clase
 * - Pueden tener implementaciones por defecto
 * - Una clase puede implementar múltiples interfaces
 */

// ==========================================
// 1. Interface básica - Repositorio de emails
// ==========================================

interface EmailRepository {
    fun save(email: Email)
    fun findById(id: String): Email?
    fun findAll(): List<Email>
}

// ==========================================
// 2. Interface con implementación por defecto
// ==========================================

interface EmailValidator {
    fun validate(email: Email): Boolean
    
    // Implementación por defecto
    fun isValidEmail(address: String): Boolean {
        return address.contains("@") && address.contains(".")
    }
}

// ==========================================
// 3. Clases de datos y excepciones
// ==========================================

data class Email(
    val id: String,
    val subject: String,
    val sender: String,
    val body: String,
    val timestamp: LocalDateTime = LocalDateTime.now()
)

class EmailNotFoundException(message: String) : Exception(message)
class InvalidEmailException(message: String) : Exception(message)

// ==========================================
// 4. Implementación del repositorio
// ==========================================

class InMemoryEmailRepository : EmailRepository {
    private val emails = mutableMapOf<String, Email>()
    
    override fun save(email: Email) {
        emails[email.id] = email
        println("Email guardado: ${email.subject}")
    }
    
    override fun findById(id: String): Email? {
        return emails[id] ?: throw EmailNotFoundException("Email con ID $id no encontrado")
    }
    
    override fun findAll(): List<Email> {
        return emails.values.toList()
    }
}

// ==========================================
// 5. Implementación del validador
// ==========================================

class BasicEmailValidator : EmailValidator {
    override fun validate(email: Email): Boolean {
        if (email.subject.isEmpty()) {
            throw InvalidEmailException("El asunto no puede estar vacío")
        }
        if (!isValidEmail(email.sender)) {
            throw InvalidEmailException("Email del remitente inválido: ${email.sender}")
        }
        return true
    }
}

// ==========================================
// 6. Servicio que usa las interfaces
// ==========================================

class EmailService(
    private val repository: EmailRepository,
    private val validator: EmailValidator
) {
    fun sendEmail(email: Email): Boolean {
        return try {
            validator.validate(email)
            repository.save(email)
            true
        } catch (e: InvalidEmailException) {
            println("Error: ${e.message}")
            false
        }
    }
    
    fun getEmail(id: String): Email? {
        return try {
            repository.findById(id)
        } catch (e: EmailNotFoundException) {
            println("Error: ${e.message}")
            null
        }
    }
}

fun main() {
    println("=== INTERFACES CON REPOSITORIO ===")
    
    // Crear instancias
    val repository = InMemoryEmailRepository()
    val validator = BasicEmailValidator()
    val service = EmailService(repository, validator)
    
    // ==========================================
    // 7. Probando el sistema
    // ==========================================
    
    println("\n=== ENVIANDO EMAILS ===")
    
    // Email válido
    val validEmail = Email("1", "Reunión", "juan@example.com", "Hola equipo")
    println("Enviando email válido: ${service.sendEmail(validEmail)}")
    
    // Email inválido - sin asunto
    val invalidEmail1 = Email("2", "", "maria@example.com", "Sin asunto")
    println("Enviando email sin asunto: ${service.sendEmail(invalidEmail1)}")
    
    // Email inválido - email malformado
    val invalidEmail2 = Email("3", "Test", "email-malo", "Email malformado")
    println("Enviando email malformado: ${service.sendEmail(invalidEmail2)}")
    
    // ==========================================
    // 8. Buscando emails
    // ==========================================
    
    println("\n=== BUSCANDO EMAILS ===")
    
    // Buscar email existente
    val found = service.getEmail("1")
    println("Email encontrado: ${found?.subject}")
    
    // Buscar email inexistente
    val notFound = service.getEmail("999")
    println("Email no encontrado: $notFound")
    
    // ==========================================
    // EJERCICIO
    // ==========================================
    
    println("\n=== EJERCICIO ===")
    println("Crea interface 'EmailNotifier' con:")
    println("1. notify(email: Email)")
    println("2. Implementa 'ConsoleNotifier'")
    println("3. Úsalo en EmailService")
    
    // Solución comentada:
    /*
    interface EmailNotifier {
        fun notify(email: Email)
    }
    
    class ConsoleNotifier : EmailNotifier {
        override fun notify(email: Email) {
            println("📧 Nuevo email: ${email.subject} de ${email.sender}")
        }
    }
    */
}

/**
 * RESUMEN:
 * - Interfaces definen contratos
 * - Pueden tener métodos con implementación por defecto
 * - Permiten polimorfismo y desacoplamiento
 * - Útiles para patrones como Repository
 */

