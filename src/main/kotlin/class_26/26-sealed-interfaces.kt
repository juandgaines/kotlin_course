package class_26

/**
 * CLASE 26: SEALED INTERFACES
 * 
 * Conceptos:
 * - Sealed interfaces: jerarquía cerrada de interfaces
 * - Diferencia con sealed classes: múltiple herencia
 * - Data classes y data objects
 * - When exhaustivo con interfaces
 */

// ==========================================
// 1. Sealed Interface simple
// ==========================================

sealed interface EmailAction {
    // Propiedad que pueden implementar las subclases
    val actionType: String
    
    // Data class para enviar emails
    data class Send(
        val recipient: String,
        val subject: String
    ) : EmailAction {
        override val actionType: String = "SEND"
    }
    
    // Data class para eliminar emails
    data class Delete(val emailId: String) : EmailAction {
        override val actionType: String = "DELETE"
    }
    
    // Data object para guardar borrador
    data object SaveDraft : EmailAction {
        override val actionType: String = "DRAFT"
    }
    
    // Data object para actualizar
    data object Refresh : EmailAction {
        override val actionType: String = "REFRESH"
    }
}

// ==========================================
// 2. Función para procesar acciones
// ==========================================

fun processEmailAction(action: EmailAction): String {
    return when (action) {
        is EmailAction.Send -> "📤 Enviando a ${action.recipient}: ${action.subject}"
        is EmailAction.Delete -> "🗑️ Eliminando email ID: ${action.emailId}"
        is EmailAction.SaveDraft -> "📝 Guardando borrador"
        is EmailAction.Refresh -> "🔄 Actualizando bandeja"
    }
}

// ==========================================
// 3. Función para obtener tipo de acción
// ==========================================

fun getActionCategory(action: EmailAction): String {
    return when (action.actionType) {
        "SEND" -> "Comunicación"
        "DELETE" -> "Gestión"
        "DRAFT" -> "Edición"
        "REFRESH" -> "Sincronización"
        else -> "Desconocido"
    }
}

fun main() {
    println("=== SEALED INTERFACES ===")
    
    // ==========================================
    // 4. Creando instancias
    // ==========================================
    
    val send = EmailAction.Send("juan@example.com", "Reunión importante")
    val delete = EmailAction.Delete("email-123")
    val draft = EmailAction.SaveDraft
    val refresh = EmailAction.Refresh
    
    // ==========================================
    // 5. Procesando acciones
    // ==========================================
    
    println("\n=== Procesando acciones ===")
    println(processEmailAction(send))
    println(processEmailAction(delete))
    println(processEmailAction(draft))
    println(processEmailAction(refresh))
    
    // ==========================================
    // 6. Usando propiedad de interface
    // ==========================================
    
    println("\n=== Categorías de acciones ===")
    val actions = listOf(send, delete, draft, refresh)
    
    actions.forEach { action ->
        println("${action::class.simpleName}: ${getActionCategory(action)}")
    }
    
    // ==========================================
    // 7. Diferencia con sealed classes
    // ==========================================
    
    println("\n=== DIFERENCIAS ===")
    println("• Sealed classes: herencia simple")
    println("• Sealed interfaces: múltiple herencia posible")
    println("• Ambos: when exhaustivo y jerarquía cerrada")
    
    // ==========================================
    // EJERCICIO
    // ==========================================
    
    println("\n=== EJERCICIO ===")
    println("Crea sealed interface 'EmailFilter' con:")
    println("1. Propiedad 'filterName: String'")
    println("2. Data class ByDate(date: String)")
    println("3. Data class BySender(email: String)")
    println("4. Data object Unread")
    
    // Solución comentada:
    /*
    sealed interface EmailFilter {
        val filterName: String
        
        data class ByDate(val date: String) : EmailFilter {
            override val filterName: String = "Filtro por fecha"
        }
        
        data class BySender(val email: String) : EmailFilter {
            override val filterName: String = "Filtro por remitente"
        }
        
        data object Unread : EmailFilter {
            override val filterName: String = "No leídos"
        }
    }
    
    fun applyFilter(filter: EmailFilter): String {
        return when (filter) {
            is EmailFilter.ByDate -> "Filtrando emails del ${filter.date}"
            is EmailFilter.BySender -> "Filtrando emails de ${filter.email}"
            is EmailFilter.Unread -> "Mostrando emails no leídos"
        }
    }
    */
}

/**
 * RESUMEN:
 * - Sealed interfaces: jerarquía cerrada como sealed classes
 * - Permiten múltiple herencia (a diferencia de sealed classes)
 * - Data classes y data objects funcionan igual
 * - When exhaustivo garantiza manejo de todos los casos
 * - Útil cuando necesitas múltiple herencia con jerarquía cerrada
 */
