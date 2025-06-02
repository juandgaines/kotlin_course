package class_25

/**
 * CLASE 25: SEALED CLASSES
 * 
 * Conceptos:
 * - Sealed classes: jerarquía cerrada de clases
 * - Data classes y data objects
 * - When exhaustivo: compilador garantiza todos los casos
 * - Componentes compartidos simples
 */

// ==========================================
// 1. Sealed Class con propiedad compartida
// ==========================================

sealed class EmailStatus(val priority: Int) {
    
    // Data class para emails enviados
    data class Sent(val recipient: String) : EmailStatus(1)
    
    // Data class para emails fallidos
    data class Failed(val errorMessage: String) : EmailStatus(3)
    
    // Data object para estados simples
    data object Draft : EmailStatus(2)
    
    // Data object para pendientes
    data object Pending : EmailStatus(2)
    
    // Data class con múltiples propiedades
    data class Scheduled(val recipient: String, val sendTime: String) : EmailStatus(1)
}

// ==========================================
// 2. Función para procesar estados
// ==========================================

fun processEmailStatus(status: EmailStatus): String {
    return when (status) {
        is EmailStatus.Sent -> "✅ Email enviado a ${status.recipient} (prioridad: ${status.priority})"
        is EmailStatus.Failed -> "❌ Error: ${status.errorMessage} (prioridad: ${status.priority})"
        is EmailStatus.Draft -> "📝 Email en borrador (prioridad: ${status.priority})"
        is EmailStatus.Pending -> "⏳ Email pendiente (prioridad: ${status.priority})"
        is EmailStatus.Scheduled -> "📅 Email programado para ${status.sendTime} a ${status.recipient}"
    }
}

// ==========================================
// 3. Función para obtener prioridad
// ==========================================

fun getPriorityLevel(status: EmailStatus): String {
    return when (status.priority) {
        1 -> "Alta"
        2 -> "Media"
        3 -> "Baja"
        else -> "Desconocida"
    }
}

fun main() {
    println("=== SEALED CLASSES SIMPLES ===")
    
    // ==========================================
    // 4. Creando instancias
    // ==========================================
    
    val sent = EmailStatus.Sent("juan@example.com")
    val failed = EmailStatus.Failed("Servidor no disponible")
    val draft = EmailStatus.Draft
    val pending = EmailStatus.Pending
    val scheduled = EmailStatus.Scheduled("maria@example.com", "2024-12-25 09:00")
    
    // ==========================================
    // 5. Procesando estados
    // ==========================================
    
    println("\n=== Estados de emails ===")
    println(processEmailStatus(sent))
    println(processEmailStatus(failed))
    println(processEmailStatus(draft))
    println(processEmailStatus(pending))
    println(processEmailStatus(scheduled))
    
    // ==========================================
    // 6. Usando propiedad compartida
    // ==========================================
    
    println("\n=== Prioridades ===")
    val statuses = listOf(sent, failed, draft, pending, scheduled)
    
    statuses.forEach { status ->
        println("${status::class.simpleName}: ${getPriorityLevel(status)}")
    }
    
    // ==========================================
    // EJERCICIO
    // ==========================================
    
    println("\n=== EJERCICIO ===")
    println("Crea sealed class 'EmailFolder' con:")
    println("1. Propiedad compartida 'count: Int'")
    println("2. Data object Inbox con count = 10")
    println("3. Data class Spam(senderDomain: String) con count = 5")
    println("4. Data object Sent con count = 3")
    
    // Solución comentada:
    /*
    sealed class EmailFolder(val count: Int) {
        data object Inbox : EmailFolder(10)
        data class Spam(val senderDomain: String) : EmailFolder(5)
        data object Sent : EmailFolder(3)
    }
    
    fun describFolder(folder: EmailFolder): String {
        return when (folder) {
            is EmailFolder.Inbox -> "Bandeja de entrada: ${folder.count} emails"
            is EmailFolder.Spam -> "Spam de ${folder.senderDomain}: ${folder.count} emails"
            is EmailFolder.Sent -> "Enviados: ${folder.count} emails"
        }
    }
    */
}

/**
 * RESUMEN:
 * - Sealed classes: jerarquía cerrada y controlada
 * - Data classes: para estados con propiedades
 * - Data objects: para estados simples sin propiedades
 * - When exhaustivo: compilador verifica todos los casos
 * - Propiedades compartidas: accesibles desde todas las subclases
 */

