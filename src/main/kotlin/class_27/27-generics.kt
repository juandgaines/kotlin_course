package class_27

/**
 * CLASE 27: GENERICS
 * 
 * Conceptos:
 * - Generics: tipos parametrizados <T>
 * - Reutilización de código para diferentes tipos
 * - Type safety: seguridad de tipos en tiempo de compilación
 * - Repositorio genérico para emails
 */

// ==========================================
// 1. Repositorio genérico
// ==========================================

class EmailRepository<T> {
    private val items = mutableMapOf<String, T>()
    
    // Guardar cualquier tipo T
    fun save(id: String, item: T) {
        items[id] = item
        println("💾 Guardado: $id")
    }
    
    // Buscar por ID, retorna T?
    fun findById(id: String): T? {
        return items[id]
    }
    
    // Obtener todos los elementos
    fun findAll(): List<T> {
        return items.values.toList()
    }
    
    // Contar elementos
    fun count(): Int = items.size
    
    // Eliminar por ID
    fun delete(id: String): Boolean {
        return items.remove(id) != null
    }
}

// ==========================================
// 2. Clases de datos para ejemplos
// ==========================================

data class Email(
    val subject: String,
    val sender: String,
    val body: String
)

data class Contact(
    val name: String,
    val email: String,
    val phone: String
)

// ==========================================
// 3. Función genérica
// ==========================================

fun <T> printItemInfo(item: T, description: String) {
    println("📋 $description: $item")
}

// Función genérica con restricción
fun <T> saveMultiple(repository: EmailRepository<T>, items: List<Pair<String, T>>) {
    items.forEach { (id, item) ->
        repository.save(id, item)
    }
    println("✅ Guardados ${items.size} elementos")
}

fun main() {
    println("=== GENERICS CON REPOSITORIO ===")
    
    // ==========================================
    // 4. Repositorio para emails
    // ==========================================
    
    println("\n=== Repositorio de Emails ===")
    val emailRepo = EmailRepository<Email>()
    
    val email1 = Email("Reunión", "juan@example.com", "Reunión a las 3pm")
    val email2 = Email("Reporte", "maria@example.com", "Reporte mensual")
    
    emailRepo.save("email-1", email1)
    emailRepo.save("email-2", email2)
    
    println("Total emails: ${emailRepo.count()}")
    println("Email encontrado: ${emailRepo.findById("email-1")?.subject}")
    
    // ==========================================
    // 5. Repositorio para contactos
    // ==========================================
    
    println("\n=== Repositorio de Contactos ===")
    val contactRepo = EmailRepository<Contact>()
    
    val contact1 = Contact("Juan Pérez", "juan@example.com", "123-456-7890")
    val contact2 = Contact("María García", "maria@example.com", "098-765-4321")
    
    contactRepo.save("contact-1", contact1)
    contactRepo.save("contact-2", contact2)
    
    println("Total contactos: ${contactRepo.count()}")
    println("Contacto encontrado: ${contactRepo.findById("contact-1")?.name}")
    
    // ==========================================
    // 6. Usando funciones genéricas
    // ==========================================
    
    println("\n=== Funciones genéricas ===")
    printItemInfo(email1, "Email")
    printItemInfo(contact1, "Contacto")
    
    // Guardar múltiples elementos
    val moreEmails = listOf(
        "email-3" to Email("Urgente", "admin@example.com", "Mensaje urgente"),
        "email-4" to Email("Info", "info@example.com", "Información general")
    )
    
    saveMultiple(emailRepo, moreEmails)
    println("Total emails después: ${emailRepo.count()}")
    
    // ==========================================
    // EJERCICIO
    // ==========================================
    
    println("\n=== EJERCICIO ===")
    println("Crea función genérica 'searchByField' que:")
    println("1. Reciba un repositorio EmailRepository<T>")
    println("2. Reciba una función lambda (T) -> String")
    println("3. Reciba un valor de búsqueda String")
    println("4. Retorne lista de elementos que coincidan")
    
    // Solución comentada:
    /*
    fun <T> searchByField(
        repository: EmailRepository<T>,
        fieldExtractor: (T) -> String,
        searchValue: String
    ): List<T> {
        return repository.findAll().filter { item ->
            fieldExtractor(item).contains(searchValue, ignoreCase = true)
        }
    }
    
    // Ejemplo de uso:
    val emailsFromJuan = searchByField(emailRepo, { it.sender }, "juan")
    println("Emails de Juan: ${emailsFromJuan.size}")
    
    val contactsWithMaria = searchByField(contactRepo, { it.name }, "María")
    println("Contactos con María: ${contactsWithMaria.size}")
    */
}

/**
 * RESUMEN:
 * - Generics <T>: permiten reutilizar código para diferentes tipos
 * - Type safety: el compilador verifica los tipos
 * - Repositorio genérico: mismo código para Email, Contact, etc.
 * - Funciones genéricas: operaciones que funcionan con cualquier tipo
 */

