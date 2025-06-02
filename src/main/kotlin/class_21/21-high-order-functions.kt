package class_21

/**
 * CLASE 21: HIGHER-ORDER FUNCTIONS
 * 
 * Conceptos:
 * - Funciones que reciben otras funciones como parámetros
 * - Lambdas con parámetros de entrada y salida
 * - Callbacks con onSuccess/onError
 */

data class Email(
    val subject: String,
    val sender: String,
    val isRead: Boolean = false
)

fun main() {
    println("=== HIGHER-ORDER FUNCTIONS ===")
    
    val emails = listOf(
        Email("Reunión", "jefe@empresa.com", false),
        Email("Reporte", "admin@empresa.com", true),
        Email("Urgente", "cliente@test.com", false)
    )
    
    // ==========================================
    // 1. Lambdas con parámetros y retorno
    // ==========================================
    
    println("\n=== LAMBDAS CON PARÁMETROS Y RETORNO ===")
    
    // Forma 1: Lambda declarada explícitamente
    val formatearEmail: (Email) -> String = { email ->
        "${email.subject} de ${email.sender}"
    }
    
    val esImportante: (Email) -> Boolean = { email ->
        email.sender == "jefe@empresa.com" || email.subject.contains("Urgente")
    }
    
    // Usar las lambdas declaradas
    val emailsFormateados = emails.map(formatearEmail)
    val emailsImportantes = emails.filter(esImportante)
    
    println("Con lambdas declaradas:")
    emailsFormateados.forEach { println("- $it") }
    println("Importantes: ${emailsImportantes.size}")
    
    // Forma 2: Lambda inline (más común)
    val emailsFormateados2 = emails.map { "${it.subject} de ${it.sender}" }
    val emailsImportantes2 = emails.filter { 
        it.sender == "jefe@empresa.com" || it.subject.contains("Urgente") 
    }
    
    println("\nCon lambdas inline:")
    emailsFormateados2.forEach { println("- $it") }
    println("Importantes: ${emailsImportantes2.size}")
    
    println("\n💡 Ambas formas hacen lo mismo, pero inline es más conciso")
    
    // ==========================================
    // 2. Función que recibe lambda con parámetros
    // ==========================================
    
    println("\n=== FUNCIÓN CON LAMBDA ===")
    
    // Función que recibe un transformador
    fun procesarEmails(
        emails: List<Email>, 
        transformador: (Email) -> String
    ): List<String> {
        return emails.map(transformador)
    }
    
    // Diferentes transformadores
    val soloAsunto: (Email) -> String = { it.subject }
    val conEstado: (Email) -> String = { "${it.subject} [${if (it.isRead) "Leído" else "No leído"}]" }
    
    println("Solo asuntos:")
    procesarEmails(emails, soloAsunto).forEach { println("- $it") }
    
    println("Con estado:")
    procesarEmails(emails, conEstado).forEach { println("- $it") }
    
    // ==========================================
    // 3. Callbacks con parámetros de entrada/salida
    // ==========================================
    
    println("\n=== CALLBACKS CON PARÁMETROS ===")
    
    // Callback que recibe resultado y retorna acción
    fun enviarEmail(
        email: Email,
        onSuccess: (Email, String) -> Unit,  // Recibe email y mensaje
        onError: (String, Int) -> Unit       // Recibe error y código
    ) {
        if (email.sender.contains("@")) {
            val mensaje = "Enviado a ${email.sender}"
            onSuccess(email, mensaje)
        } else {
            onError("Email inválido: ${email.sender}", 400)
        }
    }
    
    // Usar callbacks con múltiples parámetros
    val emailTest = Email("Test", "user@test.com")
    val emailInvalido = Email("Test", "invalido")
    
    enviarEmail(
        emailTest,
        onSuccess = { email, mensaje -> 
            println("✅ '${email.subject}': $mensaje") 
        },
        onError = { error, codigo -> 
            println("❌ Error $codigo: $error") 
        }
    )
    
    enviarEmail(
        emailInvalido,
        onSuccess = { email, mensaje -> 
            println("✅ '${email.subject}': $mensaje") 
        },
        onError = { error, codigo -> 
            println("❌ Error $codigo: $error") 
        }
    )
    
    // ==========================================
    // 4. Función que retorna lambda configurada
    // ==========================================
    
    println("\n=== FUNCIÓN QUE RETORNA LAMBDA ===")
    
    // Función que crea un validador personalizado
    fun crearValidador(dominiosPermitidos: List<String>): (String) -> Boolean {
        return { email ->
            val dominio = email.substringAfter("@")
            dominiosPermitidos.contains(dominio)
        }
    }
    
    // Crear validadores específicos
    val validadorEmpresa = crearValidador(listOf("empresa.com", "test.com"))
    val validadorPublico = crearValidador(listOf("gmail.com", "yahoo.com"))
    
    // Probar validadores
    val emailsTest = listOf("juan@empresa.com", "maria@gmail.com", "pedro@otro.com")
    
    println("Validación empresa:")
    emailsTest.forEach { email ->
        println("$email: ${if (validadorEmpresa(email)) "✅" else "❌"}")
    }
    
    // ==========================================
    // EJERCICIO
    // ==========================================
    
    println("\n=== EJERCICIO ===")
    println("Crea función 'buscarEmail' que:")
    println("1. Reciba una lista de emails")
    println("2. Reciba una condición: (Email) -> Boolean")
    println("3. Reciba callbacks onFound: (Email) -> Unit y onNotFound: () -> Unit")
    
    // Solución:
    /*
    fun buscarEmail(
        emails: List<Email>,
        condicion: (Email) -> Boolean,
        onFound: (Email) -> Unit,
        onNotFound: () -> Unit
    ) {
        val emailEncontrado = emails.find(condicion)
        if (emailEncontrado != null) {
            onFound(emailEncontrado)
        } else {
            onNotFound()
        }
    }
    
    buscarEmail(
        emails,
        condicion = { it.subject.contains("Urgente") },
        onFound = { email -> println("✅ Encontrado: ${email.subject}") },
        onNotFound = { println("❌ No se encontró email urgente") }
    )
    */
}

/**
 * RESUMEN:
 * - Lambdas: (Parámetro) -> TipoRetorno
 * - Callbacks con múltiples parámetros
 * - Funciones que retornan lambdas configuradas
 * - Patrón común: onSuccess/onError con datos
 */

