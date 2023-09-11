import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.springframework.expression.ExpressionParser
import org.springframework.expression.spel.standard.SpelExpressionParser

fun main() {
    val server = embeddedServer(Netty, port = 8080) {
        routing {
            get("/evaluate-spel") {
                val parser: ExpressionParser = SpelExpressionParser()
                val expressionString = call.request.queryParameters["expression"]
                val expression = parser.parseExpression(expressionString)
                val result = expression.value
                call.respondText("The result of the SpEL expression is: $result")
            }
        }
    }
    server.start(wait = true)
}
