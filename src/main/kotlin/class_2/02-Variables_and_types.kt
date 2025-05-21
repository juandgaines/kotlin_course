package class_2

// En Kotlin, 'val' se usa para variables de solo lectura (inmutables)
val appName: String = "Inbox Simulator" // No puede cambiar después de su asignación

// 'var' se usa para variables mutables (pueden cambiar su valor)
var unreadEmails: Int = 0 // Puede cambiar a lo largo del programa

// Tipos de datos básicos en Kotlin
val userName: String = "Juan" // Cadena de texto
val userAge: Int = 30 // Número entero
val isLoggedIn: Boolean = true // Booleano (verdadero/falso)
val inboxCapacity: Double = 50.5 // Número decimal

fun main() {
    // Imprimir los valores de las variables
    println("Bienvenido a $appName") // Muestra el nombre de la app
    println("Usuario: $userName") // Muestra el nombre del usuario
    println("Edad: $userAge") // Muestra la edad del usuario
    println("¿Sesión iniciada?: $isLoggedIn") // Muestra si el usuario está logueado
    println("Capacidad de la bandeja de entrada: $inboxCapacity MB") // Muestra la capacidad de la bandeja
    println("Correos no leídos: $unreadEmails") // Muestra la cantidad de correos no leídos

    // Cambiando el valor de una variable mutable
    unreadEmails = 5 // Ahora hay 5 correos no leídos
    println("Correos no leídos actualizados: $unreadEmails") // Muestra el nuevo valor
}
