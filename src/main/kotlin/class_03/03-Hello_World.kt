package class_03

/**
 * CLASE 3: INTRODUCCIÓN & HOLA MUNDO
 * 
 * En esta clase aprenderemos:
 * - Qué es Kotlin y por qué usarlo
 * - La función main() como punto de entrada
 * - Cómo imprimir texto en consola
 * - Estructura básica de un programa Kotlin
 * 
 * PROYECTO: Sistema de Bandeja de Entrada de Email
 * Comenzaremos creando nuestro primer mensaje de bienvenida
 */

fun main() {
    // La función main() es el punto de entrada de cualquier aplicación Kotlin
    // Es donde comienza la ejecución del programa
    
    // println() imprime texto en la consola y añade una nueva línea al final
    println("¡Bienvenido a tu Bandeja de Entrada de Email!")
    
    // También podemos usar print() que NO añade nueva línea
    print("Sistema iniciado... ")
    println("¡Listo!")
    
    // Podemos imprimir múltiples líneas
    println("=================================")
    println("    SISTEMA DE EMAIL KOTLIN")
    println("=================================")
    
    // EJERCICIO PRÁCTICO:
    println("\n=== EJERCICIO ===")
    println("Crea tu propio mensaje de bienvenida que incluya:")
    println("1. Tu nombre")
    println("2. El nombre de tu aplicación de email")
    println("3. Un mensaje motivacional")
    println("4. Usa al menos 3 println() diferentes")
    
    // Ejemplo de solución (descomenta para probar):
    /*
    println("\n¡Hola! Soy [Tu Nombre]")
    println("Bienvenido a [Nombre de tu App] Email")
    println("¡Vamos a aprender Kotlin juntos!")
    println("¡El futuro es ahora!")
    */
}

/**
 * CONCEPTOS IMPORTANTES A RECORDAR:
 * 
 * 1. FUNCIÓN MAIN: Es obligatoria en todo programa Kotlin
 *    - Sintaxis: fun main() { }
 *    - Es donde inicia la ejecución
 * 
 * 2. PRINTLN vs PRINT:
 *    - println(): imprime y añade nueva línea
 *    - print(): imprime sin nueva línea
 * 
 * 3. COMENTARIOS:
 *    - // para comentarios de una línea
 *    - /* */ para comentarios de múltiples líneas
 *    - /** */ para documentación
 * 
 * 4. STRINGS (CADENAS):
 *    - Se escriben entre comillas dobles "texto"
 *    - Pueden contener caracteres especiales como \n (nueva línea)
 */