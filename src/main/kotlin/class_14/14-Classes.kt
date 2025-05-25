package class_14

// Clase que representa un correo electrónico
class Email(
    val sender: String,         // Remitente del correo
    val subject: String,        // Asunto del correo
    val content: String,        // Contenido del correo
    var isRead: Boolean = false // Estado de leído/no leído (por defecto es no leído)
) {
    // Método para marcar el correo como leído
    fun markAsRead() {
        isRead = true // Cambia el estado a leído
    }

    // Método para mostrar un resumen del correo
    fun showSummary() {
        println("De: $sender | Asunto: $subject | Leído: $isRead") // Muestra resumen del correo
    }
}

// Clase que representa la bandeja de entrada (Inbox) de un usuario
class Inbox {
    // Lista mutable de correos electrónicos en la bandeja de entrada
    private val emails: MutableList<Email> = mutableListOf() // Inicialmente vacía

    // Método para agregar un correo a la bandeja de entrada
    fun receiveEmail(email: Email) {
        emails.add(email) // Agrega el correo a la lista
    }

    // Método para mostrar todos los correos de la bandeja
    fun showAllEmails() {
        if (emails.isEmpty()) { // Si la lista está vacía
            println("No tienes correos en tu bandeja de entrada.") // Mensaje si no hay correos
        } else {
            println("Tus correos:")
            for (email in emails) { // Itera sobre cada correo
                email.showSummary() // Muestra el resumen del correo
            }
        }
    }

    // Método para contar los correos no leídos
    fun countUnreadEmails(): Int {
        return emails.count { !it.isRead } // Cuenta los correos donde isRead es false
    }

    // Método para marcar un correo como leído por índice
    fun markEmailAsRead(index: Int) {
        if (index in emails.indices) { // Verifica que el índice sea válido
            emails[index].markAsRead() // Marca el correo como leído
        }
    }
}

// Clase que representa a un usuario del sistema
class User(
    val userName: String,         // Nombre de usuario (propiedad inmutable)
    private val password: String  // Contraseña (privada para encapsulamiento)
) {
    val inbox: Inbox = Inbox() // Cada usuario tiene su propia bandeja de entrada

    // Método para verificar si la contraseña ingresada es correcta
    fun checkPassword(input: String): Boolean {
        return input == password // Retorna true si la contraseña coincide
    }

    // Método para mostrar un saludo personalizado
    fun greet() {
        println("Bienvenido, $userName") // Saluda al usuario
    }

    // Método para mostrar la cantidad de correos no leídos
    fun showUnreadEmails() {
        val unreadCount = inbox.countUnreadEmails() // Obtiene la cantidad de correos no leídos
        println("Tienes $unreadCount correos no leídos.") // Muestra la cantidad de correos no leídos
    }
}

fun main() {
    // Creamos un usuario de ejemplo
    val user = User("Juan", "1234abcd") // Instancia de User con nombre y contraseña

    // Agregamos algunos correos a la bandeja del usuario usando el método de Inbox
    user.inbox.receiveEmail(Email("soporte@inbox.com", "Bienvenido", "Gracias por usar Inbox Simulator")) // Correo 1
    user.inbox.receiveEmail(Email("amigo@email.com", "Hola!", "¿Cómo estás?")) // Correo 2
    user.inbox.receiveEmail(Email("news@kotlinlang.org", "Novedades Kotlin", "¡Descubre las nuevas funciones!")) // Correo 3

    // Simulamos el ingreso de la contraseña por parte del usuario
    print("Ingresa tu contraseña: ") // Pide la contraseña
    val inputPassword = readLine() ?: "" // Lee la entrada, usa cadena vacía si es null

    // Verificamos la contraseña usando el método de la clase User
    if (user.checkPassword(inputPassword)) { // Si la contraseña es correcta
        user.greet() // Saluda al usuario
        user.showUnreadEmails() // Muestra los correos no leídos

        // Mostramos el resumen de todos los correos usando el método de Inbox
        user.inbox.showAllEmails()

        // Marcamos el primer correo como leído y mostramos el resumen actualizado
        user.inbox.markEmailAsRead(0) // Marca el primer correo como leído
        println("Después de leer el primer correo:")
        user.showUnreadEmails() // Muestra la cantidad de correos no leídos actualizada
    } else { // Si la contraseña es incorrecta
        println("Contraseña incorrecta.") // Mensaje de error
    }
}
