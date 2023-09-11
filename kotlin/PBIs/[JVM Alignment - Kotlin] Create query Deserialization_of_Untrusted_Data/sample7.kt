import com.fasterxml.jackson.databind.ObjectMapper
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import java.io.ByteArrayInputStream

data class MyObject(val name: String, val age: Int)

fun main() {
    val objectMapper = ObjectMapper()
    val server = embeddedServer(Netty, port = 8080) {
        install(ContentNegotiation) {
            jackson()
        }
        routing {
            post("/object") {
                val json = call.receive<String>()
                val inputStream = ByteArrayInputStream(json.toByteArray())
                val obj = objectMapper.readValue(inputStream, MyObject::class.java)
                call.respond(HttpStatusCode.OK, obj)
            }
        }
    }
    server.start(wait = true)
}
