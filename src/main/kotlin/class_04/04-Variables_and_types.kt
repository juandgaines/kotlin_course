package class_04

fun main() {
    // Mutable variable: can be changed
    var age: Int = 25
    age = 26 // OK

    // Immutable variable: cannot be changed after assignment
    val name: String = "Alice"
    // name = "Bob" // Error: Val cannot be reassigned

    // Other basic types
    val pi: Double = 3.1416
    val isActive: Boolean = true

    println("Name: $name, Age: $age, Pi: $pi, Active: $isActive")
}