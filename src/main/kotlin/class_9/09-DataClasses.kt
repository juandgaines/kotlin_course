package class_9

// Definimos una data class para Email
// Las data classes generan automáticamente métodos como equals, hashCode, toString y copy
data class Email(
    val sender: String,             // Remitente del correo
    val subject: String,            // Asunto del correo
    val content: String?,           // Contenido del correo, puede ser null (nullabilidad)
    var isRead: Boolean = false     // Estado de leído/no leído (por defecto es no leído)
)

// Definimos una data class para User
// Aquí, la bandeja de entrada es una lista mutable de correos electrónicos
data class User(
    val userName: String,                   // Nombre de usuario
    val password: String,                   // Contraseña (en un caso real, nunca guardarías la contraseña así)
    val emails: MutableList<Email> = mutableListOf() // Lista de correos electrónicos del usuario
) {
    // Método para contar los correos no leídos
    fun countUnreadEmails(): Int {
        return emails.count { !it.isRead } // Cuenta los correos donde isRead es false
    }

    // Método para mostrar todos los correos
    fun showAllEmails() {
        if (emails.isEmpty()) {
            println("No tienes correos en tu bandeja de entrada.")
        } else {
            println("Tus correos:")
            for (email in emails) {
                println(email) // Gracias a data class, toString es legible
            }
        }
    }

    // Método para marcar un correo como leído por índice
    fun markEmailAsRead(index: Int) {
        if (index in emails.indices) {
            emails[index] = emails[index].copy(isRead = true) // Usamos copy de data class para actualizar el estado
        }
    }

    // Método para obtener un correo por índice (puede ser null si el índice es inválido)
    fun getEmail(index: Int): Email? {
        return emails.getOrNull(index) // Retorna el correo o null si el índice es inválido
    }
}

fun main() {
    // Creamos un usuario usando data class
    val user = User("Juan", "1234abcd") // Instancia de User con nombre y contraseña

    // Agregamos algunos correos a la bandeja del usuario usando data class
    user.emails.add(Email("soporte@inbox.com", "Bienvenido", "Gracias por usar Inbox Simulator")) // Correo 1
    user.emails.add(Email("amigo@email.com", "Hola!", null)) // Correo 2 con contenido null
    user.emails.add(Email("news@kotlinlang.org", "Novedades Kotlin", "¡Descubre las nuevas funciones!")) // Correo 3

    // Simulamos el ingreso de la contraseña por parte del usuario
    print("Ingresa tu contraseña: ")
    val inputPassword = readLine() ?: ""

    // Verificamos la contraseña
    if (inputPassword == user.password) {
        println("Bienvenido, ${user.userName}")
        println("Tienes ${user.countUnreadEmails()} correos no leídos.")

        // Mostramos todos los correos
        user.showAllEmails()

        // Ejemplo de nullabilidad: accedemos al contenido de un correo que puede ser null
        val emailToRead: Email? = user.getEmail(1) // Intentamos obtener el segundo correo
        if (emailToRead != null) {
            println("Contenido del correo: ${emailToRead.content ?: "Sin contenido"}") // Safe call y Elvis operator
            user.markEmailAsRead(1) // Marcamos como leído usando copy
        }

        println("Después de leer el segundo correo:")
        println("Tienes ${user.countUnreadEmails()} correos no leídos.")
    } else {
        println("Contraseña incorrecta.")
    }

    // Ejemplo de uso de equals
    val emailA = Email("soporte@inbox.com", "Bienvenido", "Gracias por usar Inbox Simulator")
    val emailB = Email("soporte@inbox.com", "Bienvenido", "Gracias por usar Inbox Simulator")
    val emailC = Email("otro@email.com", "Hola", "Otro contenido")

    println("¿emailA es igual a emailB?: ${emailA == emailB}") // true, porque los datos son iguales
    println("¿emailA es igual a emailC?: ${emailA == emailC}") // false, porque los datos son diferentes

    // Ejemplo de uso de hashCode
    println("HashCode de emailA: ${emailA.hashCode()}") // Muestra el hashCode generado automáticamente
    println("HashCode de emailB: ${emailB.hashCode()}") // Igual al de emailA porque los datos son iguales
    println("HashCode de emailC: ${emailC.hashCode()}") // Diferente porque los datos son distintos

    // Ejemplo de uso de toString
    println("Representación de emailA: $emailA") // Muestra una representación legible del objeto

    // Ejemplo de uso de copy
    val emailD = emailA.copy(subject = "Nuevo asunto") // Crea una copia de emailA con un asunto diferente
    println("Copia de emailA con asunto modificado: $emailD") // Muestra la copia con el nuevo asunto
}

/*
Diferencias entre data class y class normal en Kotlin:
- Las data class generan automáticamente métodos útiles como equals, hashCode, toString y copy.
- Son ideales para representar modelos de datos (como Email y User en este ejemplo).
- Permiten trabajar fácilmente con la inmutabilidad y la manipulación de datos (por ejemplo, usando copy).
- Una clase normal requiere que implementes manualmente estos métodos si los necesitas.
- La nullabilidad se maneja igual en ambos casos, pero las data class facilitan el manejo de datos y su representación.
*/
