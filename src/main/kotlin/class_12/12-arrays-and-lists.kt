package class_12

/**
 * CLASE 12: ARRAYS Y LISTAS
 * 
 * Conceptos:
 * - Array - tamaño fijo, se puede modificar contenido
 * - Lista inmutable (listOf) - no se puede modificar
 * - Lista mutable (mutableListOf) - se puede modificar
 * - Diferencias y cuándo usar cada uno
 */

fun main() {
    // ==========================================
    // 1. ¿Qué son las colecciones?
    // ==========================================
    
    // Colección = guardar múltiples valores en una sola variable
    // Ejemplo: en lugar de tener email1, email2, email3...
    // Tenemos una lista de emails
    
    println("=== SISTEMA DE EMAILS ===")
    
    // ==========================================
    // 2. ARRAY - Tamaño fijo
    // ==========================================
    
    // Array = tamaño fijo (no crece ni se reduce)
    // Se puede cambiar el contenido, pero no el tamaño
    
    val carpetasEmail = arrayOf("Bandeja", "Enviados", "Borradores")
    println("Carpetas (Array): ${carpetasEmail.joinToString()}")
    
    // Acceder a elementos por índice (empiezan en 0)
    println("Primera carpeta: ${carpetasEmail[0]}")      // Bandeja
    println("Segunda carpeta: ${carpetasEmail[1]}")      // Enviados
    println("Tercera carpeta: ${carpetasEmail[2]}")      // Borradores
    
    // Modificar contenido (SÍ se puede)
    carpetasEmail[0] = "Recibidos"
    println("Carpetas modificadas: ${carpetasEmail.joinToString()}")
    
    // Tamaño del array
    println("Número de carpetas: ${carpetasEmail.size}")
    
    // ❌ NO se puede cambiar el tamaño:
    // carpetasEmail.add("Nueva")  // Error!
    
    // ==========================================
    // 3. LISTA INMUTABLE - No se puede modificar
    // ==========================================
    
    // listOf = lista que NO se puede modificar (ni contenido ni tamaño)
    val emailsImportantes = listOf("admin@empresa.com", "jefe@empresa.com", "soporte@empresa.com")
    println("\nEmails importantes (Lista inmutable): $emailsImportantes")
    
    // Acceder a elementos
    println("Primer email importante: ${emailsImportantes[0]}")
    println("Número de emails importantes: ${emailsImportantes.size}")
    
    // ❌ NO se puede modificar:
    // emailsImportantes[0] = "nuevo@email.com"  // Error!
    // emailsImportantes.add("otro@email.com")   // Error!
    
    // ==========================================
    // 4. LISTA MUTABLE - Se puede modificar
    // ==========================================
    
    // mutableListOf = lista que SÍ se puede modificar (contenido y tamaño)
    val emailsRecibidos = mutableListOf("maria@email.com", "juan@email.com")
    println("\nEmails recibidos (Lista mutable): $emailsRecibidos")
    
    // Agregar elementos
    emailsRecibidos.add("ana@email.com")
    println("Después de agregar: $emailsRecibidos")
    
    // Modificar elementos existentes
    emailsRecibidos[0] = "maria.garcia@email.com"
    println("Después de modificar: $emailsRecibidos")
    
    // Eliminar elementos
    emailsRecibidos.remove("juan@email.com")
    println("Después de eliminar: $emailsRecibidos")
    
    // Tamaño actual
    println("Número de emails recibidos: ${emailsRecibidos.size}")
    
    // ==========================================
    // 5. Comparación directa
    // ==========================================
    
    println("\n=== COMPARACIÓN ===")
    println("ARRAY:")
    println("- Tamaño: FIJO")
    println("- Contenido: SÍ se puede cambiar")
    println("- Uso: Cuando sabes exactamente cuántos elementos tendrás")
    
    println("\nLISTA INMUTABLE (listOf):")
    println("- Tamaño: FIJO")
    println("- Contenido: NO se puede cambiar")
    println("- Uso: Datos que nunca van a cambiar")
    
    println("\nLISTA MUTABLE (mutableListOf):")
    println("- Tamaño: VARIABLE")
    println("- Contenido: SÍ se puede cambiar")
    println("- Uso: Cuando necesitas agregar/quitar elementos")
    
    // ==========================================
    // 6. Ejemplo práctico: Bandeja de entrada
    // ==========================================
    
    fun gestionarBandejaEntrada() {
        val bandejaEntrada = mutableListOf<String>()  // Lista vacía
        
        println("\n=== GESTIÓN DE BANDEJA ===")
        
        // Agregar emails
        bandejaEntrada.add("cliente1@email.com")
        bandejaEntrada.add("cliente2@email.com")
        bandejaEntrada.add("spam@publicidad.com")
        
        println("Emails en bandeja: $bandejaEntrada")
        println("Total de emails: ${bandejaEntrada.size}")
        
        // Eliminar spam
        bandejaEntrada.remove("spam@publicidad.com")
        println("Después de eliminar spam: $bandejaEntrada")
        
        // Verificar si existe un email
        val existeCliente1 = bandejaEntrada.contains("cliente1@email.com")
        println("¿Existe cliente1? $existeCliente1")
    }
    
    gestionarBandejaEntrada()
    
    // ==========================================
    // 7. Ejemplo interactivo
    // ==========================================
    
    println("\n=== LISTA DE CONTACTOS ===")
    val contactos = mutableListOf<String>()
    
    print("Ingresa un email de contacto: ")
    val email1 = readLine()?.trim() ?: "contacto1@email.com"
    contactos.add(email1)
    
    print("Ingresa otro email de contacto: ")
    val email2 = readLine()?.trim() ?: "contacto2@email.com"
    contactos.add(email2)
    
    println("Tus contactos: $contactos")
    println("Número total de contactos: ${contactos.size}")
    
    // ==========================================
    // EJERCICIO
    // ==========================================
    
    println("\n=== EJERCICIO ===")
    println("Crea una lista mutable de asuntos de email y:")
    println("1. Agrega 3 asuntos diferentes")
    println("2. Modifica el segundo asunto")
    println("3. Elimina el primer asunto")
    println("4. Muestra la lista final y su tamaño")
    
    // Solución:
    /*
    val asuntosEmail = mutableListOf<String>()
    
    // 1. Agregar 3 asuntos
    asuntosEmail.add("Reunión de equipo")
    asuntosEmail.add("Reporte mensual")
    asuntosEmail.add("Invitación evento")
    println("Lista inicial: $asuntosEmail")
    
    // 2. Modificar el segundo asunto (índice 1)
    asuntosEmail[1] = "Reporte semanal"
    println("Después de modificar: $asuntosEmail")
    
    // 3. Eliminar el primer asunto (índice 0)
    asuntosEmail.removeAt(0)
    println("Después de eliminar: $asuntosEmail")
    
    // 4. Mostrar lista final y tamaño
    println("Lista final: $asuntosEmail")
    println("Tamaño final: ${asuntosEmail.size}")
    */
}

/**
 * RESUMEN:
 * - Array: tamaño fijo, contenido modificable
 * - listOf(): tamaño fijo, contenido NO modificable
 * - mutableListOf(): tamaño variable, contenido modificable
 * - [índice] para acceder, .size para tamaño
 */

