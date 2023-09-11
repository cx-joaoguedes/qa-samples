import io.ktor.application.*
import io.ktor.features.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.mvel.*
import io.ktor.jackson.*
import java.util.*

fun main() {
    embeddedServer(Netty, port = 8080) {
        install(ContentNegotiation) {
            json()
        }
        install(MVEL) {
            // Configure MVEL here
        }
        routing {
            get("/{name}") {
                val name = call.parameters["name"]
                val greeting = call.resolveExpression("\${\"Hello, $name!\"}") // This is vulnerable as user input is not sanitized
                call.respond(greeting)
            }

             get("/expression") {
                val expression = call.parameters["expression"]
                val result = call.resolveExpression(expression) // This is vulnerable as user input expression is not validated
                call.respond(result)
            }
        }
    }.start(wait = true)
}