import java.lang.IllegalArgumentException
import java.util.concurrent.ConcurrentHashMap

// Type aliases

class Sale(private val quantity: Int, private val status: Status) {

    init {
        if (quantity < 1) {
            throw IllegalArgumentException("Invalid Quantity!")
        }
    }

    enum class Status {
        PLACED, PAYMENT_RECEIVED, DELIVERED
    }

    override fun toString(): String {
        return "Sale(quantity=$quantity, status=$status)"
    }

}

// It's useful to shorten long types.

typealias Status = Sale.Status

typealias Sales = ConcurrentHashMap<String, Sale>

// Demo
fun main(args: Array<String>) {

    val sales = Sales()
    sales["1"] = Sale(10, Status.DELIVERED)
    sales["2"] = Sale(20, Status.PAYMENT_RECEIVED)
    sales["3"] = Sale(30, Status.PLACED)

    println(
            sales
    )


}
