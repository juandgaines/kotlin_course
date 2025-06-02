package class_04

/**
 * CLASE 4: VARIABLES Y TIPOS DE DATOS
 * 
 * Conceptos:
 * - val (inmutable) vs var (mutable)
 * - Tipos básicos: Int, Float, String, Boolean
 * - Conversiones y división con decimales
 */

fun main() {
    // ==========================================
    // 1. val vs var
    // ==========================================
    
    val nombreUsuario = "Juan Pérez"        // Inmutable - NO cambia
    var emailsNoLeidos = 5                  // Mutable - SÍ cambia
    
    emailsNoLeidos = 3  // ✅ Funciona
    // nombreUsuario = "Otro" // ❌ Error!
    
    println("Usuario: $nombreUsuario, Emails: $emailsNoLeidos")
    
    // ==========================================
    // 2. Tipos básicos
    // ==========================================
    
    val totalEmails: Int = 150              // Enteros
    val porcentaje: Float = 75.5f           // Decimales
    val asunto: String = "Reunión"          // Texto
    val esUrgente: Boolean = true           // true/false
    
    // ==========================================
    // 3. Conversiones
    // ==========================================
    
    val numero = 42
    val comoTexto = numero.toString()       // "42"
    val textoNumero = "25".toInt()          // 25
    
    // ==========================================
    // 4. División con decimales
    // ==========================================
    
    val leidos = 15
    val totales = 20
    
    // ❌ División entera: 15 / 20 = 0
    val mal = leidos / totales
    
    // ✅ División decimal: 15.0 / 20.0 = 0.75
    val bien = leidos.toFloat() / totales.toFloat()
    
    println("División entera: $mal")
    println("División decimal: $bien")
    println("Porcentaje: ${bien * 100}%")
    
    // ==========================================
    // EJERCICIO
    // ==========================================
    
    println("\n=== EJERCICIO ===")
    println("Crea: nombre (val), emails recibidos/enviados (var)")
    println("Calcula porcentaje de emails enviados")
    
    // Solución:
    /*
    val nombre = "María"
    var recibidos = 12
    var enviados = 8
    val porcentajeEnviados = (enviados.toFloat() / (recibidos + enviados)) * 100
    println("$nombre - Enviados: ${porcentajeEnviados}%")
    */
}

/**
 * RESUMEN:
 * - val = inmutable, var = mutable
 * - Int, Float, String, Boolean
 * - .toFloat(), .toInt(), .toString()
 * - Para decimales: convertir antes de dividir
 */