package class_07

/**
 * CLASE 7: NULLABILITY (NULABILIDAD)
 * 
 * Conceptos:
 * - ¿Por qué null? (ausencia de valor)
 * - ? (Tipo Nullable) - permite valores null
 * - ?. (Safe Call) - llamada segura
 * - ?: (Elvis Operator) - operador elvis, valor por defecto
 * - !! (Not-null Assertion) - afirmación no-nulo, fuerza el valor
 */

fun main() {
    // ==========================================
    // 1. ¿Por qué null?
    // ==========================================
    
    // null = ausencia de valor (no existe, vacío, sin datos)
    // Ejemplos reales: email opcional, nombre no proporcionado, etc.
    
    var emailOpcional: String? = null        // Puede ser null
    var nombreCompleto: String? = "Juan"     // Puede ser null, pero tiene valor
    var emailObligatorio: String = "user@email.com"  // NO puede ser null
    
    // ==========================================
    // 2. ? (Tipo Nullable - "Tipo Nulable")
    // ==========================================
    
    // ? después del tipo = "este valor PUEDE ser null"
    var mensaje: String? = null              // ✅ Puede ser null
    var asunto: String = "Reunión"           // ❌ NO puede ser null
    
    // mensaje = null        // ✅ Funciona (es nullable)
    // asunto = null         // ❌ Error! (no es nullable)
    
    // ==========================================
    // 3. ?. (Safe Call - "Llamada Segura")
    // ==========================================
    
    // ?. = "ejecuta SOLO si NO es null, si es null devuelve null"
    val longitudEmail = emailOpcional?.length        // null (porque emailOpcional es null)
    val longitudNombre = nombreCompleto?.length      // 4 (porque nombreCompleto tiene valor)
    
    println("Longitud email: $longitudEmail")       // null
    println("Longitud nombre: $longitudNombre")     // 4
    
    // Sin ?. tendríamos que hacer:
    // val longitud = if (emailOpcional != null) emailOpcional.length else null
    
    // ==========================================
    // 4. ?: (Elvis Operator - "Operador Elvis")
    // ==========================================
    
    // ?: = "si es null, usa este valor en su lugar"
    // Se llama Elvis porque ?: parece el peinado de Elvis Presley 🕺
    
    val emailParaMostrar = emailOpcional ?: "Sin email"
    val nombreParaMostrar = nombreCompleto ?: "Anónimo"
    
    println("Email: $emailParaMostrar")              // "Sin email"
    println("Nombre: $nombreParaMostrar")            // "Juan"
    
    // Combinando Safe Call + Elvis
    val longitudSegura = emailOpcional?.length ?: 0  // Si es null, longitud = 0
    println("Longitud segura: $longitudSegura")     // 0
    
    // ==========================================
    // 5. !! (Not-null Assertion - "Afirmación No-Nulo")
    // ==========================================
    
    // !! = "estoy 100% seguro que NO es null, convierte a tipo no-nullable"
    emailOpcional = "nuevo@email.com"
    val longitudForzada = emailOpcional!!.length     // 15 (funciona porque ya no es null)
    
    // ⚠️ PELIGRO: Si fuera null, la app se cierra (crash)
    // emailOpcional = null
    // val crash = emailOpcional!!.length  // ❌ KotlinNullPointerException
    
    println("Longitud forzada: $longitudForzada")
    
    // ==========================================
    // 6. Ejemplo práctico: Variables de perfil
    // ==========================================
    
    val emailUsuario: String = "user@email.com"     // Obligatorio (no nullable)
    var nombreUsuario: String? = null               // Opcional (nullable)
    var telefonoUsuario: String? = "123456789"      // Opcional (nullable)
    
    // Usando todos los operadores
    val saludo = "Hola ${nombreUsuario ?: "Usuario"}"                    // Elvis
    val infoTelefono = telefonoUsuario?.let { "Tel: $it" } ?: "Sin tel"  // Safe call + Elvis
    
    println("$saludo - Email: $emailUsuario - $infoTelefono")
    
    // ==========================================
    // EJERCICIO
    // ==========================================
    
    println("\n=== EJERCICIO ===")
    println("Crea variables para: email (obligatorio), nombre (opcional)")
    println("Usa ?: para mostrar 'Anónimo' si nombre es null")
    println("Usa ?. para obtener la longitud del nombre de forma segura")
    
    // Solución:
    /*
    val miEmail: String = "maria@email.com"
    val miNombre: String? = null
    val nombreMostrar = miNombre ?: "Anónimo"
    val longitudNombre = miNombre?.length ?: 0
    println("Email: $miEmail - Usuario: $nombreMostrar - Longitud: $longitudNombre")
    */
}

/**
 * RESUMEN DE OPERADORES:
 * 
 * ? (Tipo Nullable): String? = puede ser null
 * ?. (Safe Call): variable?.metodo = ejecuta solo si no es null
 * ?: (Elvis): variable ?: "defecto" = usa valor por defecto si es null
 * !! (Not-null Assertion): variable!! = fuerza conversión (peligroso)
 */

