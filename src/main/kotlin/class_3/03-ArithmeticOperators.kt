package class_3

fun main() {
    // Supongamos que tenemos 10 correos en la bandeja de entrada
    var totalEmails: Int = 10 // Variable mutable para el total de correos

    // Llegan 3 correos nuevos
    totalEmails = totalEmails + 3 // Suma: agrega 3 al total
    println("Total de correos después de recibir nuevos: $totalEmails") // Muestra 13

    // Leemos 2 correos
    totalEmails = totalEmails - 2 // Resta: elimina 2 del total
    println("Total de correos después de leer algunos: $totalEmails") // Muestra 11

    // Marcamos 2 correos como importantes (ejemplo de multiplicación)
    val importantEmails: Int = 2
    val stars: Int = importantEmails * 2 // Multiplicación: cada correo importante recibe 2 estrellas
    println("Total de estrellas asignadas: $stars") // Muestra 4

    // Dividimos los correos en 3 carpetas (ejemplo de división)
    val folders: Int = 3
    val emailsPerFolder: Int = totalEmails / folders // División entera
    println("Correos por carpeta: $emailsPerFolder") // Muestra 3

    // Obtenemos el resto de correos que no caben en las carpetas (módulo)
    val remainder: Int = totalEmails % folders // Módulo: obtiene el residuo de la división
    println("Correos restantes sin carpeta: $remainder") // Muestra 2

    // Incremento y decremento
    totalEmails++ // Incrementa en 1
    println("Total de correos tras incremento: $totalEmails") // Muestra 12

    totalEmails-- // Decrementa en 1
    println("Total de correos tras decremento: $totalEmails") // Muestra 11
}
