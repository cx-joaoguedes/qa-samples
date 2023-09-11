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
                val payload = call.parameters["payload"]
                val bais = ByteArrayInputStream(payload)
                val ois = ObjectInputStream(bais)
                try {
                val oops = ois.readObject() // Vulnerable
                } catch (e: Exception) {
                e.printStackTrace()
                }
            }
        }
    }
    server.start(wait = true)
}
