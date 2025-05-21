package class_8

fun main() {
    // Ejemplo básico de nullabilidad con tipos primitivos
    var userName: String = "Juan" // Variable no nullable, no puede ser null
    // userName = null // Esto causaría error de compilación

    var secondaryEmail: String? = null // Variable nullable, puede ser null
    println("Correo secundario: $secondaryEmail") // Imprime null

    secondaryEmail = "juan.secundario@email.com" // Ahora tiene un valor
    println("Correo secundario actualizado: $secondaryEmail") // Imprime el nuevo valor

    // Uso del operador safe call (?.) para evitar NullPointerException
    println("Longitud del correo secundario: ${secondaryEmail?.length}") // Si es null, retorna null

    // Uso del operador Elvis (?:) para asignar un valor por defecto si es null
    val longitud: Int = secondaryEmail?.length ?: 0 // Si es null, usa 0
    println("Longitud segura: $longitud") // Imprime la longitud o 0

    // Uso de nullabilidad en clases del dominio
    class Email(val subject: String, val content: String?)

    val email1 = Email("Bienvenida", "¡Hola, bienvenido a Inbox Simulator!") // content no es null
    val email2 = Email("Sin contenido", null) // content es null

    // Acceso seguro al contenido del correo
    println("Contenido email1: ${email1.content ?: "Sin contenido"}") // Imprime el contenido o mensaje por defecto
    println("Contenido email2: ${email2.content ?: "Sin contenido"}") // Imprime el mensaje por defecto
}
