package class_05


fun main() {
    val a = 10
    val b = 3

    // Addition
    val sum = a + b // 13
    // Subtraction
    val difference = a - b // 7
    // Multiplication
    val product = a * b // 30
    // Division (integer division)
    val quotient = a / b // 3
    // Modulus (remainder)
    val remainder = a % b // 1

    println("Sum: $sum")
    println("Difference: $difference")
    println("Product: $product")
    println("Quotient: $quotient")
    println("Remainder: $remainder")


    val numberString = "123"
    val number: Int = numberString.toInt() // String to Int

    val doubleValue: Double = number.toDouble() // Int to Double

    val booleanString = "true"
    val boolValue: Boolean = booleanString.toBoolean() // String to Boolean

    val intToString: String = number.toString() // Int to String

    println("String to Int: $number")
    println("Int to Double: $doubleValue")
    println("String to Boolean: $boolValue")
    println("Int to String: $intToString")
}