import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import java.net.ServerSocket
import java.net.Socket

fun main() {
    val port = 8080
    val server = embeddedServer(Netty, port) {
        routing {
            get("/socket/{port}") {
                val resourcePort = call.parameters["port"]?.toInt() ?: return@get call.respond(HttpStatusCode.BadRequest)
                val serverSocket = ServerSocket(resourcePort)
                val socket = serverSocket.accept()
                call.respondText("Socket resource allocated on port $resourcePort.")
            }
        }
    }
    server.start(wait = true)
}
