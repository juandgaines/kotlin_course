package class_22

/**
 * CLASE 22: VISIBILITY MODIFIERS
 * 
 * Conceptos:
 * - public (por defecto) - accesible desde cualquier lugar
 * - private - solo dentro de la misma clase
 * - protected - solo en la clase y sus subclases
 * - internal - solo dentro del mismo módulo
 */

// ==========================================
// 1. Ejemplo con Email
// ==========================================

open class Email(
    val subject: String,                    // public - accesible desde afuera
    private val password: String,           // private - solo dentro de Email
    protected var isEncrypted: Boolean = false  // protected - para subclases
) {
    // public - método accesible desde afuera
    fun send(): String {
        encrypt()  // Llamar método privado
        return "Email '${subject}' enviado"
    }
    
    // private - solo para uso interno
    private fun encrypt() {
        isEncrypted = true
        println("Email encriptado con password: ${hidePassword()}")
    }
    
    // private - ocultar lógica interna
    private fun hidePassword(): String {
        return "*".repeat(password.length)
    }
    
    // protected - para que las subclases puedan usarlo
    protected fun decrypt() {
        isEncrypted = false
    }
}

// ==========================================
// 2. Subclase usando protected
// ==========================================

class SecureEmail(
    subject: String,
    password: String
) : Email(subject, password, true) {
    
    // Puede usar métodos protected de la clase padre
    fun forceDecrypt() {
        decrypt()  // Método protected de Email
        println("Email desencriptado forzadamente")
    }
}

// ==========================================
// 3. Internal - solo en el mismo módulo
// ==========================================

internal class EmailConfig {
    internal val maxSize = 1024
    internal fun getSettings() = "Configuración interna"
}

fun main() {
    println("=== VISIBILITY MODIFIERS ===")
    
    // ==========================================
    // 4. Usando public
    // ==========================================
    
    println("\n=== PUBLIC ===")
    val email = Email("Reunión", "secreto123")
    
    // ✅ Podemos acceder a propiedades y métodos public
    println("Asunto: ${email.subject}")
    println(email.send())
    
    // ❌ No podemos acceder a private
    // println(email.password)      // Error de compilación
    // email.encrypt()              // Error de compilación
    
    // ❌ No podemos acceder a protected desde afuera
    // email.decrypt()              // Error de compilación
    
    // ==========================================
    // 5. Usando protected en subclase
    // ==========================================
    
    println("\n=== PROTECTED ===")
    val secureEmail = SecureEmail("Confidencial", "ultra-secreto")
    println(secureEmail.send())
    secureEmail.forceDecrypt()  // Usa método protected internamente
    
    // ==========================================
    // 6. Usando internal
    // ==========================================
    
    println("\n=== INTERNAL ===")
    val config = EmailConfig()
    println("Tamaño máximo: ${config.maxSize}")
    println(config.getSettings())
    
    // ==========================================
    // 7. Cuándo usar cada uno
    // ==========================================
    
    println("\n=== CUÁNDO USAR CADA UNO ===")
    println("• PUBLIC: APIs, métodos principales")
    println("• PRIVATE: Lógica interna, validaciones")
    println("• PROTECTED: Métodos para subclases")
    println("• INTERNAL: Clases de configuración, utilidades")
    
    // ==========================================
    // EJERCICIO
    // ==========================================
    
    println("\n=== EJERCICIO ===")
    println("Crea clase 'BankAccount' con:")
    println("1. balance (private)")
    println("2. deposit() (public)")
    println("3. validateAmount() (private)")
    
    // Solución:
    /*
    class BankAccount(private var balance: Double) {
        
        fun deposit(amount: Double): String {
            return if (validateAmount(amount)) {
                balance += amount
                "Depósito exitoso. Balance: $balance"
            } else {
                "Cantidad inválida"
            }
        }
        
        private fun validateAmount(amount: Double): Boolean {
            return amount > 0
        }
        
        fun getBalance(): Double = balance
    }
    
    val account = BankAccount(100.0)
    println(account.deposit(50.0))
    println("Balance: ${account.getBalance()}")
    */
}

/**
 * RESUMEN:
 * - public: acceso desde cualquier lugar (por defecto)
 * - private: solo dentro de la misma clase
 * - protected: clase y subclases
 * - internal: mismo módulo/proyecto
 */

