import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import java.io.ObjectInputStream
import java.io.ByteArrayInputStream

data class MyObject(val name: String, val age: Int)

fun main() {
    val server = embeddedServer(Netty, port = 8080) {
        install(ContentNegotiation) {
            register(ContentType.Application.OctetStream, ByteArrayConverter())
        }
        routing {
            post("/object") {
                val bytes = call.receive<ByteArray>()
                val inputStream = ByteArrayInputStream(bytes)
                val ois = ObjectInputStream(inputStream)
                val obj = ois.readObject() as MyObject
                call.respond(HttpStatusCode.OK, obj)
            }
        }
    }
    server.start(wait = true)
}
