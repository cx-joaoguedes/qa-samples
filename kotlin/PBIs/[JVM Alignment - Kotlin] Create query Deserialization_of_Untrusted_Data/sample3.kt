import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.ObjectInputStream

data class MyObject(val name: String, val age: Int)

fun main() {
    val server = embeddedServer(Netty, port = 8080) {
        install(ContentNegotiation) {
            json()
        }
        routing {
            post("/object") {
                val inputStream = call.receive<InputStream>()
                val ois = ObjectInputStream(inputStream)
                val obj: MyObject = ois.readObject() as MyObject
                call.respond(HttpStatusCode.OK, obj)
            }
        }
    }
    server.start(wait = true)
}
