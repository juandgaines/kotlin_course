package class_25

import java.time.LocalDateTime

// Sealed class for email states
sealed class EmailState {
    data class Draft(
        val subject: String,
        val body: String,
        val lastModified: LocalDateTime = LocalDateTime.now()
    ) : EmailState()
    
    data class Sent(
        val recipient: String,
        val sentAt: LocalDateTime = LocalDateTime.now()
    ) : EmailState()
    
    data class Delivered(
        val recipient: String,
        val deliveredAt: LocalDateTime = LocalDateTime.now()
    ) : EmailState()
    
    data class Read(
        val recipient: String,
        val readAt: LocalDateTime = LocalDateTime.now()
    ) : EmailState()
    
    data class Failed(
        val error: String,
        val failedAt: LocalDateTime = LocalDateTime.now()
    ) : EmailState()
}

// Sealed class for email operations
sealed class EmailOperation {
    object Send : EmailOperation()
    object Delete : EmailOperation()
    object Archive : EmailOperation()
    data class MoveToFolder(val folderName: String) : EmailOperation()
    data class MarkAsRead(val readAt: LocalDateTime = LocalDateTime.now()) : EmailOperation()
}

// Data class for our examples
data class Email(
    val id: String,
    val subject: String,
    val sender: String,
    val body: String,
    var state: EmailState = EmailState.Draft(subject, body)
)

// Class to handle email state transitions
class EmailStateManager {
    fun processOperation(email: Email, operation: EmailOperation): Boolean {
        return when (operation) {
            is EmailOperation.Send -> handleSend(email)
            is EmailOperation.Delete -> handleDelete(email)
            is EmailOperation.Archive -> handleArchive(email)
            is EmailOperation.MoveToFolder -> handleMoveToFolder(email, operation.folderName)
            is EmailOperation.MarkAsRead -> handleMarkAsRead(email, operation.readAt)
        }
    }
    
    private fun handleSend(email: Email): Boolean {
        return when (email.state) {
            is EmailState.Draft -> {
                email.state = EmailState.Sent("recipient@example.com")
                true
            }
            else -> false
        }
    }
    
    private fun handleDelete(email: Email): Boolean {
        return when (email.state) {
            is EmailState.Draft -> true
            else -> false
        }
    }
    
    private fun handleArchive(email: Email): Boolean {
        return when (email.state) {
            is EmailState.Read -> true
            else -> false
        }
    }
    
    private fun handleMoveToFolder(email: Email, folderName: String): Boolean {
        return when (email.state) {
            is EmailState.Draft -> true
            else -> false
        }
    }
    
    private fun handleMarkAsRead(email: Email, readAt: LocalDateTime): Boolean {
        return when (email.state) {
            is EmailState.Delivered -> {
                email.state = EmailState.Read("recipient@example.com", readAt)
                true
            }
            else -> false
        }
    }
}

fun main() {
    // Create an email in draft state
    val email = Email(
        "1",
        "Meeting",
        "sender@example.com",
        "Let's meet tomorrow"
    )
    
    println("Initial state: ${email.state}")
    
    // Create state manager
    val stateManager = EmailStateManager()
    
    // Try different operations
    println("\nTrying to send email:")
    if (stateManager.processOperation(email, EmailOperation.Send)) {
        println("Email sent successfully")
    } else {
        println("Failed to send email")
    }
    
    println("\nTrying to mark as read:")
    if (stateManager.processOperation(email, EmailOperation.MarkAsRead())) {
        println("Email marked as read")
    } else {
        println("Failed to mark as read")
    }
    
    // Example that will be used in our email project
    class EmailManager(
        private val stateManager: EmailStateManager
    ) {
        fun processEmail(email: Email, operation: EmailOperation) {
            when (operation) {
                is EmailOperation.Send -> {
                    if (stateManager.processOperation(email, operation)) {
                        println("Email sent to ${(email.state as EmailState.Sent).recipient}")
                    } else {
                        println("Cannot send email in current state: ${email.state}")
                    }
                }
                is EmailOperation.MarkAsRead -> {
                    if (stateManager.processOperation(email, operation)) {
                        println("Email marked as read at ${operation.readAt}")
                    } else {
                        println("Cannot mark email as read in current state: ${email.state}")
                    }
                }
                else -> {
                    if (stateManager.processOperation(email, operation)) {
                        println("Operation ${operation::class.simpleName} successful")
                    } else {
                        println("Operation ${operation::class.simpleName} failed")
                    }
                }
            }
        }
    }
    
    // Using EmailManager
    println("\nEmail Manager Example:")
    val manager = EmailManager(stateManager)
    
    // Create a new email
    val newEmail = Email(
        "2",
        "New Draft",
        "sender@example.com",
        "This is a new draft"
    )
    
    // Try different operations
    manager.processEmail(newEmail, EmailOperation.Send)
    manager.processEmail(newEmail, EmailOperation.MarkAsRead())
    manager.processEmail(newEmail, EmailOperation.Archive)
} 