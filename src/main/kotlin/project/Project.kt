package project

import java.util.UUID

// ————————
// DOMAIN LAYER
// ————————

enum class Folder { INBOX, SENT, ARCHIVE, SPAM }

data class User(
    val id: UUID = UUID.randomUUID(),
    val username: String,
    private var password: String
) {
    fun authenticate(provided: String) =
        this.password == provided
}

data class Email(
    val id: UUID = UUID.randomUUID(),
    val ownerId: UUID,
    val from: String,
    val to: String,
    val subject: String,
    val body: String,
    var folder: Folder = Folder.INBOX,
    var isRead: Boolean = false
)

class UserNotFoundException(username: String) : RuntimeException("User '$username' not found.")
class AuthenticationException : RuntimeException("Credenciales inválidas.")
class EmailNotFoundException(id: UUID) : RuntimeException("Email $id no existe.")

// —————————————
// DOMAIN REPOSITORIES
// —————————————

interface UserRepository {
    fun save(user: User): Boolean
    fun findByUsername(username: String): User?
}

interface EmailRepository {
    fun save(email: Email)
    fun findByOwner(ownerId: UUID): List<Email>
    fun findById(id: UUID): Email?
    fun delete(id: UUID)
}

// —————————————————————————
// IN-MEMORY IMPLEMENTATIONS
// —————————————————————————

class InMemoryUserRepository : UserRepository {
    private val users = mutableListOf<User>()
    override fun save(user: User) = users.add(user)
    override fun findByUsername(username: String) =
        users.firstOrNull { it.username == username }
}

class InMemoryEmailRepository : EmailRepository {
    private val emails = mutableListOf<Email>()
    override fun save(email: Email) {
        emails.removeIf { it.id == email.id }
        emails.add(email)
    }
    override fun findByOwner(ownerId: UUID) =
        emails.filter { it.ownerId == ownerId }
    override fun findById(id: UUID) =
        emails.firstOrNull { it.id == id }
    override fun delete(id: UUID) {
        if (!emails.removeIf { it.id == id })
            throw EmailNotFoundException(id)
    }
}

// ——————————
// APPLICATION SERVICE
// ——————————

class InboxService(
    private val users: UserRepository,
    private val emails: EmailRepository
) {
    fun register(username: String, password: String) {
        if (users.findByUsername(username) != null)
            throw RuntimeException("Usuario ya existe.")
        users.save(User(username = username, password = password))
    }

    fun login(username: String, password: String): User {
        val user = users.findByUsername(username)
            ?: throw UserNotFoundException(username)
        if (!user.authenticate(password))
            throw AuthenticationException()
        return user
    }

    /**
     * Envía correo: sólo al SENT del remitente y al INBOX
     * del destinatario si existe.
     */
    fun sendMail(user: User, toUsername: String, subject: String, body: String) {
        // 1) Guardar en SENT del remitente
        val sent = Email(
            ownerId = user.id,
            from = user.username,
            to = toUsername,
            subject = subject,
            body = body,
            folder = Folder.SENT
        )
        emails.save(sent)

        // 2) Si el destinatario existe, agregar a su INBOX
        users.findByUsername(toUsername)?.let { recipient ->
            val inboxMail = sent.copy(
                id = UUID.randomUUID(),
                ownerId = recipient.id,
                folder = Folder.INBOX,
                isRead = false
            )
            emails.save(inboxMail)
        }
    }

    /** Simula que alguien te envía un correo directamente a tu INBOX */
    fun receiveMail(user: User, from: String, subject: String, body: String) {
        val mail = Email(
            ownerId = user.id,
            from = from,
            to = user.username,
            subject = subject,
            body = body,
            folder = Folder.INBOX
        )
        emails.save(mail)
    }

    fun listByFolder(user: User, folder: Folder): List<Email> =
        emails.findByOwner(user.id).filter { it.folder == folder }

    fun markAsRead(user: User, emailId: UUID) {
        val mail = emails.findById(emailId)
            ?: throw EmailNotFoundException(emailId)
        if (mail.ownerId != user.id) throw EmailNotFoundException(emailId)
        mail.isRead = true
        emails.save(mail)
    }

    fun moveToFolder(user: User, emailId: UUID, folder: Folder) {
        val mail = emails.findById(emailId)
            ?: throw EmailNotFoundException(emailId)
        if (mail.ownerId != user.id) throw EmailNotFoundException(emailId)
        mail.folder = folder
        emails.save(mail)
    }

    fun deleteMail(user: User, emailId: UUID) {
        val mail = emails.findById(emailId)
            ?: throw EmailNotFoundException(emailId)
        if (mail.ownerId != user.id) throw EmailNotFoundException(emailId)
        emails.delete(emailId)
    }
}

