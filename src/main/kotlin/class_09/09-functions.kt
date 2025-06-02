package class_09

/**
 * CLASE 9: FUNCIONES
 * 
 * Conceptos:
 * - fun - crear funciones
 * - Parámetros y argumentos
 * - return - devolver valores
 * - Parámetros por defecto
 * - Combinando funciones con readLine()
 */

// ==========================================
// 1. Función básica sin parámetros
// ==========================================

fun mostrarBienvenida() {
    println("=== SISTEMA DE EMAIL ===")
    println("Bienvenido al gestor de emails")
}

// ==========================================
// 2. Función con parámetros
// ==========================================

fun saludarUsuario(nombre: String) {
    println("Hola $nombre, tienes nuevos emails")
}

// ==========================================
// 3. Función que devuelve valor (return)
// ==========================================

fun leerEmail(): String {
    print("Ingresa tu email: ")
    val email = readLine()?.trim() ?: "sin-email@ejemplo.com"
    return email  // Devuelve el email leído
}

fun leerAsunto(): String {
    print("Ingresa el asunto: ")
    return readLine()?.trim() ?: "Sin asunto"
}

// ==========================================
// 4. Función con múltiples parámetros
// ==========================================

fun crearMensajeEmail(destinatario: String, asunto: String, mensaje: String) {
    println("=============================")
    println("EMAIL CREADO")
    println("=============================")
    println("Para: $destinatario")
    println("Asunto: $asunto")
    println("Mensaje: $mensaje")
    println("=============================")
}

// ==========================================
// 5. Función con parámetros por defecto
// ==========================================

fun enviarEmail(destinatario: String, asunto: String = "Sin asunto", prioridad: String = "Normal") {
    println("Enviando email...")
    println("Para: $destinatario")
    println("Asunto: $asunto")
    println("Prioridad: $prioridad")
    println("¡Email enviado!")
}

fun main() {
    // ==========================================
    // Usando las funciones
    // ==========================================
    
    // 1. Función sin parámetros
    mostrarBienvenida()
    
    // 2. Función con parámetros
    saludarUsuario("María")
    
    // 3. Funciones que devuelven valores
    val emailUsuario = leerEmail()        // Llama función y guarda resultado
    val asuntoEmail = leerAsunto()        // Llama función y guarda resultado
    
    println("Email capturado: $emailUsuario")
    println("Asunto capturado: $asuntoEmail")
    
    // 4. Leer mensaje usando readLine directamente
    print("Ingresa el mensaje: ")
    val mensajeEmail = readLine()?.trim() ?: "Sin mensaje"
    
    // 5. Función con múltiples parámetros
    crearMensajeEmail(emailUsuario, asuntoEmail, mensajeEmail)
    
    // 6. Función con parámetros por defecto
    enviarEmail("juan@email.com")                           // Usa valores por defecto
    enviarEmail("ana@email.com", "Reunión")                 // Solo cambia asunto
    enviarEmail("carlos@email.com", "Urgente", "Alta")      // Cambia todo
    
    // ==========================================
    // EJERCICIO
    // ==========================================
    
    println("\n=== EJERCICIO ===")
    println("Crea una función llamada 'leerDatosCompletos' que:")
    println("1. No reciba parámetros")
    println("2. Use readLine() para pedir nombre y email")
    println("3. Devuelva un mensaje con los datos")
    println("Luego úsala en main()")
    
    // Solución:
    /*
    fun leerDatosCompletos(): String {
        print("Ingresa tu nombre: ")
        val nombre = readLine()?.trim() ?: "Anónimo"
        
        print("Ingresa tu email: ")
        val email = readLine()?.trim() ?: "sin-email@ejemplo.com"
        
        return "Usuario: $nombre - Email: $email"
    }
    
    // En main():
    val datosUsuario = leerDatosCompletos()
    println(datosUsuario)
    */
}

/**
 * RESUMEN:
 * - fun nombreFuncion() { } - crear función
 * - fun conParametros(param: Tipo) - recibir datos
 * - fun conReturn(): Tipo { return valor } - devolver datos
 * - fun conDefecto(param: Tipo = "valor") - parámetros opcionales
 */
