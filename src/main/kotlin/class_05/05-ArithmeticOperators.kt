package class_05

/**
 * CLASE 5: OPERADORES ARITMÉTICOS
 * 
 * Conceptos:
 * - Operadores básicos: +, -, *, /, %
 * - Orden de operaciones
 * - Operadores de asignación
 */

fun main() {
    // ==========================================
    // 1. Operadores básicos
    // ==========================================
    
    val emailsRecibidos = 25
    val emailsEnviados = 15
    val emailsEliminados = 3
    
    val totalEmails = emailsRecibidos + emailsEnviados    // Suma
    val diferencia = emailsRecibidos - emailsEnviados     // Resta
    val dobleEmails = emailsRecibidos * 2                 // Multiplicación
    val promedio = totalEmails / 2                        // División
    val resto = emailsRecibidos % 7                       // Módulo (resto)
    
    println("Total: $totalEmails, Promedio: $promedio, Resto: $resto")
    
    // ==========================================
    // 2. Orden de operaciones (PEMDAS)
    // ==========================================
    
    val calculo1 = 10 + 5 * 2        // = 20 (primero 5*2, luego +10)
    val calculo2 = (10 + 5) * 2      // = 30 (primero paréntesis)
    val emailsPorSemana = emailsRecibidos * 7 + emailsEnviados * 7
    
    // ==========================================
    // 3. Operadores de asignación
    // ==========================================
    
    var contador = 10
    contador += 5        // contador = contador + 5 (15)
    contador -= 2        // contador = contador - 2 (13)
    contador *= 2        // contador = contador * 2 (26)
    contador /= 2        // contador = contador / 2 (13)
    contador %= 5        // contador = contador % 5 (3)
    
    println("Contador final: $contador")
    
    // ==========================================
    // 4. Ejemplo práctico: Estadísticas de email
    // ==========================================
    
    val emailsHoy = 12
    val emailsAyer = 8
    val diasEnMes = 30
    
    val incremento = emailsHoy - emailsAyer
    val porcentajeIncremento = (incremento.toFloat() / emailsAyer) * 100
    val proyeccionMensual = emailsHoy * diasEnMes
    
    println("Incremento: $incremento emails (${porcentajeIncremento}%)")
    println("Proyección mensual: $proyeccionMensual emails")
    
    // ==========================================
    // EJERCICIO
    // ==========================================
    
    println("\n=== EJERCICIO ===")
    println("Calcula: cuota diaria (50), emails enviados (35)")
    println("¿Cuántos quedan? ¿Cuántos días para reset (7 días)?")
    
    // Solución:
    /*
    val cuotaDiaria = 50
    val enviados = 35
    val quedan = cuotaDiaria - enviados
    val diasParaReset = 7 - 1  // Asumiendo que es día 1
    println("Quedan: $quedan emails, Reset en: $diasParaReset días")
    */
}

/**
 * RESUMEN:
 * - +, -, *, /, % (suma, resta, multiplicación, división, módulo)
 * - Orden: paréntesis, multiplicación/división, suma/resta
 * - +=, -=, *=, /=, %= (operadores de asignación)
 */