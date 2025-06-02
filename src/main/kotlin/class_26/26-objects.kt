package class_26

import java.time.LocalDateTime

// Singleton object for email configuration
object EmailConfig {
    const val MAX_ATTACHMENT_SIZE = 10 * 1024 * 1024 // 10MB
    const val MAX_RECIPIENTS = 100
    const val DEFAULT_TIMEOUT = 30 // seconds
    
    private var isDebugMode = false
    
    fun enableDebugMode() {
        isDebugMode = true
    }
    
    fun disableDebugMode() {
        isDebugMode = false
    }
    
    fun log(message: String) {
        if (isDebugMode) {
            println("[DEBUG] $message")
        }
    }
}

// Object for email validation
object EmailValidator {
    private val EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)\$".toRegex()
    
    fun isValidEmail(email: String): Boolean {
        return EMAIL_REGEX.matches(email)
    }
    
    fun isValidSubject(subject: String): Boolean {
        return subject.isNotEmpty() && subject.length <= 100
    }
    
    fun isValidBody(body: String): Boolean {
        return body.isNotEmpty() && body.length <= 10000
    }
}

// Data class with companion object
data class Email(
    val id: String,
    val subject: String,
    val sender: String,
    val body: String,
    val timestamp: LocalDateTime = LocalDateTime.now()
) {
    companion object {
        private var nextId = 1
        
        fun create(subject: String, sender: String, body: String): Email {
            if (!EmailValidator.isValidEmail(sender)) {
                throw IllegalArgumentException("Invalid sender email")
            }
            if (!EmailValidator.isValidSubject(subject)) {
                throw IllegalArgumentException("Invalid subject")
            }
            if (!EmailValidator.isValidBody(body)) {
                throw IllegalArgumentException("Invalid body")
            }
            
            return Email(
                id = "email_${nextId++}",
                subject = subject,
                sender = sender,
                body = body
            )
        }
        
        fun createDraft(subject: String, sender: String): Email {
            return create(subject, sender, "")
        }
    }
}

// Class with companion object
class EmailService {
    companion object {
        private val services = mutableMapOf<String, EmailService>()
        
        fun getInstance(name: String): EmailService {
            return services.getOrPut(name) { EmailService(name) }
        }
        
        fun getTotalServices(): Int = services.size
    }
    
    private val name: String
    
    private constructor(name: String) {
        this.name = name
    }
    
    fun sendEmail(email: Email) {
        EmailConfig.log("Sending email from service: $name")
        println("Sending email: ${email.subject}")
    }
}

fun main() {
    // Using EmailConfig singleton
    println("Max attachment size: ${EmailConfig.MAX_ATTACHMENT_SIZE}")
    EmailConfig.enableDebugMode()
    EmailConfig.log("Debug mode enabled")
    
    // Using EmailValidator object
    val validEmail = "test@example.com"
    val invalidEmail = "invalid-email"
    
    println("\nEmail validation:")
    println("$validEmail is valid: ${EmailValidator.isValidEmail(validEmail)}")
    println("$invalidEmail is valid: ${EmailValidator.isValidEmail(invalidEmail)}")
    
    // Using Email companion object
    try {
        val email = Email.create(
            subject = "Test",
            sender = "sender@example.com",
            body = "Hello world"
        )
        println("\nCreated email: ${email.id}")
        
        val draft = Email.createDraft(
            subject = "Draft",
            sender = "sender@example.com"
        )
        println("Created draft: ${draft.id}")
    } catch (e: IllegalArgumentException) {
        println("Error creating email: ${e.message}")
    }
    
    // Using EmailService companion object
    val service1 = EmailService.getInstance("Gmail")
    val service2 = EmailService.getInstance("Outlook")
    val service3 = EmailService.getInstance("Gmail") // Returns existing instance
    
    println("\nTotal services: ${EmailService.getTotalServices()}")
    
    // Example that will be used in our email project
    class EmailManager {
        private val service = EmailService.getInstance("Default")
        
        fun sendEmail(subject: String, sender: String, body: String) {
            try {
                val email = Email.create(subject, sender, body)
                service.sendEmail(email)
                println("Email sent successfully")
            } catch (e: IllegalArgumentException) {
                println("Failed to send email: ${e.message}")
            }
        }
        
        fun createDraft(subject: String, sender: String) {
            try {
                val draft = Email.createDraft(subject, sender)
                println("Draft created: ${draft.id}")
            } catch (e: IllegalArgumentException) {
                println("Failed to create draft: ${e.message}")
            }
        }
    }
    
    // Using EmailManager
    println("\nEmail Manager Example:")
    val manager = EmailManager()
    
    manager.sendEmail(
        subject = "Valid Email",
        sender = "valid@example.com",
        body = "This is a valid email"
    )
    
    manager.sendEmail(
        subject = "Invalid Email",
        sender = "invalid-email",
        body = "This should fail"
    )
    
    manager.createDraft(
        subject = "New Draft",
        sender = "draft@example.com"
    )
} 