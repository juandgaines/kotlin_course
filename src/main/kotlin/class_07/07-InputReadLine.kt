package class_07

fun main() {
    // Solicita al usuario que ingrese su nombre
    print("Por favor, ingresa tu nombre de usuario: ") // Muestra un mensaje en consola
    val userName: String? = readLine() // Lee la entrada del usuario como String (puede ser null)

    // Solicita al usuario que ingrese la cantidad de correos no leídos
    print("¿Cuántos correos no leídos tienes?: ") // Muestra un mensaje en consola
    val unreadInput: String? = readLine() // Lee la entrada como String (puede ser null)
    val unreadEmails: Int = unreadInput?.toIntOrNull() ?: 0 // Convierte la entrada a Int, si es inválida usa 0

    // Solicita al usuario que indique si está logueado (true/false)
    print("¿Has iniciado sesión? (true/false): ") // Muestra un mensaje en consola
    val loggedInInput: String? = readLine() // Lee la entrada como String (puede ser null)
    val isLoggedIn: Boolean = loggedInInput?.toBoolean() ?: false // Convierte la entrada a Boolean, si es inválida usa false

    // Muestra la información ingresada por el usuario
    println("Bienvenido, $userName") // Saluda al usuario por su nombre
    println("Tienes $unreadEmails correos no leídos.") // Muestra la cantidad de correos no leídos
    println("¿Sesión iniciada?: $isLoggedIn") // Muestra si el usuario está logueado
}
