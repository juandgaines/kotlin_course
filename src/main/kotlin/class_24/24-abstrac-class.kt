package class_24

/**
 * CLASE 24: ABSTRACT CLASSES Y HERENCIA
 * 
 * Conceptos:
 * - Abstract classes: no se pueden instanciar
 * - Métodos abstractos vs concretos
 * - Herencia y override
 */

// ==========================================
// 1. Abstract Class
// ==========================================

abstract class EmailRepository {
    // Método abstracto - debe ser implementado
    abstract fun save(email: Email)
    
    // Método concreto - implementación por defecto
    fun log(message: String) {
        println("[REPO] $message")
    }
    
    // Método concreto que usa el abstracto
    fun saveWithLog(email: Email) {
        log("Guardando: ${email.subject}")
        save(email)
    }
}

data class Email(val id: String, val subject: String, val body: String)

// ==========================================
// 2. Implementaciones concretas
// ==========================================

class DatabaseRepository : EmailRepository() {
    override fun save(email: Email) {
        println("💾 Guardado en base de datos")
    }
}

class FileRepository : EmailRepository() {
    override fun save(email: Email) {
        println("📁 Guardado en archivo")
    }
}

// ==========================================
// 3. Herencia con propiedades
// ==========================================

abstract class SecureRepository(protected val key: String) : EmailRepository() {
    
    protected fun encrypt(data: String): String {
        return "ENCRYPTED[$key]:$data"
    }
    
    // Método abstracto adicional
    abstract fun backup()
}

class CloudRepository(key: String) : SecureRepository(key) {
    override fun save(email: Email) {
        val encrypted = encrypt(email.subject)
        println("☁️ Guardado encriptado: $encrypted")
    }
    
    override fun backup() {
        println("🔄 Backup en la nube")
    }
}

fun main() {
    println("=== ABSTRACT CLASSES ===")
    
    val email = Email("1", "Reunión", "Contenido importante")
    
    // ==========================================
    // 4. Usando las implementaciones
    // ==========================================
    
    println("\n=== Repositorios básicos ===")
    val dbRepo = DatabaseRepository()
    val fileRepo = FileRepository()
    
    dbRepo.saveWithLog(email)
    fileRepo.saveWithLog(email)
    
    println("\n=== Repositorio seguro ===")
    val cloudRepo = CloudRepository("mi-clave")
    cloudRepo.saveWithLog(email)
    cloudRepo.backup()
    
    // ==========================================
    // EJERCICIO
    // ==========================================
    
    println("\n=== EJERCICIO ===")
    println("Crea 'MemoryRepository' que extienda EmailRepository")
    println("Override save() para guardar en una lista")
    
    // Solución:
    /*
    class MemoryRepository : EmailRepository() {
        private val emails = mutableListOf<Email>()
        
        override fun save(email: Email) {
            emails.add(email)
            println("💭 Guardado en memoria: ${emails.size} emails")
        }
    }
    */
}

/**
 * RESUMEN:
 * - Abstract classes: no se pueden instanciar directamente
 * - Métodos abstractos: deben ser implementados por subclases
 * - Métodos concretos: implementación compartida
 * - Herencia: reutilizar y extender funcionalidad
 */

