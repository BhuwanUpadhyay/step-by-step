fun main(args: Array<String>) {
    multiValue()
    nullSafety()
    useDataClass()
}

// 1. Multi-value return function
data class Tour(val name: String, val noOfTourist: Int)

fun trip(tour: Tour): Tour {
    return Tour(tour.name, tour.noOfTourist)
}

fun multiValue() {
    val (name, noOfTourist) = trip(Tour("Chitlang", 10))
    println(name)
    println(noOfTourist)
}

// 2. Null safety

fun nullSafety() {
    var name: String? = "K.P. Oli"
    println(name)

    name = null
    println(name?.length) // No more NPE

}

//3. Data class

data class Person(internal val name: String, internal val age: Int)

fun useDataClass() {
    val person = Person("Ram", 22)
    println(person)
}



