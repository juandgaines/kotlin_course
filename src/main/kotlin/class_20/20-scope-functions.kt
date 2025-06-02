package class_20

/**
 * CLASE 20: SCOPE FUNCTIONS
 * 
 * Conceptos:
 * - let - transformación y null safety
 * - apply - configuración de objetos
 * - run - configuración + resultado
 * - with - múltiples operaciones
 * - also - efectos secundarios
 */

data class Email(
    val id: String,
    var subject: String,
    var body: String,
    var isRead: Boolean = false
)

fun main() {
    println("=== SCOPE FUNCTIONS ===")
    
    // ==========================================
    // 1. let - Null safety y transformación
    // ==========================================
    
    println("\n=== 1. LET ===")
    
    val emailId: String? = "123"
    
    // Uso común: null safety
    val email = emailId?.let {
        Email(it, "Reunión", "Reunión mañana")
    }
    println("Email creado: $email")
    
    // Transformación
    val domain = "juan@test.com".let {
        it.substringAfter("@")
    }
    println("Dominio: $domain")
    
    // ==========================================
    // 2. apply - Configurar objetos
    // ==========================================
    
    println("\n=== 2. APPLY ===")
    
    // Uso común: configurar después de crear
    val email2 = Email("2", "Borrador", "Contenido").apply {
        subject = "Título Final"
        body = "Contenido actualizado"
        isRead = true
    }
    println("Email configurado: $email2")
    
    // ==========================================
    // 3. run - Configurar + obtener resultado
    // ==========================================
    
    println("\n=== 3. RUN ===")
    
    // Uso común: configurar y calcular algo
    val status = Email("3", "Test", "Mensaje").run {
        isRead = true
        subject = subject.uppercase()
        "Email procesado: $subject"
    }
    println("Estado: $status")
    
    // ==========================================
    // 4. with - Múltiples operaciones
    // ==========================================
    
    println("\n=== 4. WITH ===")
    
    val email4 = Email("4", "Importante", "Mensaje urgente")
    
    // Uso común: varias operaciones en un objeto
    val summary = with(email4) {
        isRead = true
        "ID: $id, Asunto: $subject, Leído: $isRead"
    }
    println("Resumen: $summary")
    
    // ==========================================
    // 5. also - Efectos secundarios
    // ==========================================
    
    println("\n=== 5. ALSO ===")
    
    // Uso común: logging, debugging
    val email5 = Email("5", "Log", "Mensaje con log").also {
        println("📧 Creando email: ${it.subject}")
    }.also {
        println("📝 Email ID: ${it.id}")
    }
    
    // ==========================================
    // 6. Ejemplo práctico combinado
    // ==========================================
    
    println("\n=== EJEMPLO COMBINADO ===")
    
    fun createAndProcessEmail(id: String?, subject: String, body: String): String? {
        return id?.let { emailId ->
            Email(emailId, subject, body)
                .apply {
                    // Configurar
                    this.subject = subject.trim().uppercase()
                    this.body = body.trim()
                }
                .also {
                    // Log
                    println("Procesando: ${it.subject}")
                }
                .run {
                    // Procesar y retornar resultado
                    isRead = true
                    "✅ Email $id procesado"
                }
        }
    }
    
    // Probar función
    val result1 = createAndProcessEmail("100", "  hola  ", "  mensaje  ")
    val result2 = createAndProcessEmail(null, "test", "test")
    
    println("Resultado 1: $result1")
    println("Resultado 2: $result2")
    
    // ==========================================
    // EJERCICIO
    // ==========================================
    
    println("\n=== EJERCICIO ===")
    println("Crea función 'validateEmail' que:")
    println("1. Use let para verificar que email no sea null")
    println("2. Use apply para limpiar espacios")
    println("3. Use also para hacer log")
    println("4. Use run para validar y retornar resultado")
    
    // Solución:
    /*
    fun validateEmail(email: String?): Boolean {
        return email?.let { emailStr ->
            emailStr.apply {
                trim()
            }.also {
                println("Validando: $it")
            }.run {
                contains("@") && contains(".")
            }
        } ?: false
    }
    
    println("\nValidaciones:")
    println("juan@test.com: ${validateEmail("juan@test.com")}")
    println("invalido: ${validateEmail("invalido")}")
    println("null: ${validateEmail(null)}")
    */
}

/**
 * RESUMEN:
 * - let: null safety, transformación
 * - apply: configurar objeto, retorna el objeto
 * - run: configurar + calcular, retorna resultado
 * - with: múltiples operaciones en objeto
 * - also: efectos secundarios, retorna el objeto
 */

