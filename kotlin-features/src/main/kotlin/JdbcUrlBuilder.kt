import java.lang.IllegalArgumentException

// Builder for Jdbc URL
class JdbcUrlBuilder {

    var env: Env? = null
    var user: String? = null
    var password: String? = null
    var host: String? = null
    var database: String? = null

    inline fun with(env: () -> Env) {
        this.env = env()
    }

    inline fun withUser(user: () -> String) {
        this.user = user()
    }

    inline fun withHost(host: () -> String) {
        this.host = host()
    }

    inline fun withPassword(password: () -> String) {
        this.password = password()
    }

    inline fun withDatabase(database: () -> String) {
        this.database = database()
    }

    fun build() = JdbcUrl(
            when (env!!.value) {
                "postgres" -> "jdbc:postgresql://${host}/${database}"
                "oracle" -> "jdbc:oracle:thin:@${host}:${database}"
                else -> throw IllegalArgumentException("Invalid Environment!")
            },
            user!!,
            password!!
    )
}

// DSL which will create the JdbcUrlBuilder and build the JdbcUrl 
fun jdbcUrl(func: JdbcUrlBuilder.() -> Unit) =
        JdbcUrlBuilder()
                .apply(func)
                .build()

// Data classes
data class JdbcUrl(val jdbcUrl: String, val user: String, val password: String)

data class Env(val value: String)

fun main(args: Array<String>) {

    println(
            jdbcUrl {
                with { Env("postgres") }
                withDatabase { "example" }
                withHost { "localhost:5765" }
                withUser { "user" }
                withPassword { "password" }
            }
    )

    println(
            jdbcUrl {
                with { Env("oracle") }
                withDatabase { "XE" }
                withHost { "localhost:5765" }
                withUser { "user" }
                withPassword { "password" }
            }
    )
}