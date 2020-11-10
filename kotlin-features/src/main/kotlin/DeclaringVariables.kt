fun main(array: Array<String>) {

    println("Welcome to Kotlin!")

    // 1. Mutable Variables
    var age = 40
    var name = "Abc"

    println("Age: $age, Name: $name")

    age = 30
    name = "Kotlin"

    println("Age: $age, Name: $name")

    // 2. Read-only Variables
    val phone = "12345"
    val address = "Kathmandu, Nepal"

    println("Phone: $phone, Address: $address")

    // Constants Variables -> NOT ALLOWED for local type
    println("Price: ${price(10)}")
}

// 3. Constants
const val rate = 20

fun price(quantity: Int): Int {
    return quantity * rate
}