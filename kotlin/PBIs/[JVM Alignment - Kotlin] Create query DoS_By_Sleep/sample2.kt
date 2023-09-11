import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.coroutines.delay

fun main(args: Array<String>) {
    val port = System.getenv("PORT")?.toInt() ?: 8080
    embeddedServer(Netty, port) {
        routing {
            get("/sleep") {
                val sleepTime = call.request.queryParameters["time"]?.toLongOrNull() ?: 1000
                delay(sleepTime)
                call.respondText("Slept for $sleepTime ms")
            }
        }
    }.start(wait = true)
}
