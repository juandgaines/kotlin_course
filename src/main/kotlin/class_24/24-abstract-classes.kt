package class_24

import java.time.LocalDateTime

// Abstract base class for email processing
abstract class EmailProcessor {
    // Abstract property that must be implemented
    abstract val processorName: String
    
    // Abstract method that must be implemented
    abstract fun process(email: Email): Boolean
    
    // Concrete method with default implementation
    fun validateEmail(email: Email): Boolean {
        return email.subject.isNotEmpty() && 
               email.sender.contains("@") && 
               email.body.isNotEmpty()
    }
    
    // Protected method for logging
    protected fun log(message: String) {
        println("[$processorName] $message")
    }
}

// Abstract class with constructor parameters
abstract class EmailService(
    protected val maxRetries: Int = 3
) {
    // Abstract property
    abstract val serviceName: String
    
    // Abstract method
    abstract fun sendEmail(email: Email): Boolean
    
    // Concrete method using abstract property
    fun getServiceInfo(): String {
        return "Service: $serviceName (Max retries: $maxRetries)"
    }
    
    // Protected method with default implementation
    protected open fun handleFailure(email: Email, attempt: Int) {
        println("Failed to send email after $attempt attempts")
    }
}

// Data class for our examples
data class Email(
    val id: String,
    val subject: String,
    val sender: String,
    val body: String,
    val timestamp: LocalDateTime = LocalDateTime.now()
)

// Concrete implementation of EmailProcessor
class SpamFilterProcessor : EmailProcessor() {
    override val processorName = "SpamFilter"
    
    override fun process(email: Email): Boolean {
        if (!validateEmail(email)) {
            log("Invalid email format")
            return false
        }
        
        val isSpam = email.subject.contains("SPAM") || 
                     email.body.contains("buy now") ||
                     email.sender.contains("spam")
        
        if (isSpam) {
            log("Detected spam email: ${email.subject}")
            return false
        }
        
        log("Email passed spam filter: ${email.subject}")
        return true
    }
}

// Concrete implementation of EmailService
class SecureEmailService : EmailService(maxRetries = 5) {
    override val serviceName = "SecureEmail"
    
    override fun sendEmail(email: Email): Boolean {
        var attempts = 0
        while (attempts < maxRetries) {
            attempts++
            if (attempts > 1) {
                log("Retry attempt $attempts")
            }
            
            if (trySendEmail(email)) {
                log("Email sent successfully")
                return true
            }
        }
        
        handleFailure(email, attempts)
        return false
    }
    
    private fun trySendEmail(email: Email): Boolean {
        // Simulate email sending
        return Math.random() > 0.3 // 70% success rate
    }
    
    // Override the failure handler
    override fun handleFailure(email: Email, attempt: Int) {
        super.handleFailure(email, attempt)
        log("Please check your connection and try again")
    }
    
    private fun log(message: String) {
        println("[$serviceName] $message")
    }
}

fun main() {
    // Using EmailProcessor
    val spamFilter = SpamFilterProcessor()
    
    val validEmail = Email(
        "1",
        "Meeting",
        "colleague@company.com",
        "Let's discuss the project"
    )
    
    val spamEmail = Email(
        "2",
        "SPAM: Buy now!",
        "spam@example.com",
        "Buy now and get 50% off!"
    )
    
    println("Processing valid email:")
    spamFilter.process(validEmail)
    
    println("\nProcessing spam email:")
    spamFilter.process(spamEmail)
    
    // Using EmailService
    val emailService = SecureEmailService()
    println("\n${emailService.getServiceInfo()}")
    
    println("\nSending emails:")
    emailService.sendEmail(validEmail)
    emailService.sendEmail(spamEmail)
    
    // Example that will be used in our email project
    class EmailManager(
        private val processor: EmailProcessor,
        private val service: EmailService
    ) {
        fun processAndSendEmail(email: Email) {
            if (processor.process(email)) {
                if (service.sendEmail(email)) {
                    println("Email processed and sent successfully")
                } else {
                    println("Failed to send email")
                }
            } else {
                println("Email rejected by processor")
            }
        }
    }
    
    // Using EmailManager
    println("\nEmail Manager Example:")
    val manager = EmailManager(spamFilter, emailService)
    
    manager.processAndSendEmail(validEmail)
    manager.processAndSendEmail(spamEmail)
} 