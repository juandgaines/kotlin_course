package class_06

fun main() {
    // Definimos si el usuario está logueado y si tiene correos no leídos
    val isLoggedIn: Boolean = true // El usuario ha iniciado sesión
    val hasUnreadEmails: Boolean = true // El usuario tiene correos no leídos

    // Operador AND (&&): ambas condiciones deben ser verdaderas
    if (isLoggedIn && hasUnreadEmails) { // Solo entra si ambas son true
        println("Mostrar notificación: Tienes correos sin leer.") // Se muestra la notificación
    }

    // Operador OR (||): al menos una condición debe ser verdadera
    val isAdmin: Boolean = false // El usuario no es administrador
    if (isLoggedIn || isAdmin) { // Entra si alguna es true
        println("Acceso permitido a la bandeja de entrada.") // Permite el acceso
    }

    // Operador NOT (!): invierte el valor booleano
    val isSpam: Boolean = false // El correo no es spam
    if (!isSpam) { // Entra si isSpam es false
        println("Este correo es seguro.") // Informa que el correo es seguro
    }

    // Combinando operadores lógicos
    val isImportant: Boolean = true // El correo es importante
    if ((hasUnreadEmails && isImportant) || isAdmin) { // Si hay correos importantes sin leer o es admin
        println("Resalta los correos importantes sin leer.") // Acción especial
    }
}
