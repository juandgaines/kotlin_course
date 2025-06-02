package class_13

/**
 * CLASE 13: BUCLES (LOOPS)
 * 
 * Conceptos:
 * - while - repetir mientras condición sea true
 * - do-while - ejecutar al menos una vez
 * - for con ranges (1..5, 1 until 5, downTo, step)
 * - for con listas
 */

fun main() {
    println("=== BUCLES EN KOTLIN ===")
    
    // ==========================================
    // 1. WHILE - Repetir mientras sea true
    // ==========================================
    
    var emailsPendientes = 3
    println("\n1. WHILE:")
    
    while (emailsPendientes > 0) {
        println("Procesando email. Quedan: $emailsPendientes")
        emailsPendientes--
    }
    println("✅ Todos procesados")
    
    // ==========================================
    // 2. DO-WHILE - Al menos una vez
    // ==========================================
    
    var intentos = 0
    println("\n2. DO-WHILE:")
    
    do {
        intentos++
        println("Intento #$intentos de envío")
    } while (intentos < 2)
    
    // ==========================================
    // 3. FOR con RANGES
    // ==========================================
    
    println("\n3. FOR con RANGES:")
    
    // 1..5 incluye el 5
    print("1..5: ")
    for (i in 1..5) {
        print("$i ")
    }
    
    // 1 until 5 NO incluye el 5
    print("\n1 until 5: ")
    for (i in 1 until 5) {
        print("$i ")
    }
    
    // downTo = hacia atrás
    print("\n5 downTo 1: ")
    for (i in 5 downTo 1) {
        print("$i ")
    }
    
    // step = saltar números
    print("\n1..10 step 2: ")
    for (i in 1..10 step 2) {
        print("$i ")
    }
    
    // ==========================================
    // 4. FOR con LISTAS
    // ==========================================
    
    println("\n\n4. FOR con LISTAS:")
    
    val emails = listOf("admin@email.com", "user@email.com", "test@email.com")
    
    // Recorrer elementos
    for (email in emails) {
        println("📧 $email")
    }
    
    // Recorrer con índices
    println("\nCon índices:")
    for ((indice, email) in emails.withIndex()) {
        println("$indice: $email")
    }
    
    // ==========================================
    // 5. Ejemplo práctico
    // ==========================================
    
    println("\n=== EJEMPLO PRÁCTICO ===")
    val asuntos = mutableListOf<String>()
    
    // Crear lista con for
    for (i in 1..3) {
        print("Ingresa asunto #$i: ")
        val asunto = readLine()?.trim() ?: "Asunto $i"
        asuntos.add(asunto)
    }
    
    // Mostrar con while
    var indice = 0
    println("\nAsuntos ingresados:")
    while (indice < asuntos.size) {
        println("${indice + 1}. ${asuntos[indice]}")
        indice++
    }
    
    // ==========================================
    // EJERCICIO
    // ==========================================
    
    println("\n=== EJERCICIO ===")
    println("Crea una lista de 3 emails usando for")
    println("Luego recórrela con while y cuenta cuántos contienen '@'")
    
    // Solución:
    /*
    val misEmails = mutableListOf<String>()
    
    for (i in 1..3) {
        print("Email #$i: ")
        val email = readLine()?.trim() ?: "email$i@test.com"
        misEmails.add(email)
    }
    
    var contador = 0
    var pos = 0
    while (pos < misEmails.size) {
        if (misEmails[pos].contains("@")) {
            contador++
        }
        pos++
    }
    
    println("Emails válidos: $contador")
    */
}

/**
 * RESUMEN:
 * - while (condicion) { } - repetir mientras sea true
 * - do { } while (condicion) - ejecutar al menos una vez
 * - for (i in 1..5) - del 1 al 5 (incluye 5)
 * - for (i in 1 until 5) - del 1 al 4 (NO incluye 5)
 * - for (item in lista) - recorrer lista
 */

