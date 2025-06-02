@file:Suppress("MISSING_DEPENDENCY_SUPERCLASS_IN_TYPE_ARGUMENT")

package class_08

/**
 * CLASE 8: ENTRADA POR CONSOLA (readLine)
 * 
 * Conceptos:
 * - readLine() - leer texto del usuario
 * - trim() - eliminar espacios en blanco
 * - Combinación con operadores de nullability (?, ?:)
 */

fun main() {
    // ==========================================
    // 1. ¿Qué es readLine()?
    // ==========================================
    
    // readLine() = lee una línea completa que escribe el usuario
    // Devuelve String? (nullable) porque puede ser null
    
    println("=== SISTEMA DE EMAIL ===")
    
    // ==========================================
    // 2. Entrada básica con readLine()
    // ==========================================
    
    print("Ingresa tu email: ")                    // print (sin salto de línea)
    val emailUsuario = readLine()                  // Lee lo que escriba el usuario
    println("Recibido: $emailUsuario")             // Puede ser null
    
    // ==========================================
    // 3. readLine() + Elvis Operator
    // ==========================================
    
    print("Ingresa el destinatario: ")
    val destinatario = readLine() ?: "sin-email@ejemplo.com"  // Si es null, usa valor por defecto
    
    print("Ingresa el asunto: ")
    val asunto = readLine() ?: "Sin asunto"
    
    println("Para: $destinatario")
    println("Asunto: $asunto")
    
    // ==========================================
    // 4. trim() - Eliminar espacios
    // ==========================================
    
    // trim() = elimina espacios al inicio y final
    // Ejemplo: "  hola  " se convierte en "hola"
    
    print("Ingresa el mensaje: ")
    val mensajeSinLimpiar = readLine()
    val mensajeLimpio = mensajeSinLimpiar?.trim()// Safe call + trim
    
    println("Sin limpiar: '$mensajeSinLimpiar'")
    println("Limpio: '$mensajeLimpio'")
    
    // ==========================================
    // 5. Patrón completo: readLine + trim + Elvis
    // ==========================================
    
    print("Ingresa tu nombre: ")
    val nombre = readLine()?.trim() ?: "Anónimo"   // Lee → limpia → valor por defecto
    
    // Este patrón es muy común:
    // readLine()?.trim() ?: "valor_por_defecto"
    
    // ==========================================
    // 6. Vista previa del email
    // ==========================================
    
    println("=============================")
    println("VISTA PREVIA DEL EMAIL")
    println("=============================")
    println("De: $nombre")
    println("Para: $destinatario")
    println("Asunto: $asunto")
    println("Mensaje: ${mensajeLimpio ?: "Sin mensaje"}")
    println("=============================")
    
    // ==========================================
    // EJERCICIO
    // ==========================================
    
    println("=== EJERCICIO ===")
    println("Crea variables que pidan:")
    println("1. Email del remitente")
    println("2. Prioridad del email")
    println("Usa readLine()?.trim() ?: \"valor_defecto\"")
    
    // Solución:
    /*
    print("Email remitente: ")
    val emailRemitente = readLine()?.trim() ?: "usuario@email.com"
    
    print("Prioridad: ")
    val prioridad = readLine()?.trim() ?: "Media"
    
    println("Remitente: $emailRemitente")
    println("Prioridad: $prioridad")
    */
}

/**
 * RESUMEN:
 * - readLine(): lee texto del usuario (devuelve String?)
 * - trim(): elimina espacios al inicio y final
 * - Patrón: readLine()?.trim() ?: "defecto"
 * - print() vs println(): sin/con salto de línea
 */