// ——————————
// CONSOLE UI
// ——————————

fun main() {
    val userRepo = InMemoryUserRepository()
    val emailRepo = InMemoryEmailRepository()
    val service  = InboxService(userRepo, emailRepo)

    println("=== Inbox Simulator ===")

    // Registro y login
    print("Regístrate (usuario): ")
    val u = readLine()!!.trim()
    print("Regístrate (clave): ")
    val p = readLine()!!.trim()
    service.register(u, p)

    print("Login (usuario): ")
    val u2 = readLine()!!.trim()
    print("Login (clave): ")
    val p2 = readLine()!!.trim()
    val currentUser = try {
        service.login(u2, p2)
    } catch (e: Exception) {
        println("ERROR: ${e.message}")
        return
    }

    loop@ while (true) {
        println("""
            |--- Menú ---
            |1) Enviar correo
            |2) Listar carpeta
            |3) Marcar leído
            |4) Mover carpeta
            |5) Eliminar correo
            |6) Recibir correo simulado
            |7) Salir
        """.trimMargin())

        try {
            when (readLine()?.trim()) {
                "1" -> {
                    print("Para (usuario): "); val to = readLine()!!.trim()
                    print("Asunto: ");        val subj = readLine()!!.trim()
                    print("Cuerpo: ");        val body = readLine()!!.trim()
                    service.sendMail(currentUser, to, subj, body)
                    println("Correo enviado.")
                }
                "2" -> {
                    print("Carpeta (INBOX/SENT/ARCHIVE/SPAM): ")
                    val f = Folder.valueOf(readLine()!!.trim().uppercase())
                    val list = service.listByFolder(currentUser, f)
                    if (list.isEmpty()) println("— Vacío —")
                    else list.forEach {
                        println("${it.id} | [${it.folder}] ${it.subject} (Leído=${it.isRead})")
                    }
                }
                "3" -> {
                    print("ID a marcar leído: "); val id = UUID.fromString(readLine()!!.trim())
                    service.markAsRead(currentUser, id)
                    println("Marcado como leído.")
                }
                "4" -> {
                    print("ID a mover: ");    val idm = UUID.fromString(readLine()!!.trim())
                    print("Nueva carpeta: ");  val nf = Folder.valueOf(readLine()!!.trim().uppercase())
                    service.moveToFolder(currentUser, idm, nf)
                    println("Correo movido.")
                }
                "5" -> {
                    print("ID a eliminar: "); val ide = UUID.fromString(readLine()!!.trim())
                    service.deleteMail(currentUser, ide)
                    println("Correo eliminado.")
                }
                "6" -> {
                    print("De (usuario): ");   val from = readLine()!!.trim()
                    print("Asunto: ");         val rSubj = readLine()!!.trim()
                    print("Cuerpo: ");         val rBody = readLine()!!.trim()
                    service.receiveMail(currentUser, from, rSubj, rBody)
                    println("Correo recibido en INBOX.")
                }
                "7" -> {
                    println("¡Adiós!")
                    break@loop
                }
                else -> println("Opción inválida.")
            }
        } catch (e: Exception) {
            println("ERROR: ${e.message}")
        }
    }
}
