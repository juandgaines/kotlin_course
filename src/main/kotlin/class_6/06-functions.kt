package class_6

// Definimos una función para saludar al usuario
fun greetUser(userName: String) { // Recibe el nombre del usuario como parámetro
    println("Bienvenido, $userName") // Imprime un mensaje de bienvenida
}

// Definimos una función para contar los correos no leídos
fun showUnreadEmails(unreadEmails: Int) { // Recibe la cantidad de correos no leídos como parámetro
    println("Tienes $unreadEmails correos no leídos.") // Imprime la cantidad de correos no leídos
}

// Definimos una función que verifica si el usuario está logueado y retorna un mensaje
fun checkLogin(isLoggedIn: Boolean): String { // Recibe el estado de login y retorna un String
    // Usa una expresión if para decidir el mensaje
    return if (isLoggedIn) { // Si está logueado
        "Sesión iniciada correctamente." // Mensaje si está logueado
    } else { // Si no está logueado
        "Por favor, inicia sesión." // Mensaje si no está logueado
    }
}

fun main() {
    // Variables de ejemplo para usar en las funciones
    val userName = "Juan" // Nombre del usuario
    val unreadEmails = 5 // Correos no leídos
    val isLoggedIn = true // Estado de login

    // Llamamos a la función para saludar al usuario
    greetUser(userName) // Llama a greetUser con el nombre

    // Llamamos a la función para mostrar los correos no leídos
    showUnreadEmails(unreadEmails) // Llama a showUnreadEmails con la cantidad

    // Llamamos a la función que verifica el login y mostramos el mensaje resultante
    val loginMessage = checkLogin(isLoggedIn) // Llama a checkLogin y guarda el mensaje
    println(loginMessage) // Imprime el mensaje de login
}
