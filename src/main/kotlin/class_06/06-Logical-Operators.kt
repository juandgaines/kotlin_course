package class_06

/**
 * CLASE 6: OPERADORES LÓGICOS
 * 
 * Conceptos:
 * - && (AND), || (OR), ! (NOT)
 * - Comparaciones: ==, !=, <, >, <=, >=
 * - Validaciones prácticas
 */

fun main() {
    // ==========================================
    // 1. Operadores de comparación
    // ==========================================
    
    val emailsRecibidos = 15
    val emailsEnviados = 10
    val limiteEmails = 20
    
    val tieneEmails = emailsRecibidos > 0           // true
    val excedeEnviados = emailsEnviados >= limiteEmails  // false
    val sonIguales = emailsRecibidos == emailsEnviados   // false
    val sonDiferentes = emailsRecibidos != emailsEnviados // true
    
    // ==========================================
    // 2. Operadores lógicos
    // ==========================================
    
    val email = "user@example.com"
    val password = "1234"
    
    // AND (&&) - Ambas condiciones deben ser true
    val tieneArroba = email.contains("@")
    val tienePunto = email.contains(".")
    val emailValido = tieneArroba && tienePunto
    
    // OR (||) - Al menos una condición debe ser true
    val passwordCorto = password.length < 6
    val passwordLargo = password.length > 20
    val passwordProblematico = passwordCorto || passwordLargo
    
    // NOT (!) - Invierte el valor
    val emailInvalido = !emailValido
    val passwordBueno = !passwordProblematico
    
    println("Email válido: $emailValido")
    println("Password problemático: $passwordProblematico")
    
    // ==========================================
    // 3. Validación completa
    // ==========================================
    
    val puedeIniciarSesion = emailValido && passwordBueno
    val necesitaAyuda = emailInvalido || passwordProblematico
    
    println("Puede iniciar sesión: $puedeIniciarSesion")
    
    // ==========================================
    // 4. Ejemplo práctico: Filtro de spam
    // ==========================================
    
    val asunto = "URGENTE: Oferta especial"
    val remitente = "spam@suspicious.com"
    
    val tieneSpamPalabras = asunto.contains("URGENTE") || asunto.contains("GRATIS")
    val esDominioSospechoso = remitente.contains("suspicious") || remitente.contains("spam")
    val esSpam = tieneSpamPalabras && esDominioSospechoso
    
    println("Es spam: $esSpam")
    
    // ==========================================
    // EJERCICIO
    // ==========================================
    
    println("\n=== EJERCICIO ===")
    println("Valida email: debe tener @ y ., no debe contener 'test'")
    println("Valida que no sea spam: asunto no debe tener 'GRATIS' o 'URGENTE'")
    
    // Solución:
    /*
    val emailTest = "usuario@correo.com"
    val asuntoTest = "Reunión de trabajo"
    
    val emailOk = emailTest.contains("@") && emailTest.contains(".") && !emailTest.contains("test")
    val noEsSpam = !asuntoTest.contains("GRATIS") && !asuntoTest.contains("URGENTE")
    val emailAceptable = emailOk && noEsSpam
    
    println("Email aceptable: $emailAceptable")
    */
}

/**
 * RESUMEN:
 * - Comparación: ==, !=, <, >, <=, >=
 * - Lógicos: && (AND), || (OR), ! (NOT)
 * - && = ambas true, || = al menos una true, ! = invierte
 */

